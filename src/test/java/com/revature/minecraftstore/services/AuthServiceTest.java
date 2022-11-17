package com.revature.minecraftstore.services;

import com.revature.MinecraftStoreApplication;
import com.revature.dtos.CredentialsDTO;
import com.revature.dtos.UserDTO;
import com.revature.entities.User;
import com.revature.exceptions.LoginException;
import com.revature.repositories.UserRepository;
import com.revature.services.AuthService;
import com.revature.utils.Role;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(classes = MinecraftStoreApplication.class)
public class AuthServiceTest {

    @MockBean
    private UserRepository mockRepository;

    @Autowired
    private AuthService sut;

    @Test
    public void authenticateCorrect(){
        User returnedUser = new User();
        returnedUser.setUser_id("2");
        returnedUser.setUsername("rogelio");
        returnedUser.setPassword("pass");
        returnedUser.setFirst_name("roger");
        returnedUser.setLast_name("chau");
        returnedUser.setEmail("rogelio@email.com");
        returnedUser.setRole(Role.BUYER);

        UserDTO expected = new UserDTO();
        expected.setUser_id("2");
        expected.setUsername("rogelio");
        expected.setRole(Role.BUYER);

        CredentialsDTO creds = new CredentialsDTO();
        creds.setUsername("rogelio");
        creds.setPassword("pass");

        Mockito.when(mockRepository.findUserByUsernameAndPassword("rogelio", "pass"))
                .thenReturn(Optional.of(returnedUser));

        UserDTO actual = sut.authenticate(creds);

        assertEquals(expected, actual);
    }

    @Test
    public void authenticateUserDoesNotExist(){
        CredentialsDTO creds = new CredentialsDTO();
        creds.setUsername("fakeUser");
        creds.setPassword("fakePass");

        Mockito.when(mockRepository.findUserByUsernameAndPassword("fakeUser", "fakePass"))
                .thenReturn(Optional.empty());

        assertThrows(LoginException.class, () -> sut.authenticate(creds));
    }
}
