package com.revature.minecraftstore.services;

import com.revature.MinecraftStoreApplication;
import com.revature.dtos.RegisterDTO;
import com.revature.dtos.UserDTO;
import com.revature.entities.User;
import com.revature.repositories.UserRepository;
import com.revature.services.RegService;
import com.revature.utils.Role;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = MinecraftStoreApplication.class)
public class RegServiceTest {

    @MockBean
    private UserRepository mockRepository;

    @Autowired
    private RegService rs;

    @Test
    public void registerSuccessful(){

        // these are our input fields
        RegisterDTO input = new RegisterDTO();
        input.setUsername("notrogelio");
        input.setPassword("pass");
        input.setFirst_name("roger");
        input.setLast_name("chou");
        input.setEmail("poop@email.com");

        // this is checking the db for an existing user
        Mockito.when(mockRepository.findUserByUsername("notrogelio")).thenReturn(Optional.empty());

        User createdUser = new User();
        createdUser.setUser_id   ("10");
        createdUser.setUsername  (input.getUsername());
        createdUser.setPassword  (input.getPassword());
        createdUser.setFirst_name(input.getFirst_name());
        createdUser.setLast_name (input.getLast_name());
        createdUser.setEmail     (input.getEmail());
        createdUser.setRole(Role.BUYER);


        UserDTO expected = new UserDTO(createdUser);
        System.out.println("Expected " + expected);


        Mockito.when(mockRepository.save(Mockito.any(User.class))).thenReturn(createdUser);
        UserDTO actual = rs.register(input);
        System.out.println("Actual: " + actual);

        assertEquals(expected, actual);
    }
}
