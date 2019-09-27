package com.twu.biblioteca;

public class Movie {
    private String name;
    private String year;
    private String director;
    private String rating;
    private String renter;

    public Movie(String name, String year, String director, String rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
        this.renter = "";
    }
    public Movie(String name, String year, String director, String rating, String renter) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
        this.renter = renter;
    }

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
