package com.twu.biblioteca;

public class Book extends LibObj{
    private String title;
    private int id;
    private String author;
    private int year;
    private String renter;

    public Book(String title, int id, String author, int year) {
        this.title = title;
        this.id = id;
        this.author = author;
        this.year = year;
        this.renter = "";
    }
    public Book(String title, int id, String author, int year, String renter) {
        this.title = title;
        this.id = id;
        this.author = author;
        this.year = year;
        this.renter = renter;
    }
    @Override
    public String getName() {
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

    public String getRenter() {
        return renter;
    }

    public void setRenter(String renter) {
        this.renter = renter;
    }
}
