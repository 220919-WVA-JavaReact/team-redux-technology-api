package com.revature.controllers;

import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserController {
    private UserService us;

    @Autowired // technically autowired on constructor is implicit on newest version of spring
    public UserController(UserService us) {
        this.us = us;
    }
}
