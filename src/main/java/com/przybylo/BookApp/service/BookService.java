package com.przybylo.BookApp.service;

import com.google.gson.Gson;
import com.przybylo.BookApp.config.Config;
import com.przybylo.BookApp.model.Book;
import com.przybylo.BookApp.model.JsonPharser.BookJSON;
import com.przybylo.BookApp.model.JsonPharser.Libery;
import com.przybylo.BookApp.model.JsonPharser.LiberyFromFile;
import com.przybylo.BookApp.tools.JsonReader;
import com.przybylo.BookApp.tools.JsonReciver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private List<Book> bookList;

    @Autowired
    private JsonReciver jsonReciver;

    @Autowired
    private Config config;

    @Autowired
    private Gson gson;

    @Autowired
    private JsonReader jsonReader;

        public void initializeBookList(){
        bookList = new ArrayList<>();
        String jsonString;
        Libery libery;
        LiberyFromFile liberyFromFile;
        List<BookJSON> booksJSON;

            if (config.getType().equals("link")){
            jsonString = jsonReciver.reciveJSON(config.getPath());
            libery = gson.fromJson(jsonString, Libery.class);
            booksJSON = libery.getItems();

            }else{ //config.getType().equals("path")
            jsonString = jsonReader.getJSONStringFromFile(config.getPath());
            liberyFromFile = gson.fromJson(jsonString, LiberyFromFile.class);
            booksJSON = liberyFromFile.getItems();
            }





        for (BookJSON bookJSON : booksJSON) {
            Book book = new Book();
            book.mapFromJson(bookJSON);
            bookList.add(book);
        }
    }

    // ============ BOOK SERVICE METHODS ===============

    public Book findBookByISBN(String ISBN) {
        for (Book book : bookList) {
            if (book.getIsbn().equals(ISBN)) {
                return book;
            }
        }
        return null;
    }

    public List<Book> findBookWithCategory(String categoryName) {
        List<Book> books = new ArrayList<>();
        for (Book book : bookList) {
            List<String> categories = book.getCategories();
            if (categories != null) {
                for (String category : categories) {
                    if (category.toLowerCase().equals(categoryName.toLowerCase())) {
                        books.add(book);
                    }
                }
            }
        }
        return books;
    }

    // I could also use a Set to prevent double records in List.
    public List<Book> getBookListWithPhrase(String phrase) {
        List<Book> books = new ArrayList<>();
        phrase.replaceAll("%20", " ");
        List<String> words = Arrays.asList(phrase.split(" "));
        for (Book book : bookList) {
            for (String word : words) {
                if (gson.toJson(book).toLowerCase().contains(word.toLowerCase())) {
                    if(!books.contains(book)) {
                        books.add(book);
                    }
                }
            }
        }

        return books;
    }


    // ============ GET JSON STRING ===============

    public String getJSONBookList() {
        JsonReciver jsonReciver = new JsonReciver();
        return jsonReciver.reciveJSON("test");
    }


    // ============ PARSING TO JSON ===============

    public String bookListToJSON(List<Book> books) {
        if (books == null) {
            List<Book> emptyList = new ArrayList<>();
            return gson.toJson(emptyList);
        }
        return gson.toJson(books);

    }

    public String bookToJSON(Book book) {
        if (book != null) {
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
