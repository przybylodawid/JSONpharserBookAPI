package com.przybylo.BookApp.model;

import com.przybylo.BookApp.model.JsonPharser.BookJSON;
import com.przybylo.BookApp.model.JsonPharser.IndustryIdentifier;
import com.przybylo.BookApp.model.JsonPharser.VolumeInfo;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BookProperIDTest {

    @Test
    public void jsonBookWithoutISBN13ShouldReturnID(){
        BookJSON bookJSON = new BookJSON();
        bookJSON.setId("BOOK ID");
        VolumeInfo volumeInfo = new VolumeInfo();
        IndustryIdentifier industryIdentifier = new IndustryIdentifier();
        industryIdentifier.setType("ISBN_10");
        industryIdentifier.setIdentifier("0000");
        List<IndustryIdentifier> IIList = new ArrayList<>();
        IIList.add(industryIdentifier);
        volumeInfo.setIndustryIdentifiers(IIList);
        bookJSON.setVolumeInfo(volumeInfo);

        Book book = new Book();

        String actual = book.getProperId(bookJSON);
        String expected = "BOOK ID";
        assertEquals(actual,expected);
    }

    @Test
    public void jsonBookWithISBN13ShouldReturnISBN13(){
        BookJSON bookJSON = new BookJSON();
        bookJSON.setId("BOOK ID");
        VolumeInfo volumeInfo = new VolumeInfo();
        IndustryIdentifier industryIdentifier = new IndustryIdentifier();
        industryIdentifier.setType("ISBN_13");
        industryIdentifier.setIdentifier("0000");
        List<IndustryIdentifier> IIList = new ArrayList<IndustryIdentifier>();
        IIList.add(industryIdentifier);
        volumeInfo.setIndustryIdentifiers(IIList);
        bookJSON.setVolumeInfo(volumeInfo);

        Book book = new Book();

        String actual = book.getProperId(bookJSON);
        String expected = "0000";
        assertEquals(actual,expected);
    }
}
