package com.przybylo.BookApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Hello {

    @GetMapping("app/hello")
    @ResponseBody
    private String hello(){
        return "Is it me you looking for";
    }
}
