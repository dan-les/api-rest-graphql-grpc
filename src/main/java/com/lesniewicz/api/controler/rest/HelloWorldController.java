package com.lesniewicz.api.controler.rest;


import com.lesniewicz.api.dto.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/rest", produces = "application/json")
public class HelloWorldController {

    public static final String HELLO_WORLD_MESSAGE = "Hello World! It's response from REST API endpoint!";

    @GetMapping("/hello")
    @ResponseBody
    public Message hello() {
        return new Message(HELLO_WORLD_MESSAGE);
    }

}
