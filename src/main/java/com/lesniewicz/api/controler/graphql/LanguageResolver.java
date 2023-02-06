package com.lesniewicz.api.controler.graphql;

import com.lesniewicz.api.dto.LanguageDto;
import com.lesniewicz.api.mapper.ExperimentMapper;
import com.lesniewicz.api.repository.LanguageRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Component
@AllArgsConstructor
public class LanguageResolver implements GraphQLQueryResolver {
    private final LanguageRepository languageRepository;
    private final ExperimentMapper experimentMapper;


    public LanguageDto language(@NotNull String languageId) {
        // TODO: 06.02.2023 use proper service/repository directly
        return languageRepository.findAll().stream()
                .filter(language -> language.getLanguageId().equals(Integer.parseInt(languageId)))
                .map(experimentMapper::mapToLanguageDto)
                .findFirst()
                .get();
    }

    public List<LanguageDto> languages(String languageId,
                                       String name,
                                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate lastUpdate) {
        // TODO: 06.02.2023 use proper service/repository directly
        return languageRepository.findAll().stream()
                .map(experimentMapper::mapToLanguageDto)
                .toList();
    }

}
