package com.lesniewicz.api.grpcService;

import com.lesniewicz.api.LanguageGrpcServiceGrpc;
import com.lesniewicz.api.LanguageRequest;
import com.lesniewicz.api.LanguageResponse;
import com.lesniewicz.api.entity.Language;
import com.lesniewicz.api.exception.ApiExperimentException;
import com.lesniewicz.api.exception.Error;
import com.lesniewicz.api.repository.LanguageRepository;
import io.grpc.stub.StreamObserver;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

@Slf4j
@GrpcService
@AllArgsConstructor
public class LanguageGrpcService extends LanguageGrpcServiceGrpc.LanguageGrpcServiceImplBase {
    private final LanguageRepository languageRepository;

    @Override
    public void getLanguage(LanguageRequest request,
                            StreamObserver<LanguageResponse> responseObserver) {
        log.info("gRPC::getLanguage()");
        Language language = languageRepository.findById(Long.parseLong(request.getLanguageId()))
                .orElseThrow(() -> new ApiExperimentException(Error.LANGUAGE_NOT_FOUND));

        LanguageResponse languageResponse =
                LanguageResponse.newBuilder()
                        .setLanguageId(language.getLanguageId())
                        .setName(language.getName())
                        .setLastUpdate(language.getLastUpdate().toLocalDate().toString())
                        .build();

        //set the response object
        responseObserver.onNext(languageResponse);
        //mark process is completed
        responseObserver.onCompleted();
    }
}
