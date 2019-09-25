package com.twu.biblioteca;

public class Book {
    private String title;
    private int id;
    private String author;

    public Book(String title, int id, String author) {
        this.title = title;
        this.id = id;
        this.author = author;
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
}
