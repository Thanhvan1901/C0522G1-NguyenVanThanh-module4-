package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/furama")
public class HomeController {

    @GetMapping(value = {"/home",""})
    public String goHome(){
        return "home";
    }
}
