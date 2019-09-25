package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        AppFunctions.printMessage(getHelloMessage());
    }

    public static String getHelloMessage(){
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    };
}
