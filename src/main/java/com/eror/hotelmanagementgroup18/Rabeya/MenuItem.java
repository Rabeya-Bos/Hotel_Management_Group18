package com.eror.hotelmanagementgroup18.Rabeya;

import java.io.Serializable;

public class MenuItem implements Serializable {

    private int id;
    private String name;
    private String description;
    private String category;
    private double price;

    public MenuItem(int id, String name, String description, String category, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return name;
    }
}