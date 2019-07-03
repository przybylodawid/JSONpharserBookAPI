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

    // ============ Constructor ===============

    public RatingService(){
//        authorsList = new ArrayList<>();
//
//        // getting set of Authors first
//        Set<String> authorNames = new HashSet<>();
//        List<Book> books = bs.getBookList();
//
//        for (Book book:books){
//            if (book.getAuthors() != null){
//                authorNames.addAll(book.getAuthors());
//             }
//        }
//        // Checking for author's books ratings
//        for (String authorName: authorNames){
//        int bookCounter = 0;
//        double ratingSum = 0;
//            for (Book book:books){
//                if (book.getAuthors().contains(authorName)
//                        && book.getAverageRating() != null
//                        && book.getAuthors()!= null){
//                    bookCounter++;
//                    ratingSum += book.getAverageRating();
//                    }
//                if (bookCounter >0){
//                    Author author = new Author();
//                    author.setFullName(authorName);
//                    author.setAvgRating(ratingSum/bookCounter);
//                    authorsList.add(author);
//                }
//            }
//        }
//
//
    }




    // ============ SETTERS AND GETTER ===============


    public List<Author> getAuthorsList() {
        return authorsList;
    }

    public void setAuthorsList(List<Author> authorsList) {
        this.authorsList = authorsList;
    }
}
