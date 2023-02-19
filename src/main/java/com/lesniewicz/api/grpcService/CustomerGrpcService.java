package com.lesniewicz.api.grpcService;

import com.google.protobuf.Empty;
import com.lesniewicz.api.CustomerGrpcServiceGrpc;
import com.lesniewicz.api.CustomerResponse;
import com.lesniewicz.api.mapper.GrpcResponseMapper;
import com.lesniewicz.api.repository.CustomerRepository;
import io.grpc.stub.StreamObserver;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

@Slf4j
@GrpcService
@AllArgsConstructor
public class CustomerGrpcService extends CustomerGrpcServiceGrpc.CustomerGrpcServiceImplBase {
    private final CustomerRepository customerRepository;
    private final GrpcResponseMapper grpcResponseMapper;

    @Override
    public void getCustomers(Empty request, StreamObserver<CustomerResponse> responseObserver) {
        log.info("gRPC::getCustomers()");
        CustomerResponse.Builder customerResponseBuilder = CustomerResponse.newBuilder();

        customerRepository.findAll().stream()
                .map(grpcResponseMapper::buildSingleCustomerResponse)
                .forEach(customerResponseBuilder::addCustomers);

        CustomerResponse customerResponse = customerResponseBuilder.build();
        responseObserver.onNext(customerResponse);
        responseObserver.onCompleted();
    }
}
