package com.lesniewicz.api.controler.graphql;

import com.lesniewicz.api.dto.FilmDto;
import com.lesniewicz.api.service.FilmService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@AllArgsConstructor
public class FilmResolver implements GraphQLQueryResolver {
    private final FilmService filmService;

    public List<FilmDto> films() {
        log.info("GraphQL::getAllFilms()");
        return filmService.getAllFilms();
    }

}
