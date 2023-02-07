package com.lesniewicz.api.service;

import com.lesniewicz.api.dto.LanguageDto;
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
    public LanguageDto getLanguagesById(long id) {
        return languageRepository.findById(id)
                .map(experimentMapper::mapToLanguageDto)
                .orElse(null);
    }

    @Transactional
    public List<LanguageDto> getAllLanguagesWithFilters(String name, LocalDate lastUpdate) {
        return languageRepository.findLanguagesWithFilters(name, lastUpdate).stream()
                .map(experimentMapper::mapToLanguageDto)
                .toList();

    }
}
