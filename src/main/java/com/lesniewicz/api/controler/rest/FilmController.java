package com.lesniewicz.api.controler.rest;


import com.lesniewicz.api.dto.FilmDto;
import com.lesniewicz.api.service.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/rest", produces = "application/json")
public class FilmController {
    private final FilmService filmService;

    @GetMapping("/film")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<FilmDto> getAllFilms() {
        return filmService.getAllFilms();
    }

}
