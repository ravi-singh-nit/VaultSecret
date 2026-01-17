package com.sammu.learning.springbootDemo.controllers;

import com.sammu.learning.springbootDemo.component.TestA;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    @Autowired
    TestA testA;

    @GetMapping("/greeting")
    public String welcome(){
        System.out.println(testA);
        return "Hello world";
    }


    @PostConstruct
    public void postConstruct(){
        System.out.println("Test a is "+testA);
    }



}
