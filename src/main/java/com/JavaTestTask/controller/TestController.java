package com.JavaTestTask.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/teste")
public class TestController {

    @GetMapping
    public String teste(){
        return "to vivo!";
    }
}
