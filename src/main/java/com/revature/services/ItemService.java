package com.revature.services;

import com.revature.entities.Item;
import com.revature.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

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

    public List<Item> getRandomItems(int count){
        // this is for "featured items" in the home page.
        // i want to get a randomized list of several items to display on that page

        List<Item> allItems = ir.findAll();
        // first get all the items
        List<Item> returnItems = new ArrayList<>();
        // make a new list to store the random picks

        Random random = new Random();
        int randIndex;

        for (int i = 0; i < count; i++){
            // iterate {count} times,
            randIndex = random.nextInt(allItems.size() - 1);
            // pick a random int between zero and the length of allItems
            returnItems.add(allItems.remove(randIndex));
            // pluck corresponding item out of the list and add it to returnItems
        }

        return returnItems;
    }

    public Optional<Item> getItemById(String id) {
        //find Item by Id for single page display
        return ir.findById(id);
    }
}
