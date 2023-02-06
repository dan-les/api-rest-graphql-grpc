package com.lesniewicz.api.dto;


import java.math.BigDecimal;
import java.util.List;

public record FilmDto(Integer filmId,
                      String title,
                      String description,
                      Integer releaseYear,
                      Integer rentalDuration,
                      BigDecimal rentalRate,
                      Integer length,
                      BigDecimal replacementCost,
                      String rating,
                      String specialFeatures,
                      String lastUpdate,
                      String language,
                      List<ActorDto> actor

) {
}