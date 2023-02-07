package com.lesniewicz.api.controler.rest;


import com.lesniewicz.api.dto.FilmDto;
import com.lesniewicz.api.mapper.ExperimentMapper;
import com.lesniewicz.api.repository.FilmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/rest", produces = "application/json")
public class FilmController {
    // TODO: 07.02.2023 replace with specific Service
    private final FilmRepository filmRepository;
    private final ExperimentMapper experimentMapper;

    @GetMapping("/film")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<FilmDto> getAllFilms() {
        return filmRepository.findAll().stream()
                .map(experimentMapper::mapToFilmDto)
                .toList();
    }


}
