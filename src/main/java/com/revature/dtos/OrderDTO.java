package com.revature.dtos;

import com.revature.entities.Item;
import com.revature.entities.Order;
import com.revature.entities.User;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class OrderDTO {
    private UserDTO user;
    private Item item;
    private int quantity;
    private Timestamp purchase_date;

    public OrderDTO(Order order){
        this.user = new UserDTO(order.getUser());
        this.item = order.getItem();
        this.quantity = order.getQuantity();
        this.purchase_date = order.getPurchase_date();
    }

    public OrderDTO(UserDTO user, Item item, int quantity, Timestamp purchase_date) {
        this.user = user;
        this.item = item;
        this.quantity = quantity;
        this.purchase_date = purchase_date;
    }
}
