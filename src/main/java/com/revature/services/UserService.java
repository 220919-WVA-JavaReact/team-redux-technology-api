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

        System.out.println("User Service initialized");

        User kev = new User();

        kev.setUsername("Kevin");
        kev.setPassword("pass");
        kev.setEmail("kev@email.com");
        kev.setRole(Role.ADMIN);

        // persist Kevin to DB
        ur.save(kev);

        User bryan = new User();

        bryan.setUsername("Bryan");
        bryan.setPassword("pass");
        bryan.setEmail("bryan@email.com");
        bryan.setRole(Role.BUYER);

        // persist Bryan to DB
        ur.save(bryan);


        // retrieve from DB
        System.out.println(ur.findByUsername("Kevin"));
        System.out.println((ur.findByUsername("Bryan")));

        List<User> users = ur.findAll();

        users.forEach(u -> System.out.println(u));
    }
}
