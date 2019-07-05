package com.przybylo.BookApp.controller;

import com.przybylo.BookApp.model.Book;
import com.przybylo.BookApp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Class for testing server health. Few additional endpoinds:
//      - api/hello
//      - api/book/json
//      - api/book/all
//      - api/book/404

@Controller
public class Hello {

    @Autowired
    private BookService bs;

    @GetMapping("api/hello")
    @ResponseBody
    private String hello(){
        return "Is it me you looking for";
    }

    @GetMapping("api/book/json")
    @ResponseBody
    private String getJSONString(){
        return bs.getJSONBookList();
    }

    @RequestMapping(value="api/book/all", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    private String getListOfBooks(){
        List<Book> books = bs.getBookList();
        return bs.bookListToJSON(books);
    }

    // not nessesary
    @GetMapping(value="api/book/nonexisting")
    @ResponseBody
    private String error404(){
        return "404 \"No results found\"";
    }




}
