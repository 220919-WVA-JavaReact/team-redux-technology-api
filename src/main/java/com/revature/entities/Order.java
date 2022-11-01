package com.revature.entities;

import java.sql.Timestamp;
import java.util.Objects;

public class Order {
    private int order_id;
    private User user;
    private Item item;
    private int quantity;
    private Timestamp purchase_date;

    public Order(int order_id, User user, Item item, int quantity, Timestamp purchase_date) {
        this.order_id = order_id;
        this.user = user;
        this.item = item;
        this.quantity = quantity;
        this.purchase_date = purchase_date;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Timestamp getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(Timestamp purchase_date) {
        this.purchase_date = purchase_date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return order_id == order.order_id && quantity == order.quantity && user.equals(order.user) && item.equals(order.item) && purchase_date.equals(order.purchase_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order_id, user, item, quantity, purchase_date);
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", user=" + user +
                ", item=" + item +
                ", quantity=" + quantity +
                ", purchase_date=" + purchase_date +
                '}';
    }
}
