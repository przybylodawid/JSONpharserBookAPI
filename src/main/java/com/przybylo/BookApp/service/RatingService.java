package com.przybylo.BookApp.service;

import com.google.gson.Gson;
import com.przybylo.BookApp.model.Book;
import com.przybylo.BookApp.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RatingService {
    private List<Author> authorsList;

    @Autowired
    private BookService bs;
    @Autowired
    private Gson gson;


    // Get list of authors => Loop authors => For every author loop books, and check for the rating
    // If Author's book is rated (rating 0 or null means not rated) add Author with rating to the list
    public void initiateAuthorList() {
        authorsList = new ArrayList<>();
        //getting set of Authors first
        Set<String> authorNames = new HashSet<>();
        List<Book> books = bs.getBookList();
        if (books != null) {
            for (Book book : books) {
                if (book.getAuthors() != null) {
                    authorNames.addAll(book.getAuthors());
                }
            }
        }
        // Checking for author's books ratings
        for (String authorName : authorNames) {
            int bookCounter = 0;
            double ratingSum = 0;
                for (Book book : books) {
                    // I made assumption that Rate 0 = unrated
                    if (book.getAverageRating() != null
                        && book.getAverageRating() != 0
                        && book.getAuthors() != null
                        && book.getAuthors().contains(authorName)) {
                    bookCounter++;
                    double rating = book.getAverageRating();
                    ratingSum += rating;
                    }

                }
            if (bookCounter > 0) {
                Author author = new Author();
                author.setFullName(authorName);
                author.setAvgRating(ratingSum/bookCounter);
                authorsList.add(author);
            }
        }
    }


    // ============ PARSING TO JSON ===============

    public String authorListToJSON(List<Author> authors) {
        if (authors == null) {
            List<Author> emptyList = new ArrayList<>();
            return gson.toJson(emptyList);
        }
        return gson.toJson(authors);

    }



    // ============ SETTERS AND GETTER ===============


    public List<Author> getAuthorsList() {
        initiateAuthorList();
        return authorsList.stream()
                .sorted((author1, author2) -> author1.getAvgRating()> author2.getAvgRating()? -1:1)
                .collect(Collectors.toList());
    }

    public void setAuthorsList(List<Author> authorsList) {
        this.authorsList = authorsList;
    }
}
