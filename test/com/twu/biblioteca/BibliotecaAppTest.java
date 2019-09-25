package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
public class BibliotecaAppTest{


    @Test // Checks to make sure the message is correct.
    public void getHelloMesssage() {
        assertThat( BibliotecaApp.getHelloMessage(), is(equalTo("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!")));
    }

}