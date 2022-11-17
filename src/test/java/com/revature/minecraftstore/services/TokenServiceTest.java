package com.revature.minecraftstore.services;

import com.revature.MinecraftStoreApplication;
import com.revature.dtos.UserDTO;
import com.revature.entities.User;
import com.revature.services.TokenService;
import com.revature.utils.Role;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = MinecraftStoreApplication.class)
public class TokenServiceTest {

    @Autowired
    private TokenService ts;

//    @Test
//    public void generateTokenTest(){
//        UserDTO user = new UserDTO();
//        user.setUser_id("1");
//        user.setUsername("rogelio");
//        user.setRole(Role.BUYER);
//
//        UserDTO test = new UserDTO();
//        user.setUser_id("1");
//        user.setUsername("rogelio");
//        user.setRole(Role.BUYER);
//
//        String token = ts.generateToken(user);
//        String expected = String.valueOf(ts.TokenDetails(token));
//
//        String actual = ts.generateToken(test);
//
//        Mockito.when(ts.TokenDetails(actual)).thenReturn(test);
//
//        assertEquals(actual, expected);
//
//
//    }
}
