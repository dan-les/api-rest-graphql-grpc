package com.lesniewicz.api.controler.rest;


import com.lesniewicz.api.dto.FilmDto;
import com.lesniewicz.api.service.FilmService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/rest", produces = "application/json")
public class FilmController {
    private final FilmService filmService;

    @GetMapping("/film")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<FilmDto> getAllFilms() {
        log.info("REST::getAllFilms()");
        return filmService.getAllFilms();
    }

}
