package com.excerciseapi.authapp.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.excerciseapi.authapp.dto.ApiResponse;
import com.excerciseapi.authapp.exception.UserAlreadyExistsException;
import com.excerciseapi.authapp.exception.UserInvalidException;
import com.excerciseapi.authapp.model.User;
import com.excerciseapi.authapp.service.AuthService;

@RestController //Convierte clase en api
@RequestMapping("/auth") 
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService){
        this.authService=authService;
    }
    
    //Peticion post
    /**
     * @param user
     * @return
     */
    @PostMapping("/register")
    public ApiResponse register(@RequestBody User user){ //recibe JSON y lo convierte en user
        authService.register(user);
        return new ApiResponse("User registered");
    }

    @PostMapping("/login")
    public ApiResponse login(@RequestBody User user){
        User loggedUser=authService.login(user.getEmail(), user.getPassword());
        return new ApiResponse("Login Succesful");             
    }
}
