package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Library {
    private ArrayList<LibObj> bookList;
    private ArrayList<LibObj> checkedOutList;
    private ArrayList<LibObj> movieList;
    private ArrayList<LibObj> rentedMovies;
    private Map<String, User> userAccounts;
    private User currentUser;

    public Library() {
        bookList = new ArrayList<>();
        checkedOutList = new ArrayList<>();
        movieList = new ArrayList<>();
        rentedMovies = new ArrayList<>();
        userAccounts = new HashMap<>();
        User user = new User("lib-1234", "password");
        bookList.add(new Book("All About Apples", 1, "johnny appleseed", 1793));
        bookList.add(new Book("Be Brave Bruh", 2, "Brospeh bruhmun", 2012));
        bookList.add(new Book("Click Clack Catastrophe ", 3, "Cats Coolio", 1850));
        bookList.add(new Book("Daylight DemonSlayer Defeats Doomsayer", 4, "Doug Doogle", 1666));
        bookList.add(new Book("Evenings End En Ecstasy", 5, "Edwardo El Elephant", 1999));
        bookList.add(new Book("Ferocious Feminine Facade", 6, "Fanny Faquxfar", 1976));
        bookList.add(new Book("Great Gatsby", 7, "G Gottz Getz'Harlod", 1956));
        bookList.add(new Book("Haunted Hill's History", 8, "Helen Hair-raiser", 1990));
        bookList.add(new Book("Introverts Imitate Innovative Individuals", 9, "Ike Isore", 1890));
        bookList.add(new Book("John Jakob Jangleheimer", 10, "John Jakob", 1968));
        bookList.add(new Book("Karma's Kaleidoscope", 11, "Ken Karry Kuns", 1968));
        bookList.add(new Book("Lads Little Leg", 12, "Less Lemmar", 1968));
        bookList.add(new Book("Muse Music's Masterpieces", 13, "Manny Makovich", 1968));
        Book user1 = new Book("Nicole's Naughty Nights", 14, "Nick NewComer", 2019, "lib-1234");
        checkedOutList.add(user1);
        movieList.add(new Movie(01,"Iron Man", "2008", "Jon Favreau", "10"));
        movieList.add(new Movie(02,"Iron Man2", "2010", "Jon Favreau", "9"));
        movieList.add(new Movie(03,"Iron Man3", "2014", "Jon Favreau", "3"));
        movieList.add(new Movie(04,"Avengers", "2011", " Joss Whedon, Joe Russo, Anthony Russo", "10"));
        movieList.add(new Movie(05,"Thor", "2009", "Kenneth Branagh", "9"));
        movieList.add(new Movie(06,"Captain America", "2012", "Joe Johnston", "6"));
        Movie user2 = new Movie(07,"Spider Man: Home Coming","2016","I don't know","10", "lib-1234");
        rentedMovies.add(user2);
        userAccounts.put("lib-1234", user);
        user.addToItemsOut(user1);
        user.addToItemsOut(user2);
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public ArrayList<LibObj> getBookList() {
        return this.bookList;
    }

    public ArrayList<LibObj> getMovieList() {
        return movieList;
    }

    public ArrayList<LibObj> getRentedMovies() {
        return rentedMovies;
    }

    public Map<String, User> getUserAccounts() {
        return this.userAccounts;
    }

    public ArrayList<LibObj> getCheckedOutList(){
        return this.checkedOutList;
    }

    public void checkoutBook(String attr){
        boolean bool = true;
        while (bool){
            switch(attr.toLowerCase()){
                case "id":
                    int id = AppFunctions.numberSelect("enter ID number, or 0 to exit");
                    if (id == 0){
                        bool = false;
                        AppFunctions.lineBreak("Back to main menu");
                    }else if(AppFunctions.arrayContainsId(getBookList(), id)){
                        bool = false;
                        for(int i = 0; i < this.getBookList().size(); i++){
                            LibObj item = this.bookList.get(i);
                            if(item.getId() == id){
                                takeFromLibrary(item);
                            }
                        }
                        AppFunctions.lineBreak("Thank you! Enjoy the Book");
                    }else {
                        if( AppFunctions.arrayContainsId(getCheckedOutList(), id)){
                            AppFunctions.lineBreak("Book is checked out");
                        }else{
                            AppFunctions.lineBreak("ID doesn't exist, try another");
                        }
                    }
                    break;
                case "title":
                    String title = AppFunctions.enterString("enter title number, or 0 to exit");
                    if (title.contentEquals("0")){
                        bool = false;
                        AppFunctions.lineBreak("Back to main menu");
                    }else if (AppFunctions.arrayContainsTitle(getBookList(), title.trim())){
                        bool = false;
                        for(int i = 0; i < this.getBookList().size(); i++){
                            LibObj item = this.bookList.get(i);
                            if(item.getName().toLowerCase().contentEquals(title.toLowerCase())){
                                takeFromLibrary(item);
                            }
                        }
                        AppFunctions.lineBreak("Thank you! Enjoy the Book");
                    }else{
                        if (AppFunctions.arrayContainsTitle(getCheckedOutList(), title.trim())) {
                            AppFunctions.lineBreak("Sorry, that book is not available, try again later");
                        }else {
                            AppFunctions.lineBreak("Couldn't find the title you were looking for. Please check your spelling.");
                        }
                    }
                    break;
                default: {
                    AppFunctions.lineBreak("you didn't enter the correct attribute");
                    bool = false;
                }
            }
        }
    }


    public void returnBook(String attr){
        boolean bool = true;
        switch(attr.toLowerCase()){
            case "id":
                while(bool) {
                    int id = AppFunctions.numberSelect("enter ID number, or 0 to exit");
                    if (id == 0){
                        bool = false;
                    }else if(AppFunctions.arrayContainsId(getCheckedOutList(), id)){
                        bool = false;
                        for(int i = 0; i < getCheckedOutList().size(); i++){
                            LibObj item = this.checkedOutList.get(i);
                            if(item.getId() == id){
                                giveToLibrary(item);
                            }
                        }
                        AppFunctions.lineBreak("Thank you for returning the book");
                    }else {
                        AppFunctions.lineBreak("That is not a valid return, check Id.");
                    }
                }
                break;
            case "title":
                while(bool) {
                    String title = AppFunctions.enterString("enter title number, or 0 to exit");
                    if (title.contentEquals("0")){
                        bool = false;
                    }else if (AppFunctions.arrayContainsTitle(this.checkedOutList, title.trim())){
                        bool = false;
                        for(int i = 0; i < getCheckedOutList().size(); i++){
                            LibObj item = this.checkedOutList.get(i);
                            if(item.getName().toLowerCase().contentEquals(title.toLowerCase())){
                                giveToLibrary(item);

                            }
                        }
                        AppFunctions.lineBreak("Thank you for returning the book!");
                    }else{
                        AppFunctions.lineBreak("That is not a valid return, check spelling");
                    }
                }
                break;
            default: {
                AppFunctions.lineBreak("you didn't enter the correct attribute");
            }
        }
    }

//    public void checkoutLibObj(ArrayList<LibObj>, String<>) {
//        boolean bool = true;
//        while (bool) {
//            String name = AppFunctions.enterString("Enter name of movie, or 0 to exit");
//            if (name.contentEquals("0")) {
//                bool = false;
//            } else if (AppFunctions.arrayContainsName(this.movieList, name.trim())) {
//                bool = false;
//                for (int i = 0; i < getMovieList().size(); i++) {
//                    LibObj item = getMovieList().get(i);
//                    if (item.getName().toLowerCase().contentEquals(name.toLowerCase())) {
//                        rentedMovies.add(item);
//                        movieList.remove(item);
//
//                    }
//                }
//                AppFunctions.lineBreak("Thank you! Enjoy the Film");
//            } else {
//                if (AppFunctions.arrayContainsName(getRentedMovies(), name.trim())) {
//                    AppFunctions.lineBreak("Sorry, that movie is not available, try again later");
//                } else {
//                    AppFunctions.lineBreak("Couldn't find the name you were looking for. Please check your spelling.");
//                }
//            }
//        }
//    }

    public void returnMovie() {
//        boolean bool = true;
//        switch(attr.toLowerCase()){
//            case "id":
//                while(bool) {
//                    int id = AppFunctions.numberSelect("enter ID number, or 0 to exit");
//                    if (id == 0){
//                        bool = false;
//                    }else if(AppFunctions.arrayContainsId(getCheckedOutList(), id)){
//                        bool = false;
//                        for(int i = 0; i < getCheckedOutList().size(); i++){
//                            LibObj item = this.checkedOutList.get(i);
//                            if(item.getId() == id){
//                                giveToLibrary(item);
//                            }
//                        }
//                        AppFunctions.lineBreak("Thank you for returning the book");
//                    }else {
//                        AppFunctions.lineBreak("That is not a valid return, check Id.");
//                    }
//                }
//                break;
//            case "title":
//                while(bool) {
//                    String title = AppFunctions.enterString("enter title number, or 0 to exit");
//                    if (title.contentEquals("0")){
//                        bool = false;
//                    }else if (AppFunctions.arrayContainsTitle(this.checkedOutList, title.trim())){
//                        bool = false;
//                        for(int i = 0; i < getCheckedOutList().size(); i++){
//                            LibObj item = this.checkedOutList.get(i);
//                            if(item.getName().toLowerCase().contentEquals(title.toLowerCase())){
//                                giveToLibrary(item);
//
//                            }
//                        }
//                        AppFunctions.lineBreak("Thank you for returning the book!");
//                    }else{
//                        AppFunctions.lineBreak("That is not a valid return, check spelling");
//                    }
//                }
//                break;
//            default: {
//                AppFunctions.lineBreak("you didn't enter the correct attribute");
//            }
//        }
    }


/*
   Below are util functions for Library
 */

    private void giveToLibrary(LibObj item){
        this.bookList.add(item);
        this.checkedOutList.remove(item);
        getCurrentUser().getItemsOut().remove(item);
    }

     private void takeFromLibrary(LibObj item){
        this.getCheckedOutList().add(item);
        bookList.remove(item);
        getCurrentUser().addToItemsOut(item);
    }

    private void addToList(){};

}
