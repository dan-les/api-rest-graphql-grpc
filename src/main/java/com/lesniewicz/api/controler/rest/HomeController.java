package com.lesniewicz.api.controler.rest;


import com.lesniewicz.api.dto.FilmDto;
import com.lesniewicz.api.dto.LanguageDto;
import com.lesniewicz.api.mapper.ExperimentMapper;
import com.lesniewicz.api.repository.FilmRepository;
import com.lesniewicz.api.repository.InventoryRepository;
import com.lesniewicz.api.repository.LanguageRepository;
import javax.persistence.*;
import javax.transaction.Transactional;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class HomeController {

    private final LanguageRepository languageRepository;
    private final InventoryRepository inventoryRepository;
    private final FilmRepository filmRepository;
    private final ExperimentMapper experimentMapper;

    @GetMapping("/")
    @ResponseBody
    public String index() {
        return "Hello World!";
    }

    @Transactional
    @GetMapping("/language")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<LanguageDto> getAllLanguages() {
        return languageRepository.findAll().stream()
                .map(experimentMapper::mapToLanguageDto)
                .toList();
    }

    @Transactional
    @GetMapping("/film")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<FilmDto> getAllFilms() {
        Pageable limit = PageRequest.of(0, 10);
//        return filmRepository.findAll(limit).getContent();
        return filmRepository.findAll(limit).stream()
                .map(experimentMapper::mapToFilmDto)
                .toList();
    }


}
