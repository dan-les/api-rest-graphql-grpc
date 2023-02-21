package com.lesniewicz.api.mapper;

import com.lesniewicz.api.dto.*;
import com.lesniewicz.api.entity.Actor;
import com.lesniewicz.api.entity.Customer;
import com.lesniewicz.api.entity.Film;
import com.lesniewicz.api.entity.Language;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

@Component
public class ExperimentMapper {

    public LanguageResponse mapToLanguageDto(Language language) {
        return new LanguageResponse(language.getLanguageId(), language.getName(), language.getLastUpdate().toLocalDate());
    }

    public FilmResponse mapToFilmDto(Film film) {
        return new FilmResponse(
                film.getFilmId(),
                film.getTitle(),
                film.getDescription(),
                film.getReleaseYear(),
                film.getRentalDuration(),
                film.getRentalRate().floatValue(),
                film.getLength(),
                film.getReplacementCost().floatValue(),
                film.getRating(),
                film.getSpecialFeatures(),
                film.getLastUpdate().toString(),
                film.getLanguage().getName(),
                retrieveActors(film)
        );
    }

    private List<ActorResponse> retrieveActors(Film film) {
        return film.getActors().stream()
                .map(this::toActorDto)
                .toList();
    }

    public ActorResponse toActorDto(Actor actor) {
        return new ActorResponse(actor.getActorId(), actor.getFirstName(), actor.getLastName());
    }

    public CustomerResponse mapToCustomerDto(Customer customer) {
        return new CustomerResponse(
                customer.getCustomerId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getActive(),
                customer.getCreateDate().toLocalDate(),
                customer.getLastUpdate().toLocalDate()
        );
    }

    public Film mapToFilm(FilmRequest filmRequest) {
        Film film = new Film();
        film.setTitle(filmRequest.title());
        film.setDescription(filmRequest.description());
        film.setReleaseYear(filmRequest.releaseYear());
        film.setRentalDuration(filmRequest.rentalDuration());
        film.setRentalRate(BigDecimal.valueOf(filmRequest.rentalRate()));
        film.setLength(filmRequest.length());
        film.setReplacementCost(BigDecimal.valueOf(filmRequest.replacementCost()));
        film.setRating(filmRequest.rating());
        film.setSpecialFeatures(filmRequest.specialFeatures());
        film.setLastUpdate(OffsetDateTime.now());

        return film;
    }
}
