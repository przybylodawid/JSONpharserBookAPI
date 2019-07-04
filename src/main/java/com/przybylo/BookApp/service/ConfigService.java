package com.przybylo.BookApp.service;

import com.przybylo.BookApp.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class ConfigService {

    @Autowired
    private Config config;
    @Autowired
    private BookService bs;

    public void initializeConfig(HttpServletRequest request) {
        config.setPath(request.getParameter("filepath"));
        config.setType(request.getParameter("type"));
        if (config.getType() == null || config.getPath() == null) {
            config.setType("link");
            config.setPath("https://www.googleapis.com/books/v1/volumes?q=java&maxResults=40");
        }
        bs.initializeBookList();
    }
}
