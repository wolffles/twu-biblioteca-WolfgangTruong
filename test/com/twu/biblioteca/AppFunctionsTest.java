package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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
    public void testnumberSelect() {
//   creating sample input values, possible refactor
        AppFunctions app = new AppFunctions();
        ByteArrayInputStream m1 = new ByteArrayInputStream("My string".getBytes());
        ByteArrayInputStream m2 = new ByteArrayInputStream("16\n4".getBytes());
        ByteArrayInputStream m3 = new ByteArrayInputStream("4".getBytes());
        System.setIn(m2);
//   do your thing
        assertThat(app.numberSelect("something"),is(16));
//   optionally, reset System.in to its original
        System.setIn(System.in);

    }

    @Test
    public void enterString() {
        AppFunctions app = new AppFunctions();
        ByteArrayInputStream m1 = new ByteArrayInputStream("My string\n".getBytes());
        ByteArrayInputStream m2 = new ByteArrayInputStream("16\n4\n".getBytes());
        ByteArrayInputStream m3 = new ByteArrayInputStream("4\n".getBytes());
        System.setIn(m1);

        assertThat(app.enterString("something"),is("My string"));
        System.setIn(System.in);
    }

    @Test
    public void arrayContainsTitle() {
        AppFunctions app = new AppFunctions();
        Library lib = new Library();

//       @WRONG INPUT: title mispelLed or doesn't exist returns false
        assertThat(app.arrayContainsTitle(lib.getBookList(), "Ladss little leg"),is( false));
//       @CORRECT INPUT: is case insensitive and returns true if matches
        assertThat(app.arrayContainsTitle(lib.getBookList(), "LADS LITTLE LEG"),is( true));
    }

    @Test
    public void testlineBreak() {
        AppFunctions app = new AppFunctions();
        ByteArrayInputStream m2 = new ByteArrayInputStream("\n".getBytes());
        System.setIn(m2);
        app.lineBreak("hello");
        assertThat(outContent.toString(), is(equalTo("hello\n-> Enter <-\n")));
    }
}