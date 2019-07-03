package com.przybylo.BookApp.service;

import com.google.gson.Gson;
import com.przybylo.BookApp.model.Book;
import com.przybylo.BookApp.model.JsonPharser.BookJSON;
import com.przybylo.BookApp.model.JsonPharser.Libery;
import com.przybylo.BookApp.tools.JsonReciver;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private List<Book> bookList;

    public BookService(){
        bookList = new ArrayList<>();

        JsonReciver jsonReciver = new JsonReciver();
        String jsonString = jsonReciver.reciveJSON("test");
        Gson gson = new Gson();

        Libery libery = gson.fromJson(jsonString, Libery.class);
        List<BookJSON> booksJSON = libery.getItems();
        for (BookJSON bookJSON: booksJSON) {
            Book book = new Book();
            book.mapFromJson(bookJSON);
            bookList.add(book);
        }

    }

    public String getJSONBookList(){
        JsonReciver jsonReciver = new JsonReciver();
        return jsonReciver.reciveJSON("test");
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }



}
