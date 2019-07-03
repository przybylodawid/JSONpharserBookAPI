package com.przybylo.BookApp.Service;

import com.przybylo.BookApp.service.BookService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class BookServiceTest {

    BookService bs = new BookService();

    @Test
    public void shouldReturnNullWhenISBNIsNotInList(){

        assertNull(bs.findBookByISBN("asd"));
    }

    @Test
    public void shouldReturn404MessageIfBookIsNull(){
      assertEquals(bs.bookToJSON(bs.findBookByISBN("asd")), "404 ELEMENT NOT FOUND");
    }
}
