package com.przybylo.BookApp.tools;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DataConverterTest {

    //TODO: Experiment with REGEXes and Try to mock localtime to check if Date is Correct
    @Test
    public void FullDateShouldReturnProperDataFormat(){
        String Date = "2000-12-01";
        DataConverter dataConverter = new DataConverter();
        int convertedDateLength = dataConverter.convert(Date).toString().length();
        int properDataFormatExampleLength = 9;
        assertEquals(convertedDateLength, properDataFormatExampleLength);
    }

    @Test
    public void YearMonthDateShouldReturnProperDataFormat(){
        String Date = "2000-12";
        DataConverter dataConverter = new DataConverter();
        int convertedDateLength = dataConverter.convert(Date).toString().length();
        int properDataFormatExampleLength = 9;
        assertEquals(convertedDateLength, properDataFormatExampleLength);
    }

    @Test
    public void YearDateShouldReturnProperDataFormat(){
        String Date = "2000";
        DataConverter dataConverter = new DataConverter();
        int convertedDateLength = dataConverter.convert(Date).toString().length();
        int properDataFormatExampleLength = 9;
        assertEquals(convertedDateLength, properDataFormatExampleLength);
    }
}
