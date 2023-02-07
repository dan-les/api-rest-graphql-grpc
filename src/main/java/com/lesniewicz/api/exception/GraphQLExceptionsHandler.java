package com.lesniewicz.api.exception;

import graphql.GraphQLException;
import graphql.kickstart.spring.error.ThrowableGraphQLError;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
public class GraphQLExceptionsHandler {

    /* generic GraphQLException */
    @ExceptionHandler(GraphQLException.class)
    public ThrowableGraphQLError handle(GraphQLException e) {
        return new ThrowableGraphQLError(e);
    }

    /* catching custom exceptions with type ApiExperimentException */
    @ExceptionHandler(ApiExperimentException.class)
    public ThrowableGraphQLError handle(ApiExperimentException e) {
        return new ThrowableGraphQLError(e, e.getError().getMessage());
    }
}
