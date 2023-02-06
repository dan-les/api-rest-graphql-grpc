package com.lesniewicz.api.controler.graphql;

import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class CustomerGraphQLController implements GraphQLQueryResolver {

    public String hello() {
        return "Hello, world, GraphQL!";
    }

}
