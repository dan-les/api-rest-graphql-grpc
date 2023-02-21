package com.lesniewicz.api.controler.graphql;

import com.lesniewicz.api.dto.FilmResponse;
import com.lesniewicz.api.service.FilmService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.List;

@Slf4j
@Component
@AllArgsConstructor
public class FilmResolver implements GraphQLQueryResolver {
    private final FilmService filmService;

    public FilmResponse film(@NotNull String filmId) {
        log.info("GraphQL::getFilmById()");
        return filmService.getFilmById(Long.parseLong(filmId));
    }

    public List<FilmResponse> films() {
        log.info("GraphQL::getAllFilms()");
        return filmService.getAllFilms();
    }

}
