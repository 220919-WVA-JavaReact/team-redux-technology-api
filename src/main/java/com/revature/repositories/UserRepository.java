package com.revature.repositories;

import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    private UserService us;

    @Autowired
    public UserRepository(UserService us) {
        this.us = us;
    }
}
