package com.example.bookservice.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/recommended")
public class ServiceController {

    @GetMapping
    public String getBook(){
        return "Spring in Action (Manning), Cloud Native Java (0'Reilly), Learning Spring Boot (Packt)" ;
    }
}
