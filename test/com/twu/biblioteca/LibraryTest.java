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
    Library lib;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        lib = new Library();
    }


    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void shouldGenerateBookList() {
//        Library lib = new Library();
        ArrayList<Book> x = lib.getBookList();
        assertThat( x.isEmpty(), is(not(true)));
    }

    @Test
    public void shouldCheckoutBook(){

        String attr = "title";
        ByteArrayInputStream userInput = new ByteArrayInputStream("0\n 0\n 0\n".getBytes());
        System.setIn(userInput);
        lib.checkoutBook(attr);
        assertThat( outContent.toString(),is("arbitrary"));
        System.setIn(System.in);
    }
}