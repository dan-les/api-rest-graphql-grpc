package com.lesniewicz.api.mapper;

import com.lesniewicz.api.dto.ActorDto;
import com.lesniewicz.api.dto.FilmDto;
import com.lesniewicz.api.dto.LanguageDto;
import com.lesniewicz.api.entity.Actor;
import com.lesniewicz.api.entity.Film;
import com.lesniewicz.api.entity.Language;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExperimentMapper {

    public LanguageDto mapToLanguageDto(Language language) {
        return new LanguageDto(language.getLanguageId(), language.getName(), language.getLastUpdate().toLocalDate());
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

    private List<ActorDto> retrieveActors(Film film) {
        return film.getActors().stream()
                .map(this::toActorDto)
                .toList();
    }

    public ActorDto toActorDto(Actor actor) {
        return new ActorDto(actor.getActorId(), actor.getFirstName(), actor.getLastName());
    }
}
