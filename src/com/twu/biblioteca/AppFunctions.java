package com.twu.biblioteca;


// This is a methods class for general app functionality such as: print messages, and checkout.
public class AppFunctions {
    public static final String formatString = "%5d%50s%30s%n";

    public static void printMessage(String message){
        System.out.println(message);
    }

    public static void printListOfBooks(Book book){
        System.out.format( formatString, book.getId(), book.getTitle(), book.getAuthor());
    }
}
