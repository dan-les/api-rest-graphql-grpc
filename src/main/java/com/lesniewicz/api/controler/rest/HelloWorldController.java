package com.lesniewicz.api.controler.rest;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/rest", produces = "application/json")
public class HelloWorldController {

    @GetMapping("/")
    @ResponseBody
    public String index() {
        return "Hello World! It's response from REST API endpoint!";
    }

}
