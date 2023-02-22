package com.lesniewicz.api.dto;


import javax.validation.constraints.NotNull;
import java.util.List;

public record FilmRequest(@NotNull(message = "Field title cannot be null") String title,
                          @NotNull(message = "Field description cannot be null") String description,
                          @NotNull(message = "Field releaseYear cannot be null") Integer releaseYear,
                          @NotNull(message = "Field rentalDuration cannot be null") Integer rentalDuration,
                          @NotNull(message = "Field rentalRate cannot be null") Float rentalRate,
                          @NotNull(message = "Field length cannot be null") Integer length,
                          @NotNull(message = "Field replacementCost cannot be null") Float replacementCost,
                          @NotNull(message = "Field rating cannot be null") String rating,
                          @NotNull(message = "Field specialFeatures cannot be null") String specialFeatures,
                          @NotNull(message = "Field lastUpdate cannot be null") String lastUpdate,
                          @NotNull(message = "Field language cannot be null") String language,
                          @NotNull(message = "Field actorsIds cannot be null") List<Long> actorsIds

) {
}