package com.lesniewicz.api.dto;


import java.util.List;

public record FilmRequest(String title,
                          String description,
                          Integer releaseYear,
                          Integer rentalDuration,
                          Float rentalRate,
                          Integer length,
                          Float replacementCost,
                          String rating,
                          String specialFeatures,
                          String lastUpdate,
                          String language,
                          List<Long> actorIds

) {
}