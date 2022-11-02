package com.revature.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name="orders")
public class Order {
    @Id
    private String order_id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name="item_id", nullable=false)
    private Item item;
    @Column(nullable = false)
    private int quantity;
    private Timestamp purchase_date;

    public Order(String order_id, User user, Item item, int quantity, Timestamp purchase_date) {
        this.order_id = order_id;
        this.user = user;
        this.item = item;
        this.quantity = quantity;
        this.purchase_date = purchase_date;
    }

    public Order() {
        this.order_id = UUID.randomUUID().toString();
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
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
