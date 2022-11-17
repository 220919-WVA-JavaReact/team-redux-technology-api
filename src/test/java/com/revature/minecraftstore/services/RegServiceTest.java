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
        User user = new User();

        Mockito.when(mockRepository.findUserByUsername("rogelio")).thenReturn(Optional.of(Boolean.FALSE));
        RegisterDTO login = new RegisterDTO();
        login.setUsername("rogelio");
        login.setPassword("pass");
        login.setFirst_name("roger");
        login.setLast_name("chou");
        login.setEmail("poop@email.com");

        user.setUser_id("10");
        user.setUsername(login.getUsername());
        user.setPassword(login.getPassword());
        user.setFirst_name(login.getFirst_name());
        user.setLast_name(login.getLast_name());
        user.setEmail(login.getEmail());
        user.setRole(Role.BUYER);

        UserDTO herro = new UserDTO();
        herro.setUser_id("10");
        herro.setUsername("rogelio");
        herro.setRole(Role.BUYER);


        Mockito.when(mockRepository.save(user)).thenReturn(user);

        UserDTO expected = new UserDTO();
        expected.setUser_id("10");
        expected.setUsername("rogelio");
        expected.setRole(Role.BUYER);

        System.out.println("Expected " + expected);
        UserDTO actual = rs.register(login);
        System.out.println("Actual: " + actual);



        assertEquals(expected, actual);
    }
}
