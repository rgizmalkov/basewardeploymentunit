package com.gmail.rgizmalkov.edu.dissertation.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/health")
public class HealthCheckController {

    @GetMapping
    public @ResponseBody String ping(){
        return "pong";
    }
}
