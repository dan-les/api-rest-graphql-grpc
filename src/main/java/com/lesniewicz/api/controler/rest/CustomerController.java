package com.lesniewicz.api.controler.rest;


import com.lesniewicz.api.dto.CustomerDto;
import com.lesniewicz.api.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/rest", produces = "application/json")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/customer")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<CustomerDto> getAllCustomers() {
        log.info("REST::getAllCustomers()");
        return customerService.getAllCustomers();
    }

}
