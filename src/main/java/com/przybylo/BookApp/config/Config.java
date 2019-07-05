package com.przybylo.BookApp.config;

import com.przybylo.BookApp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//          This class contains an config object that was given by user
//          on endpoint config from form in index.html


@Component
public class Config {
    @Autowired
    private BookService bs;


    private String path;
    private String type;


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
