package com.revature.minecraftstore.services;

import com.revature.MinecraftStoreApplication;
import com.revature.entities.Item;
import com.revature.repositories.ItemRepository;
import com.revature.services.ItemService;
import com.revature.utils.Material;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = MinecraftStoreApplication.class)
public class ItemServiceTest {

    @MockBean
    ItemRepository ir;

    @Autowired
    private ItemService is;

    @Test
    public void getAllItemsTest(){
        Item item1 = new Item();
        item1.setItem_id("1");
        item1.setImage("photo1");
        item1.setName("Hoe");
        item1.setPrice(100.99);
        item1.setMaterial(Material.NETHERITE);

        Item item2 = new Item();
        item2.setItem_id("2");
        item2.setImage("photo2");
        item2.setName("Sword");
        item2.setPrice(50.99);
        item2.setMaterial(Material.DIAMOND);

        Item item3 = new Item();
        item3.setItem_id("3");
        item3.setImage("photo3");
        item3.setName("Axe");
        item3.setPrice(10.99);
        item3.setMaterial(Material.IRON);

        Item test1 = new Item();
        test1.setItem_id("1");
        test1.setImage("photo1");
        test1.setName("Hoe");
        test1.setPrice(100.99);
        test1.setMaterial(Material.NETHERITE);

        Item test2 = new Item();
        test2.setItem_id("2");
        test2.setImage("photo2");
        test2.setName("Sword");
        test2.setPrice(50.99);
        test2.setMaterial(Material.DIAMOND);

        Item test3 = new Item();
        test3.setItem_id("3");
        test3.setImage("photo3");
        test3.setName("Axe");
        test3.setPrice(10.99);
        test3.setMaterial(Material.IRON);

        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);

        List<Item> test = new ArrayList<>();
        test.add(test1);
        test.add(test2);
        test.add(test3);

        Mockito.when(ir.findAll()).thenReturn(items);
         List<Item> actual = is.getAllItems();

         assertEquals(actual, test);
    }

    @Test
    public void getByIdTest(){
        Item item1 = new Item();
        item1.setItem_id("1");
        item1.setImage("photo1");
        item1.setName("Hoe");
        item1.setPrice(100.99);
        item1.setMaterial(Material.NETHERITE);

        Item item2 = new Item();
        item2.setItem_id("2");
        item2.setImage("photo2");
        item2.setName("Sword");
        item2.setPrice(50.99);
        item2.setMaterial(Material.DIAMOND);

        Mockito.when(ir.findById(item1.getItem_id())).thenReturn(Optional.of(item1));

        Optional<Item> actual = is.getItemById("1");
        assertEquals(actual, Optional.of(item1));
    }

    @Test
    public void getByNameAndMatTest(){
        Item item1 = new Item();
        item1.setItem_id("1");
        item1.setImage("photo1");
        item1.setName("Hoe");
        item1.setPrice(100.99);
        item1.setMaterial(Material.NETHERITE);

        Item item2 = new Item();
        item2.setItem_id("2");
        item2.setImage("photo2");
        item2.setName("Sword");
        item2.setPrice(50.99);
        item2.setMaterial(Material.DIAMOND);

        Mockito.when(is.getItemByNameAndMaterial("Sword", "DIAMOND")).thenReturn(item2);

        Item actual = is.getItemByNameAndMaterial("Sword", "DIAMOND");
        assertEquals(actual, item2);
    }

    @Test
    public void getRandomTest(){

    }
}
