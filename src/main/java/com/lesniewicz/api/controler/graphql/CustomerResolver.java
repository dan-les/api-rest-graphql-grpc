package com.lesniewicz.api.controler.graphql;

import com.lesniewicz.api.dto.CustomerDto;
import com.lesniewicz.api.service.CustomerService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@AllArgsConstructor
public class CustomerResolver implements GraphQLQueryResolver {
    private final CustomerService customerService;

    public List<CustomerDto> customers() {
        log.info("GraphQL::getAllCustomers()");
        return customerService.getAllCustomers();
    }

}
