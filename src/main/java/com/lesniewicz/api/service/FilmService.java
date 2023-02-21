package com.lesniewicz.api.service;

import com.lesniewicz.api.dto.FilmRequest;
import com.lesniewicz.api.dto.FilmResponse;
import com.lesniewicz.api.entity.Actor;
import com.lesniewicz.api.entity.Film;
import com.lesniewicz.api.exception.ApiExperimentException;
import com.lesniewicz.api.exception.Error;
import com.lesniewicz.api.mapper.ExperimentMapper;
import com.lesniewicz.api.repository.ActorRepository;
import com.lesniewicz.api.repository.FilmRepository;
import com.lesniewicz.api.repository.LanguageRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class FilmService {
    private final FilmRepository filmRepository;
    private final LanguageRepository languageRepository;
    private final ActorRepository actorRepository;
    private final ExperimentMapper experimentMapper;

    @Transactional
    public FilmResponse getFilmById(Long id) {
        return filmRepository.findById(id)
                .map(experimentMapper::mapToFilmDto)
                .orElseThrow(() -> new ApiExperimentException(Error.FILM_NOT_FOUND));
    }

    @Transactional
    public List<FilmResponse> getAllFilms() {
        return filmRepository.findAll().stream()
                .map(experimentMapper::mapToFilmDto)
                .toList();
    }

    @Transactional
    public FilmResponse addFilm(FilmRequest filmRequest) {
        Film film = experimentMapper.mapToFilm(filmRequest);

        buildLanguages(filmRequest, film);
        buildActors(filmRequest, film);

        film = filmRepository.save(film);
        return experimentMapper.mapToFilmDto(film);
    }

    private void buildLanguages(FilmRequest filmRequest, Film film) {
        languageRepository.findByName(filmRequest.language())
                .ifPresentOrElse(film::setLanguage, () -> {
                    throw new ApiExperimentException(Error.FILM_NOT_FOUND);
                });
    }

    private void buildActors(FilmRequest filmRequest, Film film) {
        Set<Actor> actors = filmRequest.actorIds().stream()
                .map(actorRepository::findById)
                .flatMap(Optional::stream)
                .collect(Collectors.toSet());
        film.setActors(actors);
    }
}
