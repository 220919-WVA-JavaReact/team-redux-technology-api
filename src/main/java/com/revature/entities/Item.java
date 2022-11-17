package com.revature.entities;

import com.revature.utils.Material;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name="items")
public class Item {
    @Id
    private String item_id;
    @Column
    private String image;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private double price;
    @Enumerated(EnumType.STRING)
    private Material material;

    public Item(String item_id, String image, String name, double price, Material material) {
        this.item_id = item_id;
        this.image = image;
        this.name = name;
        this.price = price;
        this.material = material;
    }

    public Item() {
        this.item_id = UUID.randomUUID().toString();
    }

    public Item(String id){
        this.item_id = id;
    }


    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "Items{" +
                "item_id=" + item_id +
                ", image='" + image + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", material=" + material +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item items = (Item) o;
        return item_id == items.item_id && Double.compare(items.price, price) == 0 && image.equals(items.image) && name.equals(items.name) && material == items.material;
    }

    @Override
    public int hashCode() {
        return Objects.hash(item_id, image, name, price, material);
    }
}
