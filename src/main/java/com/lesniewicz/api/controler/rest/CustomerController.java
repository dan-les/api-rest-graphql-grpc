package com.lesniewicz.api.controler.rest;


import com.lesniewicz.api.dto.CustomerResponse;
import com.lesniewicz.api.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/rest/customer", produces = "application/json")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    @ResponseBody
    public List<CustomerResponse> getAllCustomers() {
        log.info("REST::getAllCustomers()");
        return customerService.getAllCustomers();
    }

}
