package com.revature.controllers;

import com.revature.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ItemController {

    private ItemService is;

    @Autowired
    public ItemController(ItemService is) {
        this.is = is;
    }
}
