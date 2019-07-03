package com.przybylo.BookApp.model;


import com.przybylo.BookApp.model.JsonPharser.BookJSON;
import com.przybylo.BookApp.model.JsonPharser.IndustryIdentifier;
import com.przybylo.BookApp.tools.DataConverter;

import java.util.List;

public class Book {

    //if the ISBN_13 value is not present use ID
    private String isbn;
    private String title;
    private String subtitle;
    private String publisher;

    // should be UNIX TIMESTAMP
    private long publishedDate;
    private String description;
    private int pageCount;
    private String thumbnailUrl;
    private String language;
    private String previewLink;
    private double averageRating;

    // i put Lists instead of Arrays to have access to collection methods
    private List<String> authors;
    private List<String> categories;

    public void mapFromJson(BookJSON bookjson){
        this.setIsbn(this.getProperId(bookjson));
        this.setTitle(bookjson.getVolumeInfo().getTitle());
        this.setSubtitle(bookjson.getVolumeInfo().getSubtitle());
        this.setPublisher(bookjson.getVolumeInfo().getPublisher());
        DataConverter dataConverter = new DataConverter();
        this.setPublishedDate(dataConverter.convert(bookjson.getVolumeInfo().getPublishedDate()));
        this.setDescription(bookjson.getVolumeInfo().getDescription());
        this.setPageCount(bookjson.getVolumeInfo().getPageCount());
        this.setThumbnailUrl(bookjson.getVolumeInfo().getImageLinks().getThumbnail());
        this.setLanguage(bookjson.getVolumeInfo().getLanguage());
        this.setPreviewLink(bookjson.getVolumeInfo().getPreviewLink());
        this.setAverageRating(bookjson.getVolumeInfo().getAverageRating());
        this.setAuthors(bookjson.getVolumeInfo().getAuthors());
        this.setCategories(bookjson.getVolumeInfo().getCategories());
    }
    // checking if ISBN 13 is present
    // if ISBN_13 is present is not null ---- > RETURN value of ISBN_13
    // if ISBN_13 is missing return ID
    public String getProperId(BookJSON bookjson){
        List<IndustryIdentifier> IIList = bookjson.getVolumeInfo().getIndustryIdentifiers();
        if (IIList == null){
            return bookjson.getId();
        }
        for (IndustryIdentifier industryIdentifier:IIList){
            if (industryIdentifier.getType().equals("ISBN_13") && industryIdentifier.getIdentifier() != null){
                return industryIdentifier.getIdentifier();
            }
        }
        return bookjson.getId();
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public long getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(long publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPreviewLink() {
        return previewLink;
    }

    public void setPreviewLink(String previewLink) {
        this.previewLink = previewLink;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }
}
