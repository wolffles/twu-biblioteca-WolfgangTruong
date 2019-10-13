package com.twu.biblioteca;

import org.junit.After;

import java.io.ByteArrayInputStream;


/*
I started to make a utils app but I got tired.
*/
public class TestUtil {
    static void setInput(String string){
        System.setIn(new ByteArrayInputStream(string.getBytes()));
    }


}
