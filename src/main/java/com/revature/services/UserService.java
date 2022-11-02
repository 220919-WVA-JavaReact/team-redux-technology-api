package com.revature.services;

import com.revature.entities.User;
import com.revature.repositories.UserRepository;
import com.revature.utils.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Scope("Singleton") <- this is implicit
public class UserService {
    private UserRepository ur;

    @Autowired
    public UserService(UserRepository ur) {

        // im sorry kevin im just testing
        this.ur = ur;

    }
}
