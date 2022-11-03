package com.revature.controllers;

import com.revature.entities.Item;
import com.revature.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/items")
public class ItemController {

    private ItemService is;

    @Autowired
    public ItemController(ItemService is) {
        this.is = is;
    }

    @GetMapping
    public ResponseEntity<List<Item>> getItems(){
        return new ResponseEntity<>(is.getAllItems(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    //Item by ID Method with ID param
    public ResponseEntity<Item> getById(@PathVariable("id") String id) {
        Optional<Item> items = is.getItemById(id);
        if(items.isPresent()){
            return new ResponseEntity<>(items.get() , HttpStatus.OK);
        }else{
            throw new NullPointerException();
        }

    }

}
