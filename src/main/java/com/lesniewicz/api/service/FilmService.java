package com.lesniewicz.api.service;

import com.lesniewicz.api.dto.FilmDto;
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
    private final ExperimentMapper experimentMapper;

    @Transactional
    public List<FilmDto> getAllFilms() {
        return filmRepository.findAll().stream()
                .map(experimentMapper::mapToFilmDto)
                .toList();
    }
}
