package com.lesniewicz.api.controler.graphql;

import com.lesniewicz.api.dto.FilmRequest;
import com.lesniewicz.api.dto.FilmResponse;
import com.lesniewicz.api.service.FilmService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Slf4j
@Component
@AllArgsConstructor
public class FilmMutationResolver implements GraphQLMutationResolver {
    private final FilmService filmService;

    public FilmResponse createFilm(@NotNull FilmRequest filmRequest) {
        log.info("GraphQL::createFilm()");
        return filmService.addFilm(filmRequest);
    }

    public FilmResponse film(@NotNull String filmId) {
        log.info("GraphQL::getFilmById()");
        return filmService.getFilmById(Long.parseLong(filmId));
    }

}
