package com.revature.minecraftstore.services;

import com.revature.MinecraftStoreApplication;
import com.revature.dtos.OrderDTO;
import com.revature.entities.Item;
import com.revature.entities.Order;
import com.revature.entities.User;
import com.revature.repositories.OrderRepository;
import com.revature.repositories.UserRepository;
import com.revature.services.OrderService;
import com.revature.utils.Material;
import com.revature.utils.Role;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = MinecraftStoreApplication.class)
public class OrderServiceTest {

    @MockBean
    OrderRepository or;

    @MockBean
    UserRepository ur;

    @Autowired
    private OrderService os;

    @Test
    public void saveOrderTest(){
        User user = new User();
        user.setUser_id("1");
        user.setUsername("roger");
        user.setPassword("pass");
        user.setFirst_name("roger");
        user.setLast_name("chau");
        user.setEmail("roger@email.com");
        user.setRole(Role.BUYER);

        Item item = new Item();
        item.setItem_id("1");
        item.setImage("image");
        item.setName("SWORD");
        item.setPrice(99.99);
        item.setMaterial(Material.NETHERITE);

        Order order = new Order();
        order.setOrder_id("1");
        order.setUser(user);
        order.setItem(item);
        order.setQuantity(2);
        order.setPurchase_date(new Timestamp(System.currentTimeMillis()));

        Order expected = order;

        OrderDTO send = new OrderDTO(order);

        Mockito.when(ur.findById("1")).thenReturn(Optional.of(user));
        Mockito.when(or.save(Mockito.any(Order.class))).thenReturn(order);

        Order actual = os.saveOrder(send);


        assertEquals(expected, actual);
    }

    @Test
    public void getOrdersTest(){
        User user = new User();
        user.setUser_id("1");
        user.setUsername("roger");
        user.setPassword("pass");
        user.setFirst_name("roger");
        user.setLast_name("chau");
        user.setEmail("roger@email.com");
        user.setRole(Role.BUYER);

        Item item = new Item();
        item.setItem_id("1");
        item.setImage("image");
        item.setName("SWORD");
        item.setPrice(99.99);
        item.setMaterial(Material.NETHERITE);

        Order order = new Order();
        order.setOrder_id("1");
        order.setUser(user);
        order.setItem(item);
        order.setQuantity(2);
        order.setPurchase_date(new Timestamp(System.currentTimeMillis()));

        List<Order> foundOrders = new ArrayList<>();
        foundOrders.add(order);

        OrderDTO cory = new OrderDTO(order);
        List<OrderDTO> expected = new ArrayList<>();
        expected.add(cory);

        Mockito.when(ur.findById(user.getUser_id())).thenReturn(Optional.of(user));
        Mockito.when(or.findByUser(user)).thenReturn(foundOrders);

        List<OrderDTO> actual = os.getUserOrders("1");

        assertEquals(expected, actual);
    }
}
