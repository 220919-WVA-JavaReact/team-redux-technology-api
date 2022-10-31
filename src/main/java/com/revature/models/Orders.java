package com.revature.models;

import java.sql.Timestamp;
import java.util.Objects;

public class Orders {
    private int order_id;
    private int user_id;
    private int item_id;
    private int quantity;
    private Timestamp purchase_date;

    public Orders(int order_id, int user_id, int item_id, int quantity, Timestamp purchase_date) {
        this.order_id = order_id;
        this.user_id = user_id;
        this.item_id = item_id;
        this.quantity = quantity;
        this.purchase_date = purchase_date;
    }

    public Orders() {
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
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
    public String toString() {
        return "Orders{" +
                "order_id=" + order_id +
                ", user_id=" + user_id +
                ", item_id=" + item_id +
                ", quantity=" + quantity +
                ", purchase_date=" + purchase_date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return order_id == orders.order_id && user_id == orders.user_id && item_id == orders.item_id && quantity == orders.quantity && purchase_date.equals(orders.purchase_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order_id, user_id, item_id, quantity, purchase_date);
    }
}
