package com.example.lab11.command.rest;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Products")
public class ProductCommandController {

    public String createProduct(){
        return "Crete Product";
    }
}
