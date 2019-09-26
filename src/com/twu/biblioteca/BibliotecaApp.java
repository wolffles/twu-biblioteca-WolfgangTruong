package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        Library library = new Library();
        bibliotecaLaunch(library);


    }
    private static String menu = "MAIN MENU\n" +
            "1. Browse Library\n" +
            "2. Checkout Book\n" +
            "0. Exit App";

    private static void mainMenu(Library library){
        boolean bool = true;
        while(bool) {
            System.out.println(menu);
            int num = AppFunctions.numberSelect("Please select an option");
            switch (num) {
                case 1:
                    libraryList(library);
                    AppFunctions.lineBreak();
                    break;
                case 2:
                    library.checkoutBook(AppFunctions.enterString("would you like to checkout by 'Id' or 'Title'"));
                    break;
                case 0:
                    bool = false;
                    AppFunctions.lineBreak("GoodBye User");
                    break;
                default:
                   AppFunctions.lineBreak("You didn't enter a valid option");
            }
        }
    }
    private static void helloMessage(){
       AppFunctions.lineBreak("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }
    private static void libraryList(Library library){
        System.out.format( "%5s%50s%30s%5s%n" , "ID" , "TITLE", "AUTHOR", "YEAR");
        library.getBookList().forEach(ele ->
            System.out.format( "%5d%50s%30s%5d%n", ele.getId(), ele.getTitle(), ele.getAuthor(), ele.getYear())
        );
    }

    private static void bibliotecaLaunch(Library library){
        helloMessage();
        mainMenu(library);
    }
}
