package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class LibraryTest {
    private Library lib = new Library();
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void shouldGenerateBookList() {
//        Library lib = new Library();
        ArrayList<Book> x = lib.getBookList();
        assertThat( x.isEmpty() , is(not(true)));

    }

//    @Test
//    public void checkoutBookShouldBeDifferentAfterSuccess() {
//        Library constant = new Library();
//        ByteArrayInputStream m2 = new ByteArrayInputStream(" 0 \n 0\n 0\n 0\n".getBytes());
//        System.setIn(m2);
//        lib.checkoutBook("title");
//        assertEquals(lib.getBookList().size(), constant.getBookList().size());
//        System.setIn(System.in);
//    }
}