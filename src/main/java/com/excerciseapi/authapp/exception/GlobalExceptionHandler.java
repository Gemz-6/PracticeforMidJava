package com.excerciseapi.authapp.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.excerciseapi.authapp.dto.ApiResponse;

import org.springframework.http.HttpStatus;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse handleUserExists(UserAlreadyExistsException e) {
        return new ApiResponse(e.getMessage());

    }

    @ExceptionHandler(UserInvalidException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ApiResponse handlerInvalidCredentials(UserInvalidException e) {
        return new ApiResponse(e.getMessage());
    }
}
