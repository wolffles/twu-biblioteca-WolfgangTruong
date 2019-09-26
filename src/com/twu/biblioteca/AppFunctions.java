package com.twu.biblioteca;


import java.util.InputMismatchException;
import java.util.Scanner;

// This is a methods class for general app functionality such as: print messages, and checkout.
public class AppFunctions {



    public static int numberSelect(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            return -1;
        }
    }

    public static void lineBreak(String message){
        Scanner scan = new Scanner(System.in);
        System.out.println(message);
        System.out.println("-> Enter <-");
        scan.nextLine();
    }

    public static void lineBreak(){
        Scanner scan = new Scanner(System.in);
        System.out.println("-> Enter <-");
        scan.nextLine();
    }

}
