package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;


public class AppFunctionsTest {
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
    public void printMessage(){
        AppFunctions.printMessage( "hello" );
        assertThat( outContent.toString().trim(),is(equalTo(("hello"))));
    }

    @Test
    public void printListOfBooks(){
        Book x = new Book("one two", 13, "aaa bbb");
        AppFunctions.printListOfBooks(x);
        assertThat( outContent.toString(), is("   13                                                     one two             aaa bbb\n"));
    }
}