package com.revature.controllers;

import com.revature.dtos.CredentialsDTO;
import com.revature.dtos.UserDTO;
import com.revature.services.AuthService;
import com.revature.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private AuthService as;
    private TokenService ts;

    @Autowired
    public AuthController(AuthService as){
        this.as = as;
        this.ts = ts;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<UserDTO> authenticate(@RequestBody CredentialsDTO creds){
        UserDTO user = as.authenticate(creds);

        String token = ts.generateToken(user);
        HttpHeaders headers = new HttpHeaders();
        headers.set ("Authorization", token);

        return new ResponseEntity<>(user, headers, HttpStatus.OK);
    }
}
