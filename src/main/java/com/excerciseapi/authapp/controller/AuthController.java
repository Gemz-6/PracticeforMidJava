package com.excerciseapi.authapp.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excerciseapi.authapp.dto.ApiResponse;
import com.excerciseapi.authapp.model.User;
import com.excerciseapi.authapp.service.AuthService;
import com.excerciseapi.authapp.service.JwtService;

@RestController // Convierte clase en api
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;
    private final JwtService jwtService;

    public AuthController(AuthService authService, JwtService jwtService) {
        this.authService = authService;
        this.jwtService = jwtService;
    }

    @PostMapping("/register")
    public ApiResponse register(@RequestBody User user) { // recibe JSON y lo convierte en user
        authService.register(user.getEmail(), user.getPassword());
        return new ApiResponse("User registered");
    }

    @PostMapping("/login")
    public ApiResponse login(@RequestBody User user) {
        User loggedUser = authService.login(user.getEmail(), user.getPassword());
        String token = jwtService.generateToken(loggedUser);
        // UserResponse response = new UserResponse(loggedUser.getUserId(),
        // loggedUser.getEmail());

        return new ApiResponse("Login Succesful: " + token);
    }
}
