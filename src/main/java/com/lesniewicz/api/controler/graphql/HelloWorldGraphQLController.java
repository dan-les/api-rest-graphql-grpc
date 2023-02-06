package com.lesniewicz.api.controler.graphql;

import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldGraphQLController implements GraphQLQueryResolver {

    public static final String HELLO_WORLD_MESSAGE = "Hello, world! It's response from GraphQL endpoint!";

    public String hello() {
        return HELLO_WORLD_MESSAGE;
    }

}
