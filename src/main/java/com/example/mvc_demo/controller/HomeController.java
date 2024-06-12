package com.example.mvc_demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class HomeController {
    @RequestMapping(value = {"/", "/home"})
    public String getHomePage(){
        return "home";
    }
}
