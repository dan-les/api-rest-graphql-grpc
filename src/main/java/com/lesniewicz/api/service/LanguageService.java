package com.lesniewicz.api.service;

import com.lesniewicz.api.dto.LanguageDto;
import com.lesniewicz.api.exception.ApiExperimentException;
import com.lesniewicz.api.exception.Error;
import com.lesniewicz.api.mapper.ExperimentMapper;
import com.lesniewicz.api.repository.LanguageRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class LanguageService {
    private final LanguageRepository languageRepository;
    private final ExperimentMapper experimentMapper;

    @Transactional
    public LanguageDto getLanguagesById(long id) {
        log.info("Method called: getLanguagesById()");
        return languageRepository.findById(id)
                .map(experimentMapper::mapToLanguageDto)
                .orElseThrow(() -> new ApiExperimentException(Error.LANGUAGE_NOT_FOUND));
    }

    @Transactional
    public List<LanguageDto> getAllLanguagesWithFilters(String name, LocalDate lastUpdate) {
        log.info("Method called: getAllLanguagesWithFilters()");
        return languageRepository.findLanguagesWithFilters(name, lastUpdate).stream()
                .map(experimentMapper::mapToLanguageDto)
                .toList();
    }
}
