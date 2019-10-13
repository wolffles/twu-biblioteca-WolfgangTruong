package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

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

    public void setAccRef(Map<String, User> accounts, String libraryNumber) {
        this.accRef = getUserFromCollections(accounts, libraryNumber);
    }

    public User getUserFromCollections(Map<String, User> accounts, String libraryNumber){
        User user = accounts.get(libraryNumber);;
        return user;
    }

    private void authChange(Map<String,User> accounts, String accType, String libraryNumber){
        toggleActive();
        setAccountType(accType);
        setAccRef(accounts, libraryNumber);

    }

    public void login(Library library, String libraryNumber, String password){
        User user = library.getUserAccounts().get(libraryNumber);
        if(user == null){
            AppFunctions.lineBreak("Invalid library number and/or password");
        }else if(user != null && user.getPassword().contentEquals(password)){
            authChange(library.getUserAccounts(),"member", libraryNumber);
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
