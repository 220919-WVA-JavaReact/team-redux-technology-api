package com.revature.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Login unsuccessful.")
    @ExceptionHandler(LoginException.class)
    public void handleLoginException(){
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason= "User not found.")
    @ExceptionHandler(UserNotFoundException.class)
    public void handleUserNotFoundException(){

    }
}
