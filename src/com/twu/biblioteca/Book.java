package com.twu.biblioteca;

public class Book {
    private String title;
    private int id;
    private String author;
    private int year;

    public Book(String title, int id, String author, int year) {
        this.title = title;
        this.id = id;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear(){
        return year;
    }
}
