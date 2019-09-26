package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> bookList;
    private ArrayList<Book> checkedOutList;

    public Library() {
        bookList = new ArrayList<>();
        checkedOutList = new ArrayList<>();
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
        checkedOutList.add(new Book("Nicole's Naughty Nights", 14, "Nick NewComer", 2019));
    }

    public ArrayList<Book> getBookList() {
        return this.bookList;
    }

    public ArrayList<Book> getCheckedOutList(){
        return this.checkedOutList;
    }

    public void checkoutBook(String attr){
        boolean bool = true;
        switch(attr.toLowerCase()){
            case "id":
                while(bool) {
                    int id = AppFunctions.numberSelect("enter ID number, or 0 to exit");
                    if (id == 0){
                        bool = false;
                    }else if(AppFunctions.arrayContainsId(getBookList(), id)){
                        bool = false;
                        for(int i = 0; i < this.getBookList().size(); i++){
                                Book item = this.bookList.get(i);
                            if(item.getId() == id){
                                checkedOutList.add(item);
                                bookList.remove(item);
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
                }
                break;
            case "title":
                while(bool) {
                    String title = AppFunctions.enterString("enter title number, or 0 to exit");
                    if (title.contentEquals("0")){
                        bool = false;
                    }else if (AppFunctions.arrayContainsTitle(this.bookList, title.trim())){
                        bool = false;
                        for(int i = 0; i < this.getBookList().size(); i++){
                            Book item = this.bookList.get(i);
                            if(item.getTitle().toLowerCase().contentEquals(title.toLowerCase())){
                                checkedOutList.add(item);
                                bookList.remove(item);
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
                }
                break;
            default: {
                AppFunctions.lineBreak("you didn't enter the correct attribute");
            }
        }

    }
}
