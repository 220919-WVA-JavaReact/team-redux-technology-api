package com.revature.services;

import com.revature.dtos.RegisterDTO;
import com.revature.dtos.UserDTO;
import com.revature.entities.User;
import com.revature.exceptions.LoginException;
import com.revature.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegService {

    private UserRepository usr;

    @Autowired
    public RegService(UserRepository usr){
        this.usr = usr;
    }

    public UserDTO register(RegisterDTO reg){
        User user = usr.save(new User(reg.getFirst_name(), reg.getLast_name(), reg.getUsername(), reg.getPassword(), reg.getEmail()));
        return new UserDTO(user);
    }

}
