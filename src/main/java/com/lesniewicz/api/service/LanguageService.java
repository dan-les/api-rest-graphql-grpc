package com.lesniewicz.api.service;

import com.lesniewicz.api.dto.LanguageResponse;
import com.lesniewicz.api.entity.Language;
import com.lesniewicz.api.exception.ApiExperimentException;
import com.lesniewicz.api.exception.Error;
import com.lesniewicz.api.mapper.ExperimentMapper;
import com.lesniewicz.api.repository.LanguageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class LanguageService {
    private final LanguageRepository languageRepository;
    private final ExperimentMapper experimentMapper;

    @Transactional
    public LanguageResponse getLanguagesById(long id) {
        return languageRepository.findById(id)
                .map(experimentMapper::mapToLanguageDto)
                .orElseThrow(() -> new ApiExperimentException(Error.LANGUAGE_NOT_FOUND));
    }

    @Transactional
    public List<LanguageResponse> getAllLanguagesWithFilters(String name, LocalDate lastUpdate) {
        return languageRepository.findLanguagesWithFilters(name, lastUpdate).stream()
                .map(experimentMapper::mapToLanguageDto)
                .toList();
    }

    @Transactional
    public Language retrieveLanguageByName(String languageName) {
        return languageRepository.findByName(languageName)
                .orElseThrow(() -> new ApiExperimentException(Error.LANGUAGE_NOT_FOUND));
    }

}
