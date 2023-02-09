package com.lesniewicz.api.grpcService;

import com.google.protobuf.Empty;
import com.lesniewicz.api.LanguageGrpcServiceGrpc;
import com.lesniewicz.api.LanguageRequest;
import com.lesniewicz.api.LanguagesResponse;
import com.lesniewicz.api.SingleLanguageResponse;
import com.lesniewicz.api.entity.Language;
import com.lesniewicz.api.exception.ApiExperimentException;
import com.lesniewicz.api.exception.Error;
import com.lesniewicz.api.repository.LanguageRepository;
import io.grpc.stub.StreamObserver;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import org.jetbrains.annotations.NotNull;

@Slf4j
@GrpcService
@AllArgsConstructor
public class LanguageGrpcService extends LanguageGrpcServiceGrpc.LanguageGrpcServiceImplBase {
    private final LanguageRepository languageRepository;

    @NotNull
    private static SingleLanguageResponse buildSingleLanguageResponse(Language language) {
        return SingleLanguageResponse.newBuilder()
                .setLanguageId(language.getLanguageId())
                .setName(language.getName())
                .setLastUpdate(language.getLastUpdate().toLocalDate().toString())
                .build();
    }

    @Override
    public void getLanguage(LanguageRequest request,
                            StreamObserver<SingleLanguageResponse> responseObserver) {
        log.info("gRPC::getLanguage()");

        Language language = languageRepository.findById(Long.parseLong(request.getLanguageId()))
                .orElseThrow(() -> new ApiExperimentException(Error.LANGUAGE_NOT_FOUND));

        SingleLanguageResponse singleLanguageResponse = buildSingleLanguageResponse(language);
        responseObserver.onNext(singleLanguageResponse);
        responseObserver.onCompleted();
    }

    @Override
    public void getLanguages(Empty request, StreamObserver<LanguagesResponse> responseObserver) {
        log.info("gRPC::getLanguages()");
        LanguagesResponse.Builder languagesResponseBuilder = LanguagesResponse.newBuilder();

        languageRepository.findAll().stream()
                .map(LanguageGrpcService::buildSingleLanguageResponse)
                .forEach(languagesResponseBuilder::addLanguages);

        LanguagesResponse languagesResponse = languagesResponseBuilder.build();
        responseObserver.onNext(languagesResponse);
        responseObserver.onCompleted();
    }
}
