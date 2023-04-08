package com.lesniewicz.api.controler.rest;


import com.lesniewicz.api.dto.FilmRequest;
import com.lesniewicz.api.dto.FilmResponse;
import com.lesniewicz.api.service.FilmService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/rest/film", produces = "application/json")
public class FilmController {
    private final FilmService filmService;

    @GetMapping("/{filmId}")
    @ResponseBody
    public FilmResponse getFilmById(@PathVariable Long filmId) {
        log.info("REST::getFilmById()");
        return filmService.getFilmById(filmId);
    }

    @GetMapping
    @ResponseBody
    public List<FilmResponse> getAllFilms() {
        log.info("REST::getAllFilms()");
        return filmService.getAllFilms();
    }

    @PostMapping
    public FilmResponse createFilm(@Valid @RequestBody FilmRequest filmRequest) {
        log.info("REST::createFilm()");
        return filmService.addFilm(filmRequest);
    }

}
