package com.revature.controllers;

import com.revature.entities.Item;
import com.revature.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    private ItemService is;

    @Autowired
    public ItemController(ItemService is) {
        this.is = is;
    }

    @GetMapping("/items")
    public ResponseEntity<List<Item>> getItems(){
        return new ResponseEntity<>(is.getAllItems(), HttpStatus.OK);
    }
}
