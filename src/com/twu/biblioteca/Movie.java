package com.twu.biblioteca;

public class Movie extends LibObj {
    private int id;
    private String name;
    private String year;
    private String director;
    private String rating;
    private String renter;

    public Movie(int id, String name, String year, String director, String rating) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
        this.renter = "";
    }
    public Movie(int id, String name, String year, String director, String rating, String renter) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
        this.renter = renter;
    }

    public int getId() {
        return id;
    }
    @Override
    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public String getRating() {
        return rating;
    }
}
