package com.lesniewicz.api.exception;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.lesniewicz.api.dto.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.time.DateTimeException;
import java.util.List;
import java.util.Set;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = ApiExperimentException.class)
    public ResponseEntity<Message> handleException(ApiExperimentException exception) {
        var httpStatus = exception.getError().getHttpStatus();
        var message = exception.getError().getMessage();

        if (message != null) {
            return ResponseEntity.status(httpStatus).body(new Message(message));
        } else {
            return ResponseEntity.status(httpStatus).build();
        }
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity<Message> handleConstraintViolationException(ConstraintViolationException ex) {
        Set<ConstraintViolation<?>> result = ex.getConstraintViolations();
        List<String> errors = result.stream()
                .map(ConstraintViolation::getMessage)
                .toList();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new Message(errors.toString()));
    }

    // Exception can be thrown during parsing request body
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseEntity<Message> handleMessageNotReadableException(HttpMessageNotReadableException ex) {
        Throwable cause = ex.getMostSpecificCause();

        if (cause instanceof DateTimeException) {
            return ResponseEntity.status(Error.INVALID_DATE_FORMAT.getHttpStatus())
                    .body(new Message(Error.INVALID_DATE_FORMAT.getMessage()));
        } else if ((cause instanceof JsonParseException) || (cause instanceof InvalidFormatException)) {
            return ResponseEntity.status(Error.INVALID_JSON_FORMAT.getHttpStatus())
                    .body(new Message(Error.INVALID_JSON_FORMAT.getMessage()));
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
