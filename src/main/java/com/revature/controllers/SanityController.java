package com.revature.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/sanity")
public class SanityController {
    @GetMapping
    public ResponseEntity<Map<String, Object>> sanity(){
        Map<String, Object> res = new HashMap<>();
        res.put("creeper", "aw man");

        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
