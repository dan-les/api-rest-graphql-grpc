package com.lesniewicz.api.grpcService;

import com.lesniewicz.api.*;
import com.lesniewicz.api.entity.Language;
import com.lesniewicz.api.exception.ApiExperimentException;
import com.lesniewicz.api.exception.Error;
import com.lesniewicz.api.mapper.GrpcResponseMapper;
import com.lesniewicz.api.repository.LanguageRepository;
import com.lesniewicz.api.utils.ApiUtils;
import graphql.com.google.common.base.Strings;
import io.grpc.stub.StreamObserver;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

import java.time.LocalDate;

@Slf4j
@GrpcService
@AllArgsConstructor
public class LanguageGrpcService extends LanguageGrpcServiceGrpc.LanguageGrpcServiceImplBase {
    private final LanguageRepository languageRepository;
    private final ApiUtils apiUtils;
    private final GrpcResponseMapper grpcResponseMapper;

    @Override
    public void getLanguage(LanguageRequest request,
                            StreamObserver<SingleLanguageResponse> responseObserver) {
        log.info("gRPC::getLanguage()");

        Language language = languageRepository.findById(Long.parseLong(request.getLanguageId()))
                .orElseThrow(() -> new ApiExperimentException(Error.LANGUAGE_NOT_FOUND));

        SingleLanguageResponse singleLanguageResponse = grpcResponseMapper.buildSingleLanguageResponse(language);
        responseObserver.onNext(singleLanguageResponse);
        responseObserver.onCompleted();
    }

    @Override
    public void getLanguages(LanguagesRequest request, StreamObserver<LanguagesResponse> responseObserver) {
        log.info("gRPC::getLanguages()");
        LanguagesResponse.Builder languagesResponseBuilder = LanguagesResponse.newBuilder();

        LocalDate lastUpdateDate = apiUtils.retrieveLocalDate(request.getLastUpdate());
        String name = Strings.emptyToNull(request.getName());

        languageRepository.findLanguagesWithFilters(name, lastUpdateDate).stream()
                .map(grpcResponseMapper::buildSingleLanguageResponse)
                .forEach(languagesResponseBuilder::addLanguages);

        LanguagesResponse languagesResponse = languagesResponseBuilder.build();
        responseObserver.onNext(languagesResponse);
        responseObserver.onCompleted();
    }
}
