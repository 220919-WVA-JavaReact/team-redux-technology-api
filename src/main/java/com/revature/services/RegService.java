package com.revature.services;

import com.revature.dtos.RegisterDTO;
import com.revature.dtos.UserDTO;
import com.revature.entities.User;
import com.revature.exceptions.LoginException;
import com.revature.repositories.UserRepository;
import com.revature.utils.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.beans.Transient;
import java.util.Optional;

@Service
public class RegService {

    private UserRepository usr;

    @Autowired
    public RegService(UserRepository usr){
        this.usr = usr;
    }

    @Transactional
    public UserDTO register(RegisterDTO reg) {

        if (reg.getUsername() == null || reg.getUsername().equals("") || reg.getPassword() == null || reg.getPassword().equals("")) {
            throw new LoginException();
        }

        Optional<User> foundUser = usr.findUserByUsername(reg.getUsername());

        if (foundUser.isPresent()){
            throw new LoginException();
        } else {
            User user = new User();
            user.setFirst_name(reg.getFirst_name());
            user.setLast_name(reg.getLast_name());
            user.setUsername(reg.getUsername());
            user.setPassword(reg.getPassword());
            user.setEmail(reg.getEmail());

            User savedUser = usr.save(user);
            return new UserDTO(savedUser);
        }
    }
}
