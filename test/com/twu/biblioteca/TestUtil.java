package com.twu.biblioteca;

import org.junit.After;

import java.io.ByteArrayInputStream;

public class TestUtil {
    static void setInput(String string){
        System.setIn(new ByteArrayInputStream(string.getBytes()));
    }


}
