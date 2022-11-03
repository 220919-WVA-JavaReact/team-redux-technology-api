package com.revature.services;

import com.revature.entities.Item;
import com.revature.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private ItemRepository ir;

    @Autowired
    public ItemService(ItemRepository ir) {
        this.ir = ir;
    }

    public List<Item> getAllItems(){
        return ir.findAll();
    }


    public Optional<Item> getItemById(String id) {
        //find Item by Id for single page display
        return ir.findById(id);
    }
}
