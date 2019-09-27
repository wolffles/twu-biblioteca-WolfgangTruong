/* class Operation
  @description: This is a methods class for general app functionality such as: checking or comparing common user inputs.
*/

package com.twu.biblioteca;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class AppFunctions {

//  Common function to collect user Int input
    public static int numberSelect(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            return -1;
        }
    }

//  Common function to collect user String input.
    public static String enterString(String message){
        Scanner scan = new Scanner(System.in);
        System.out.println(message);
        String words = scan.nextLine();
//        System.out.println(words);
        return words;
    }

//  Used to check if a title exists in an ArrayList<Book>
    public static boolean arrayContainsTitle(ArrayList<Book> array, String title){
        boolean exist = false;
        for(int i = 0; i < array.size(); i++){
            if(array.get(i).getTitle().toLowerCase().contentEquals(title.toLowerCase())){
                exist = true;
            }
        }
        return exist;
    }
    public static boolean arrayContainsName(ArrayList<Movie> array, String title){
        boolean exist = false;
        for(int i = 0; i < array.size(); i++){
            if(array.get(i).getName().toLowerCase().contentEquals(title.toLowerCase())){
                exist = true;
            }
        }
        return exist;
    }

    public static boolean arrayContainsId(ArrayList<Book> array, int id){
        boolean exist = false;
        for(int i = 0; i < array.size(); i++){
            if(array.get(i).getId() == id){
                exist = true;
            }
        }
        return exist;
    }


//  helps mark end of a user interaction. one has message before the end, other is generic end.
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
