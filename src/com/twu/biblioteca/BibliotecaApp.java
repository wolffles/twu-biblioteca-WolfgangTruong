package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Library library = new Library();
        bibliotecaLaunch();
        AppFunctions.printMessage("press 'Enter'");
        scan.nextLine();
        libraryList(library);
    }

    private static void helloMessage(){
         AppFunctions.printMessage("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }
    private static void libraryList(Library library){
        System.out.format( "%5s%50s%30s%5s%n" , "ID" , "TITLE", "AUTHOR", "YEAR");
        library.getBookList().forEach(ele ->
                AppFunctions.printListOfBooks(ele)
        );
    }

    private static void bibliotecaLaunch(){
        helloMessage();
    }
}
