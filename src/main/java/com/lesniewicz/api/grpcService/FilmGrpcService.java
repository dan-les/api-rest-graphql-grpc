package com.lesniewicz.api.grpcService;

import com.google.protobuf.Empty;
import com.lesniewicz.api.*;
import com.lesniewicz.api.entity.Film;
import com.lesniewicz.api.exception.ApiExperimentException;
import com.lesniewicz.api.exception.Error;
import com.lesniewicz.api.mapper.GrpcRequestMapper;
import com.lesniewicz.api.mapper.GrpcResponseMapper;
import com.lesniewicz.api.repository.FilmRepository;
import com.lesniewicz.api.service.ActorService;
import com.lesniewicz.api.service.LanguageService;
import io.grpc.stub.StreamObserver;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

import javax.transaction.Transactional;

@Slf4j
@GrpcService
@AllArgsConstructor
public class FilmGrpcService extends FilmGrpcServiceGrpc.FilmGrpcServiceImplBase {
    private final FilmRepository filmRepository;
    private final GrpcResponseMapper grpcResponseMapper;
    private final GrpcRequestMapper grpcRequestMapper;
    private final ActorService actorService;
    private final LanguageService languageService;

    @Override
    @Transactional
    public void getFilm(FilmRequest request, StreamObserver<SingleFilmResponse> responseObserver) {
        log.info("gRPC::getFilm()");

        SingleFilmResponse singleFilmResponse = filmRepository.findById(Long.parseLong(request.getFilmId()))
                .map(grpcResponseMapper::buildSingleFilmResponse)
                .orElseThrow(() -> new ApiExperimentException(Error.FILM_NOT_FOUND));

        responseObserver.onNext(singleFilmResponse);
        responseObserver.onCompleted();
    }

    @Override
    @Transactional
    public void getFilms(Empty request, StreamObserver<FilmsResponse> responseObserver) {
        log.info("gRPC::getFilms()");
        FilmsResponse.Builder filmResponseBuilder = FilmsResponse.newBuilder();

        filmRepository.findAll().stream()
                .map(grpcResponseMapper::buildSingleFilmResponse)
                .forEach(filmResponseBuilder::addLanguages);

        FilmsResponse filmsResponse = filmResponseBuilder.build();
        responseObserver.onNext(filmsResponse);
        responseObserver.onCompleted();
    }

    @Override
    public void createFilm(CreateFilmRequest request, StreamObserver<SingleFilmResponse> responseObserver) {
        log.info("gRPC::createFilm()");
        Film film = grpcRequestMapper.buildFilm(request);
        film.setLanguage(languageService.retrieveLanguageByName(request.getLanguage()));
        film.setActors(actorService.retrieveActorsByIds(request.getActorsIdsList()));

        film = filmRepository.save(film);

        SingleFilmResponse singleFilmResponse = grpcResponseMapper.buildSingleFilmResponse(film);
        responseObserver.onNext(singleFilmResponse);
        responseObserver.onCompleted();
    }

}
