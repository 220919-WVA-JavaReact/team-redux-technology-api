package com.revature.services;

import com.revature.dtos.CredentialsDTO;
import com.revature.dtos.UserDTO;
import com.revature.entities.User;
import com.revature.exceptions.LoginException;
import com.revature.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private UserRepository usr;

    @Autowired
    public AuthService(UserRepository usr){
        this.usr = usr;
    }

    public UserDTO authenticate(CredentialsDTO creds){
        User user = usr.findUserByUsernameAndPassword(creds.getUsername(), creds.getPassword()).orElseThrow(() -> new LoginException());
        return new UserDTO(user);
    }
}
