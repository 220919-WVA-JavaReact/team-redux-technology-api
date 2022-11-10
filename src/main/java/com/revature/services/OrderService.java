package com.revature.services;

import com.revature.dtos.OrderDTO;
import com.revature.dtos.UserDTO;
import com.revature.entities.Order;
import com.revature.entities.User;
import com.revature.exceptions.UserNotFoundException;
import com.revature.repositories.OrderRepository;
import com.revature.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private OrderRepository or;
    private UserRepository ur;

    @Autowired
    public OrderService(OrderRepository or, UserRepository ur){
        this.or = or;
        this.ur = ur;
    }

    public Order saveOrder(Order order){
        return or.save(order);
    }

    public List<OrderDTO> getUserOrders(String userId){
        Optional<User> foundUser = ur.findById(userId);
        if (foundUser.isPresent()){
            //get user
            User user = foundUser.get();

            //get list of orders from db
            List<Order> foundOrders = or.findByUser(user);

            //convert orders into orderDTOs
            List<OrderDTO> sendOrders = new ArrayList<>();
            for (Order order : foundOrders){
                sendOrders.add(new OrderDTO(order));
            }

            // send the dtos
            return sendOrders;
        } else {
            throw new UserNotFoundException();
        }
    }
}
