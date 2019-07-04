package com.przybylo.BookApp.controller;

import com.przybylo.BookApp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class BookController {

    @Autowired
    private BookService bs;

    @RequestMapping(value="api/book/{ISBN}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    private String getBookByISBN(@PathVariable String ISBN){
        return bs.bookToJSON(bs.findBookByISBN(ISBN));

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
