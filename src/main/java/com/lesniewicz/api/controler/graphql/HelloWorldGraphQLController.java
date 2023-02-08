package com.lesniewicz.api.controler.graphql;

import com.lesniewicz.api.dto.Message;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldGraphQLController implements GraphQLQueryResolver {

    public static final String HELLO_WORLD_MESSAGE = "Hello, world! It's response from GraphQL endpoint!";

    public Message hello() {
        return new Message(HELLO_WORLD_MESSAGE);
    }

}
