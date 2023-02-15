package com.lesniewicz.api.grpcService;

import com.google.protobuf.Empty;
import com.lesniewicz.api.FilmGrpcServiceGrpc;
import com.lesniewicz.api.FilmsResponse;
import com.lesniewicz.api.mapper.GrpcResponseMapper;
import com.lesniewicz.api.repository.FilmRepository;
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

}
