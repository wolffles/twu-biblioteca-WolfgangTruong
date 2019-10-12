package com.twu.biblioteca;

import java.util.ArrayList;

public class Auth {
    private boolean isActive;
    private String accountType;
    private User accRef;

    public Auth() {
        this.isActive = false;
        this.accountType = "guest";
        this.accRef = null;
    }

    public boolean isActive() {
        return isActive;
    }

    public String getAccountType() {
        return accountType;
    }

    public User getAccRef() {
        return accRef;
    }

    public void toggleActive() {
        isActive = !isActive;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void setAccRef(ArrayList<User> accounts, String libraryNumber) {
        this.accRef = getUserFromCollections(accounts, libraryNumber);
    }

    public User getUserFromCollections(ArrayList<User> accounts, String libraryNumber){
        User user = null;
        for(int i = 0; i < accounts.size(); i ++){
            if(accounts.get(i).getLibraryNumber().contentEquals(libraryNumber)){
                user = accounts.get(i);
            }
        }
        return user;
    }

    private void authChange(ArrayList<User> accounts, String accType, String libraryNumber){
        toggleActive();
        setAccountType(accType);
        setAccRef(accounts, libraryNumber);

    }

    public void login(Library library, String libraryNumber, String password){
        ArrayList<User> accounts = library.getUserAccounts();
        User user = null;
        for(int i = 0; i < accounts.size(); i ++){
            if(accounts.get(i).getLibraryNumber().contentEquals(libraryNumber)){
                user = accounts.get(i);
            }
        }
        // check to see if account exist
        if(user == null){
            AppFunctions.lineBreak("Invalid library number and/or password");
        }else if(user != null && user.getPassword().contentEquals(password)){
            authChange(accounts,"member", libraryNumber);
            library.setCurrentUser(user);
        }else{
            AppFunctions.lineBreak("Invalid inputs");
        }
    }


//    would create a profile class to handle the profile but im burnt out
//    public void usersItemsOut(User user){
//        System.out.format( "%10s%40s%n" , "TYPE" , "NAME");
//        ArrayList<Object> items = user.getItemsOut();
//        for(int i = 0; i < items.size(); i++ ){
//            if(items.get(i) instanceof Book ) {
//                System.out.format("%10s%40s%n", "BOOK", ((Book) items.get(i)).getTitle());
//            }else{
//                System.out.format("%10s%40s%n", "MOVIE", ((Movie) items.get(i)).getName());
//            }
//        }
//        AppFunctions.lineBreak();
//    }

}
