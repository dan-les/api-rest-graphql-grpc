package com.lesniewicz.api.configuration;


import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.serverfactory.GrpcServerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
@Configuration
public class GrpcServerExecutorConfiguration {

    public static final int MAX_CONCURRENT_CALLS = 10000;
    public static final int KEEP_ALIVE_TIME = 30;
    public static final int KEEP_ALIVE_TIMEOUT = 5;
    public static final int N_THREADS = 500;

    @Bean(destroyMethod = "shutdown")
    ExecutorService grpcExecutor() {
        return Executors.newFixedThreadPool(N_THREADS);
    }

    @Bean
    public GrpcServerConfigurer keepAliveServerConfigurer() {
        return serverBuilder -> {
            if (serverBuilder instanceof NettyServerBuilder) {
                log.info("GrpcServerConfigurer: Server executor was configured");
                ((NettyServerBuilder) serverBuilder)
                        .executor(grpcExecutor())
                        .maxConcurrentCallsPerConnection(MAX_CONCURRENT_CALLS)
                        .keepAliveTime(KEEP_ALIVE_TIME, TimeUnit.SECONDS)
                        .keepAliveTimeout(KEEP_ALIVE_TIMEOUT, TimeUnit.SECONDS)
                        .permitKeepAliveWithoutCalls(true);
            }
        };
    }
}