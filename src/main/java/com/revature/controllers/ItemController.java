package com.revature.controllers;

import com.revature.entities.Item;
import com.revature.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.LoginException;
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

    @GetMapping // all items
    public ResponseEntity<List<Item>> getItems() {
        return new ResponseEntity<>(is.getAllItems(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    //Item by ID Method with ID param
    public ResponseEntity<Item> getById(@PathVariable("id") String id) {
        Optional<Item> items = is.getItemById(id);
        if (items.isPresent()) {
            return new ResponseEntity<>(items.get(), HttpStatus.OK);
        } else {
            throw new NullPointerException();
        }

    }

    @GetMapping("/random/{count}")
    // get a random list of {count} items
    public ResponseEntity<List<Item>> getRandomItems(@PathVariable("count") int count) {
        return new ResponseEntity<>(is.getRandomItems(count), HttpStatus.OK);
    }

    @GetMapping("/single/{name}")
    public ResponseEntity<Item> getItemByNameAndMaterial(@PathVariable("name") String name, @RequestParam(name = "material") String material) {
        return new ResponseEntity<>(is.getItemByNameAndMaterial(name, material), HttpStatus.OK);
    }


//    @Permissions(rolesAllowed = {"ADMIN"})
    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    //Update Item price by id
    public ResponseEntity<Item> updateItem(
            @PathVariable String id, @RequestBody Item item){
        Item price = null;
        try {
            price = is.updateItem(id, item);
        } catch (LoginException e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(price, HttpStatus.OK);
    }
}

