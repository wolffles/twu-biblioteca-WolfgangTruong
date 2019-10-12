package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class LibraryTest {
    Library lib;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalInput = System.in;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        lib = new Library();
    }


    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalInput);
    }

    @Test
    public void shouldGenerateBookList() {
//        Library lib = new Library();
        ArrayList<LibObj> x = lib.getBookList();
        assertThat( x.isEmpty(), is(not(true)));
    }

    @Test
    public void checkoutBookShouldExitTitle() {
        String attr = "title";
        ByteArrayInputStream userInput = new ByteArrayInputStream("0\n \n".getBytes());
        System.setIn(userInput);
        lib.checkoutBook(attr);
        assertThat(outContent.toString(), is(containsString("enter title number, or 0 to exit\nBack to main menu\n-> Enter <-\n")));

    }

//    @Test
//    public void checkoutBookShouldExitId() {
//        String attr = "id";
//        ByteArrayInputStream userInput = new ByteArrayInputStream("0\n \n".getBytes());
//        System.setIn(userInput);
//        lib.checkoutBook(attr);
//        assertThat(outContent.toString(), is(containsString("enter ID number, or 0 to exit\nBack to main menu\n-> Enter <-\n")));
//        System.setIn(System.in);
//    }

    @Test
    public void checkoutBookTitleSuccess(){
        String attr = "title";
        ByteArrayInputStream userInput = new ByteArrayInputStream("Lads Little Leg\n".getBytes());
        assertThat( outContent.toString(), is(containsString("enter title number, or 0 to exit\nBack to main menu\n-> Enter <-\n")));
        System.setIn(userInput);
        lib.checkoutBook(attr);
        System.setIn(System.in);
    }
    @Test
    public void checkoutBookIDSuccess(){
        String attr = "id";
        ByteArrayInputStream userInput = new ByteArrayInputStream("\n13\n\n 0\n".getBytes());
        assertThat( outContent.toString(), is(containsString("enter title number, or 0 to exit\nBack to main menu\n-> Enter <-\n")));
        System.setIn(userInput);
        lib.checkoutBook(attr);
        System.setIn(System.in);
    }
    @Test
    public void checkoutBookIDFail(){
        String attr = "id";
        ByteArrayInputStream userInput = new ByteArrayInputStream("0\n".getBytes());
        assertThat( outContent.toString(), is(containsString("arbitrary")));
        System.setIn(userInput);
        lib.checkoutBook(attr);
        System.setIn(System.in);
    }
}