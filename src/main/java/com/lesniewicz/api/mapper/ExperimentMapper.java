package com.lesniewicz.api.mapper;

import com.lesniewicz.api.dto.ActorResponse;
import com.lesniewicz.api.dto.CustomerResponse;
import com.lesniewicz.api.dto.FilmDto;
import com.lesniewicz.api.dto.LanguageResponse;
import com.lesniewicz.api.entity.Actor;
import com.lesniewicz.api.entity.Customer;
import com.lesniewicz.api.entity.Film;
import com.lesniewicz.api.entity.Language;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExperimentMapper {

    public LanguageResponse mapToLanguageDto(Language language) {
        return new LanguageResponse(language.getLanguageId(), language.getName(), language.getLastUpdate().toLocalDate());
    }

    public FilmDto mapToFilmDto(Film film) {
        return new FilmDto(
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
}
