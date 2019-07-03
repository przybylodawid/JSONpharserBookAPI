package com.przybylo.BookApp.service;

import com.google.gson.Gson;
import com.przybylo.BookApp.model.Book;
import com.przybylo.BookApp.model.JsonPharser.BookJSON;
import com.przybylo.BookApp.model.JsonPharser.Libery;
import com.przybylo.BookApp.tools.JsonReciver;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private List<Book> bookList;

    Gson gson = new Gson();

    // ============ CONSTRUCTOR ===============

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

    // ============ BOOK SERVICE METHODS ===============

    public Book findBookByISBN(String ISBN){
        for (Book book:bookList){
            if (book.getIsbn().equals(ISBN)){
                return book;
            }
        }
        return null;
    }

    public List<Book> findBookWithCategory(String categoryName) {
        List<Book> books = new ArrayList<>();
        for (Book book :bookList){
            List<String> categories = book.getCategories();
            if (categories!=null){
                for (String category: categories){
                    if(category.toLowerCase().equals(categoryName.toLowerCase())){
                        books.add(book);
                    }
                }
            }
        }
        return books;
    }




    // ============ GET JSON STRING ===============

    public String getJSONBookList(){
        JsonReciver jsonReciver = new JsonReciver();
        return jsonReciver.reciveJSON("test");
    }


    // ============ PARSING TO JSON ===============

    public String bookListToJSON(List<Book> books){
        if (books == null){
            List<Book> emptyList = new ArrayList<>();
            return gson.toJson(emptyList);
        }
        return gson.toJson(books);

    }

    public String bookToJSON(Book book){
        if (book != null){
            return gson.toJson(book);
            }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Error 404 - No book found matching criteria"
        );

    }

    // ============ SETTERS AND GETTER ===============
    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }



}
