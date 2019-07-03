package com.przybylo.BookApp.service;

import com.przybylo.BookApp.model.Book;
import com.przybylo.BookApp.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RatingService {
    private List<Author> authorsList;

    @Autowired
    private BookService bs;

    public void test() {
        authorsList = new ArrayList<>();

        // getting set of Authors first
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

    // ============ Constructor ===============

    public RatingService() {
    }


    // ============ SETTERS AND GETTER ===============


    public List<Author> getAuthorsList() {
        return authorsList;
    }

    public void setAuthorsList(List<Author> authorsList) {
        this.authorsList = authorsList;
    }
}
