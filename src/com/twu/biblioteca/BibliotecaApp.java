package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        Library library = new Library();
        bibliotecaLaunch(library);


    }

    private static void mainMenu(Library library){
        Scanner scan = new Scanner(System.in);
        boolean bool = true;
        System.out.println("Select an option");
        System.out.println(
                "1. Browse Library"
        );
        int num = scan.nextInt();
        scan.nextLine();
        while(bool) {
            switch (num) {
                case 1:
                    libraryList(library);
                    bool = false;
                    break;
                default:
                    System.out.println("You didn't enter a valid option");
                    num = scan.nextInt();
                    scan.nextLine();

            }

        }
    }
    private static void helloMessage(){
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
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
