package com.example.camel.controller;

import lombok.RequiredArgsConstructor;
import org.apache.camel.ProducerTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/query")
@RequiredArgsConstructor
public class QueryController {

    private final ProducerTemplate producerTemplate;

    @PostMapping("/send")
    public void sendMessage(@RequestParam String message) { //TODO: write integration test
        producerTemplate
                .requestBody("direct:saveToPostgres", message, String.class);

    }
}
