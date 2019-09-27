package com.twu.biblioteca;

import java.util.ArrayList;

public class User {
    private String libraryNumber;
    private String password;
    private ArrayList<Object> itemsOut;

    public User(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.itemsOut = new ArrayList<>();
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Object> getItemsOut() {
        return itemsOut;
    }

    public void addToItemsOut(Object object){
        itemsOut.add(object);
    }
}
