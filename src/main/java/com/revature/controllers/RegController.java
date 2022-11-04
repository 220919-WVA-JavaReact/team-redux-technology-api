package com.revature.controllers;

import com.revature.dtos.RegisterDTO;
import com.revature.dtos.UserDTO;
import com.revature.services.RegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")

public class RegController {
    private RegService rs;

    @Autowired
    public RegController(RegService rs) {this.rs = rs;}

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<UserDTO> register(@RequestBody RegisterDTO reg){
        UserDTO user = rs.register(reg);

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

}
