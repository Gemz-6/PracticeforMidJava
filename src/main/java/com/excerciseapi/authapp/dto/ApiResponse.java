package com.excerciseapi.authapp.dto;

public class ApiResponse {
    private String message;
    // private Object data;

    public ApiResponse(String message) {
        this.message = message;
        // this.data=data;
    }

    public String getMessage() {
        return message;
    }

    // public Object getData(){
    // return data;
    // }

}
