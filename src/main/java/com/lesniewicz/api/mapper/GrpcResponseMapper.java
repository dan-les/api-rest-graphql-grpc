package com.lesniewicz.api.mapper;

import com.lesniewicz.api.ActorsResponse;
import com.lesniewicz.api.SingleActorResponse;
import com.lesniewicz.api.SingleFilmResponse;
import com.lesniewicz.api.SingleLanguageResponse;
import com.lesniewicz.api.entity.Actor;
import com.lesniewicz.api.entity.Film;
import com.lesniewicz.api.entity.Language;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class GrpcResponseMapper {

    @NotNull
    public SingleLanguageResponse buildSingleLanguageResponse(Language language) {
        return SingleLanguageResponse.newBuilder()
                .setLanguageId(language.getLanguageId())
                .setName(language.getName())
                .setLastUpdate(language.getLastUpdate().toLocalDate().toString())
                .build();
    }

    public SingleFilmResponse buildSingleFilmResponse(Film film) {
        return SingleFilmResponse.newBuilder()
                .setFilmId(film.getFilmId())
                .setTitle(film.getTitle())
                .setDescription(film.getDescription())
                .setReleaseYear(film.getReleaseYear())
                .setRentalDuration(film.getRentalDuration())
                .setRentalRate(film.getRentalRate().floatValue())
                .setLength(film.getLength())
                .setReplacementCost(film.getReplacementCost().floatValue())
                .setRating(film.getRating())
                .setSpecialFeatures(film.getSpecialFeatures())
                .setLastUpdate(film.getLastUpdate().toString())
                .setLanguage(film.getLanguage().getName())
                .setActors(buildActorsResponse(film.getActors()))
                .build();
    }

    private ActorsResponse buildActorsResponse(Set<Actor> actors) {
        ActorsResponse.Builder actorsResponseBuilder = ActorsResponse.newBuilder();

        actors.stream()
                .map(this::buildSingleActorResponse)
                .forEach(actorsResponseBuilder::addActors);

        return actorsResponseBuilder.build();
    }

    private SingleActorResponse buildSingleActorResponse(Actor actor) {
        return SingleActorResponse.newBuilder()
                .setActorId(actor.getActorId())
                .setFirstName(actor.getFirstName())
                .setLastName(actor.getLastName())
                .build();
    }
}