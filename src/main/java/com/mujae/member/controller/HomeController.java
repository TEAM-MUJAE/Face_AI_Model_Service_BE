package com.mujae.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @GetMapping("/")
    public String Main(){
        System.out.println("눈ㄴㄴ난나나나");
        return "Main";
    }
}
