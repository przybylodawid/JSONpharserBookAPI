package com.przybylo.BookApp.controller;

import com.przybylo.BookApp.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RatingController {

    @Autowired
    private RatingService rs;

    @RequestMapping(value="api/rating", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    private String getListAuthorsByRating(){


        return "hi";
    }
}
