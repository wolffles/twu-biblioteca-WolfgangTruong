package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
public class BibliotecaAppTest{
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    BibliotecaApp app = new BibliotecaApp();
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void main() {
//    creating sample input values, possible refactor
        AppFunctions app = new AppFunctions();
        ByteArrayInputStream m1 = new ByteArrayInputStream("My string".getBytes());
        ByteArrayInputStream m2 = new ByteArrayInputStream("16\n 4\n 9\n".getBytes());
        ByteArrayInputStream m3 = new ByteArrayInputStream("4".getBytes());
        System.setIn(m2);
//   do your thing
        assertThat(app.numberSelect("something"),is(16));
//   optionally, reset System.in to its original
        System.setIn(System.in);
//       assertEquals(2, 0);
    }


//    Generally dont test private tests.
//    @Test
//    public void helloMessageTest(){
//        app.helloMessage();
//        assertThat(outContent.toString(), is(equalTo("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!")) )
//    }

}