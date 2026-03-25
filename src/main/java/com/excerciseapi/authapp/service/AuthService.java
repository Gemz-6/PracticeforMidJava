package com.excerciseapi.authapp.service;

import java.util.HashMap;

import com.excerciseapi.authapp.model.User;

public class AuthService {
    private HashMap<String, User> users;
    
    AuthService(HashMap<String, User> users){
        this.users = users;
    }

    public User login(String userId, String password){
       User user=users.get(userId);
      
       if(user !=null && user.getPassword().equals(password)){
        return user;
       }else{
        return null;
       }
    }
}
