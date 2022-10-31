package com.revature.models;

import com.revature.utils.Material;

import java.util.Objects;

public class Items {
    private int item_id;
    private String image;
    private String name;
    private double price;
    private Material material;

    public Items(int item_id, String image, String name, double price, Material material) {
        this.item_id = item_id;
        this.image = image;
        this.name = name;
        this.price = price;
        this.material = material;
    }

    public Items() {
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
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
        Items items = (Items) o;
        return item_id == items.item_id && Double.compare(items.price, price) == 0 && image.equals(items.image) && name.equals(items.name) && material == items.material;
    }

    @Override
    public int hashCode() {
        return Objects.hash(item_id, image, name, price, material);
    }
}
