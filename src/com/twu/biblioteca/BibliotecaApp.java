package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {
    private static String memberMenu = "MEMBER MAIN MENU\n" +
            "1. Browse Library\n" +
            "2. Browse Movies\n" +
            "3. Checkout Book\n" +
            "4. Return Book\n" +
            "5. Rent Movie\n" +
            "6. Return Movie\n" +
            "7. Check Held Items\n" +
            "8. Account Information\n" +
            "0. Exit App";

    private static String guestMenu = "GUEST MAIN MENU\n" +
            "1. Browse Library\n" +
            "2. Browse Movies\n" +
            "3. Login\n" +
            "0. Exit App";


    public static void main(String[] args) {
        Auth auth = new Auth();
        Library library = new Library();
        bibliotecaLaunch(library, auth);


    }
    private static void menu(Library library, Auth auth){
        boolean bool = true;
        while(bool) {
            if(auth.isActive()){
                System.out.println(memberMenu);
                int num = AppFunctions.numberSelect("Please select an option");
                switch (num) {
                    case 1:
                        libraryList(library);
                        AppFunctions.lineBreak();
                        break;
                    case 2:
                        moviesCollection(library);
                        AppFunctions.lineBreak();
                        break;
                    case 3:
                        library.checkoutBook(AppFunctions.enterString("would you like to checkout by 'Id' or 'Title'"));
                        break;
                    case 4:
                        library.returnBook(AppFunctions.enterString("would you like to checkout by 'Id' or 'Title'"));
                        break;
                    case 5:
                        library.checkoutMovie();
                        break;
                    case 6:
                        break;
                    case 7:
                        usersItemsOut(auth.getAccRef());
                        break;
                    case 8:
                        userInfomation(auth.getAccRef());
                        break;
                    case 0:
                        bool = false;
                        AppFunctions.lineBreak("GoodBye User");
                        break;
                    default:
                        AppFunctions.lineBreak("You didn't enter a valid option");
                }
            }else if(!auth.isActive()) {
                System.out.println(guestMenu);
                int num = AppFunctions.numberSelect("Please select an option");
                switch (num) {
                    case 1:
                        libraryList(library);
                        AppFunctions.lineBreak();
                        break;
                    case 2:
                        moviesCollection(library);
                        AppFunctions.lineBreak();
                        break;
                    case 3:
                        System.out.println("library number is 'lib-1234' and password is 'password' ");
                        String libraryNumber = AppFunctions.enterString("enter your library number").trim();
                        String password = AppFunctions.enterString("enter your password").trim();
                        auth.login(library, libraryNumber, password);
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
    private static void moviesCollection(Library collection){
        System.out.format( "%40s%10s%40s%5s%n" , "NAME" , "YEAR", "DIRECTOR", "RAITING");
        collection.getMovieList().forEach(ele ->
                System.out.format( "%40s%10s%40s%5s%n", ele.getName(), ele.getYear(), ele.getDirector(), ele.getRating())
        );
    }

    private static void usersItemsOut(User user){
        System.out.format( "%10s%40s%n" , "TYPE" , "NAME");
        ArrayList<Object> items = user.getItemsOut();
        for(int i = 0; i < items.size(); i++ ){
            if(items.get(i) instanceof Book ) {
                System.out.format("%10s%40s%n", "BOOK", ((Book) items.get(i)).getTitle());
            }else{
                System.out.format("%10s%40s%n", "MOVIE", ((Movie) items.get(i)).getName());
            }
        }
        AppFunctions.lineBreak();
    }

    private static void userInfomation(User user){
        if(user.getName() == null || user.getEmail() == null || user.getPhone() == null ){
            if(AppFunctions.enterString("Your Profile is incomplete would you like to update it 'y/n'?").trim().contentEquals("y")){
                user.setName(AppFunctions.enterString("Full name?"));
                user.setEmail(AppFunctions.enterString("Email address?"));
                user.setPhone(AppFunctions.enterString("Phone number?"));
            }
        }
        System.out.println("USER INFORMATION");
        System.out.println("Library Number: "+ user.getLibraryNumber()+"\n" +
                "Name: " +  user.getName() +"\n" +
                "Email: " + user.getEmail() +"\n" +
                "Phone: " + user.getPhone()
        );
        AppFunctions.lineBreak();
    }
    private static void bibliotecaLaunch(Library library, Auth auth){
        helloMessage();
        menu(library, auth);
    }
}
