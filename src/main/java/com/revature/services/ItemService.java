package com.revature.services;

import com.revature.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    private ItemRepository ir;

    @Autowired
    public ItemService(ItemRepository ir) {
        this.ir = ir;
    }
}
