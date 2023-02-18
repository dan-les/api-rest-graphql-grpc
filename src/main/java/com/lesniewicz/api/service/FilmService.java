package com.lesniewicz.api.service;

import com.lesniewicz.api.dto.FilmDto;
import com.lesniewicz.api.entity.Film;
import com.lesniewicz.api.mapper.ExperimentMapper;
import com.lesniewicz.api.repository.FilmRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class FilmService {
    private final FilmRepository filmRepository;
    private final ExperimentMapper experimentMapper;

    @Transactional
    public List<FilmDto> getAllFilms() {
        System.out.println("Przed baza" + LocalDateTime.now());
        List<Film> all = filmRepository.findAll();
        System.out.println("Po bazie" + LocalDateTime.now());
        List<FilmDto> filmDtos = all.stream()
                .map(experimentMapper::mapToFilmDto)
                .toList();
        System.out.println("Po Dto" + LocalDateTime.now());
        return filmDtos;
    }
}
