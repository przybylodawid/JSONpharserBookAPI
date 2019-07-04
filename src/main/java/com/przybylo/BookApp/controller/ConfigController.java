package com.przybylo.BookApp.controller;

import com.przybylo.BookApp.config.Config;
import com.przybylo.BookApp.service.BookService;
import com.przybylo.BookApp.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ConfigController {

    @Autowired
    private ConfigService cs;

    @PostMapping("api/config")
    @ResponseBody
    private String getConfigInfo(HttpServletRequest request){
        cs.initializeConfig(request);
        return "Configuration DONE";
    }
}
