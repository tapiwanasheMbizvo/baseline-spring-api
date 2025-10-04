package com.tapiwanashe.mbizvo.baseline.api.controllers;


import com.tapiwanashe.mbizvo.baseline.api.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/hello")
public class HelloWorld {


    @GetMapping
    public ApiResponse<String> helloWorld() {

        return  ApiResponse.<String>builder()
                .data("Sample Data")
                .status(HttpStatus.ACCEPTED)
                .message("Hello World!!")
                .timestamp(LocalDateTime.now())
                .build();
    }
}
