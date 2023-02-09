package com.lesniewicz.api.exception;

import io.grpc.Status;
import net.devh.boot.grpc.server.advice.GrpcAdvice;
import net.devh.boot.grpc.server.advice.GrpcExceptionHandler;

import static io.grpc.internal.GrpcUtil.httpStatusToGrpcStatus;

@GrpcAdvice
public class GrpcExceptionAdvice {

    @GrpcExceptionHandler(ApiExperimentException.class)
    public Status handleResourceNotFoundException(ApiExperimentException e) {
        Error error = e.getError();
        return httpStatusToGrpcStatus(error.getHttpStatus().value())
                .withDescription(error.getMessage())
                .withCause(e);
    }

}