package com.excerciseapi.authapp.service;
import java.util.HashMap;
import org.springframework.stereotype.Service;

import com.excerciseapi.authapp.exception.UserAlreadyExistsException;
import com.excerciseapi.authapp.exception.UserInvalidException;
import com.excerciseapi.authapp.model.User;

@Service
public class AuthService {
    //private HashMap<String, User> userById= new HashMap<>();
    private HashMap<String, User> usersByEmail = new HashMap<>();
    

    public User login(String email, String password){
       //User user= userById.get(userId);
       User user = usersByEmail.get(email);
      
       if(user !=null && user.getPassword().equals(password)){
        return user;
       }
             
       else{
         throw new UserInvalidException("User invalid");
       }
    }

    public void register(User user){
        if(usersByEmail.containsKey(user.getEmail())){
         throw new UserAlreadyExistsException("User already exists");
       }
       else{
        //userById.put(user.getUserId(), user);  
        usersByEmail.put(user.getEmail(), user);
       }
    }
}
