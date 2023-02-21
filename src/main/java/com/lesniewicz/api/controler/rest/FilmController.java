package com.lesniewicz.api.controler.rest;


import com.lesniewicz.api.dto.FilmRequest;
import com.lesniewicz.api.dto.FilmResponse;
import com.lesniewicz.api.service.FilmService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/rest", produces = "application/json")
public class FilmController {
    private final FilmService filmService;

    @GetMapping("/film/{filmId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public FilmResponse getAllLanguages(@PathVariable Long filmId) {
        log.info("REST::getFilmById()");
        return filmService.getFilmById(filmId);
    }

    @GetMapping("/film")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<FilmResponse> getAllFilms() {
        log.info("REST::getAllFilms()");
        return filmService.getAllFilms();
    }

    @PostMapping("/film")
    public FilmResponse addFilm(@Valid @RequestBody FilmRequest filmRequest) {
        return filmService.addFilm(filmRequest);
    }

}
