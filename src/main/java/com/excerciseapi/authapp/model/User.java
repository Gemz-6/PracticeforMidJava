package com.excerciseapi.authapp.model;

public class User {
    private final String userId;
    private String password;
    private String email;

    public User(String userId, String email, String password) {
        this.userId = userId;
        this.email = email;
        this.password = password;
    }

 
    public String getUserId(){
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
    return password;
    }
     public void setPassword(String password) {
        this.password = password;
    }
   

    public void setEmail(String email) {
        this.email = email;
    }
}
