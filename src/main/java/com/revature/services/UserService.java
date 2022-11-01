package com.revature.services;

import com.revature.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@Scope("Singleton") <- this is implicit
public class UserService {
    private UserRepository ur;

    @Autowired
    public UserService(UserRepository ur) {
        this.ur = ur;
    }
}
