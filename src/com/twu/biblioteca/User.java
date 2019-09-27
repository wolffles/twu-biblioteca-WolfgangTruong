package com.twu.biblioteca;

import java.util.ArrayList;

public class User {
    private String libraryNumber;
    private String password;
    private ArrayList<Object> itemsOut;
    private String name;
    private String email;
    private String phone;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
