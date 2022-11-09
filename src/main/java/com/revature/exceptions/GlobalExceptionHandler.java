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

    @ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "User needs to be signed in to perform this operation.")
    @ExceptionHandler(AuthenticationException.class)
    public void handleAuthenticationException(){}
}
