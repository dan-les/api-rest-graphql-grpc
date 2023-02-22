package com.lesniewicz.api.service;

import com.lesniewicz.api.dto.FilmRequest;
import com.lesniewicz.api.dto.FilmResponse;
import com.lesniewicz.api.entity.Film;
import com.lesniewicz.api.exception.ApiExperimentException;
import com.lesniewicz.api.exception.Error;
import com.lesniewicz.api.mapper.ExperimentMapper;
import com.lesniewicz.api.repository.FilmRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class FilmService {
    private final FilmRepository filmRepository;
    private final LanguageService languageService;
    private final ExperimentMapper experimentMapper;
    private final ActorService actorService;

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
        film.setLanguage(languageService.retrieveLanguageByName(filmRequest.language()));
        film.setActors(actorService.retrieveActorsByIds(filmRequest.actorsIds()));

        film = filmRepository.save(film);
        return experimentMapper.mapToFilmDto(film);
    }


}
