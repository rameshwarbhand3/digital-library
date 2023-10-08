package com.ram.library.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@PropertySource("classpath:application.properties")
public class HelloController {
    @Value("${myapp.name}")
    private String myapp;

    @Value("${person.first-name}")
    private String first_name;

    @Value("${person.last-name}")
    private String last_name;

    @Value("${person.full-name}")
    private String full_name;


    @GetMapping("/api/details")
    public List<String> getDetails() {
        List<String> list = new ArrayList<>();
        list.add(myapp);
        list.add(first_name);
        list.add(last_name);
        list.add(full_name);

        return list;
    }
}
