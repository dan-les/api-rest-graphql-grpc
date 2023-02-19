package com.lesniewicz.api.controler.graphql;

import com.lesniewicz.api.dto.LanguageResponse;
import com.lesniewicz.api.service.LanguageService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Slf4j
@Component
@AllArgsConstructor
public class LanguageResolver implements GraphQLQueryResolver {
    private final LanguageService languageService;

    public LanguageResponse language(@NotNull String languageId) {
        log.info("GraphQL::getLanguageById()");
        return languageService.getLanguagesById(Long.parseLong(languageId));
    }

    public List<LanguageResponse> languages(String name,
                                            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate lastUpdate) {
        log.info("GraphQL::getAllLanguages()");
        return languageService.getAllLanguagesWithFilters(name, lastUpdate);
    }

}
