package com.lesniewicz.api.controler.graphql;

import com.lesniewicz.api.dto.LanguageDto;
import com.lesniewicz.api.service.LanguageService;
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
    private final LanguageService languageService;

    public LanguageDto language(@NotNull String languageId) {
        return languageService.getLanguagesById(Long.parseLong(languageId));
    }

    public List<LanguageDto> languages(String name,
                                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate lastUpdate) {
        return languageService.getAllLanguagesWithFilters(name, lastUpdate);
    }

}
