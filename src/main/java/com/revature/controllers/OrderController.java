package com.revature.controllers;

import com.revature.dtos.CredentialsDTO;
import com.revature.dtos.OrderDTO;
import com.revature.entities.Order;
import com.revature.services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private OrderService os;

    public OrderController(OrderService os){
        this.os = os;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<OrderDTO> postOrder(@RequestBody List<OrderDTO> orders){

        for (OrderDTO order : orders){
            if (os.saveOrder(order) != null){
                System.out.println("Saved order");
            };
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{user_id}")
    public ResponseEntity<List<OrderDTO>> getUserOrders(@PathVariable("user_id") String userId){
        return new ResponseEntity<>(os.getUserOrders(userId), HttpStatus.OK);
    }
}
