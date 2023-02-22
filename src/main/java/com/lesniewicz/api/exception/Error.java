package com.lesniewicz.api.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum Error {

    // Invalid format
    INVALID_DATE_FORMAT("Invalid date format", HttpStatus.BAD_REQUEST),
    INVALID_JSON_FORMAT("Invalid json format", HttpStatus.BAD_REQUEST),

    // Business exceptions
    ACTOR_NOT_FOUND("Actor not found", HttpStatus.NOT_FOUND),
    FILM_NOT_FOUND("Film not found", HttpStatus.NOT_FOUND),
    LANGUAGE_NOT_FOUND("Language not found", HttpStatus.NOT_FOUND);


    private final String message;
    private final HttpStatus httpStatus;
}
