package com.przybylo.BookApp.controller;

import com.przybylo.BookApp.model.Book;
import com.przybylo.BookApp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class Hello {

    @Autowired
    private BookService bs;

    @GetMapping("app/hello")
    @ResponseBody
    private String hello(){
        return "Is it me you looking for";
    }

    @GetMapping("app/book/json")
    @ResponseBody
    private String getJSONString(){
        return bs.getJSONBookList();
    }

    @GetMapping("app/book/all")
    @ResponseBody
    private String getListOfBooks(){
        List<Book> books = bs.getBookList();
        return books.toString();
    }
}
