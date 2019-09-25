package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> bookList;

    public Library() {
        bookList = new ArrayList<>();
        bookList.add(new Book("All About Apples", 1, "johnny appleseed"));
        bookList.add(new Book("Be Brave Bruh", 2, "Brospeh bruhmun"));
        bookList.add(new Book("Click Clack Catastrophe ", 3, "Cats Coolio"));
        bookList.add(new Book("Daylight DemonSlayer Defeats Doomsayer", 4, "Doug Doogle"));
        bookList.add(new Book("Evenings End En Ecstasy", 5, "Edwardo El Elephant"));
        bookList.add(new Book("Ferocious Feminine Facade", 6, "Fanny Faquxfar"));
        bookList.add(new Book("Great Gatsby", 7, "G Gottz Getz'Harlod"));
        bookList.add(new Book("Haunted Hill's History", 8, "Helen Hair-raiser"));
        bookList.add(new Book("Introverts Imitate Innovative Individuals", 9, "Ike Isore"));
        bookList.add(new Book("John Jakob Jangleheimer", 10, "John Jakob"));
        bookList.add(new Book("Karma's Kaleidoscope", 11, "Ken Karry Kuns"));
        bookList.add(new Book("Lads Little Leg", 12, "Less Lemmar"));
        bookList.add(new Book("Muse Music's Masterpieces", 13, "Manny Makovich"));
    }

    public ArrayList<Book> getBookList() {
        return this.bookList;
    }
}
