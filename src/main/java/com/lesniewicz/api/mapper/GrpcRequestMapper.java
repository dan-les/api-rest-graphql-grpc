package com.lesniewicz.api.mapper;

import com.lesniewicz.api.CreateFilmRequest;
import com.lesniewicz.api.entity.Film;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Component
public class GrpcRequestMapper {

    public Film buildFilm(CreateFilmRequest request) {
        Film film = new Film();
        film.setTitle(request.getTitle());
        film.setDescription(request.getDescription());
        film.setReleaseYear(request.getReleaseYear());
        film.setRentalDuration(request.getRentalDuration());
        film.setRentalRate(BigDecimal.valueOf(request.getRentalRate()));
        film.setLength(request.getLength());
        film.setReplacementCost(BigDecimal.valueOf(request.getReplacementCost()));
        film.setRating(request.getRating());
        film.setSpecialFeatures(request.getSpecialFeatures());
        film.setLastUpdate(OffsetDateTime.now());
        return film;
    }


}
