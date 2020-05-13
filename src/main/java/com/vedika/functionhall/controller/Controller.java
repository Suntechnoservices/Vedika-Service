package com.vedika.functionhall.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/login")
public class Controller {

    @GetMapping
    public String login() {
        return "welcome to  Vedika Application";
    }
}
