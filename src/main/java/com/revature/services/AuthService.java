package com.revature.services;

import com.revature.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthService {
    private UserRepository usr;

    @Autowired
    public AuthService(UserRepository usr){
        this.usr = usr;
    }
}
