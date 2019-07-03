package com.przybylo.BookApp.controller;

import com.przybylo.BookApp.model.Book;
import com.przybylo.BookApp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    @RequestMapping(value="api/book/{ISBN}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    private String getBookByISBN(@PathVariable String ISBN){
        return bs.bookToJSON(bs.findBookByISBN(ISBN));

    }
    // not nessesary
    @GetMapping(value="api/book/404")
    @ResponseBody
    private String error404(){
        return "404 - ELEMENT NOT FOUND";
    }

    @RequestMapping(value="api/category/{categoryName}/books", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    private String getBooksWithCategory(@PathVariable String categoryName){
        return bs.bookListToJSON(bs.findBookWithCategory(categoryName));
    }

    @RequestMapping (value="api/search", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    private String getBooksContainingPhrase(HttpServletRequest request){
        return bs.bookListToJSON(bs.getBookListWithPhrase(request.getParameter("q")));

    }
}
