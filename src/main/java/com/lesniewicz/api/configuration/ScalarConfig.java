package com.lesniewicz.api.configuration;

import graphql.scalars.ExtendedScalars;
import graphql.schema.GraphQLScalarType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ScalarConfig {

    @Bean
    public GraphQLScalarType data() {
        return ExtendedScalars.Date;
    }

    // TODO: 14.02.2023 BigDecimal is not working
//    @Bean
//    public GraphQLScalarType xd() {
//        return ExtendedScalars.GraphQLBigDecimal;
//    }
}
