package com.lesniewicz.api.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiExperimentException extends RuntimeException {
    private Error error;
}
