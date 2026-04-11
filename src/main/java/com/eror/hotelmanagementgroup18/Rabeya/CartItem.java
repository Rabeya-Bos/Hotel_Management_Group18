package com.eror.hotelmanagementgroup18.Rabeya;

import java.io.Serializable;

public class CartItem implements Serializable {

    private String itemName;
    private int quantity;
    private double price;
    private double total;
    private String category;

    public CartItem(MenuItem item, int quantity) {
        this.itemName = item.getName();
        this.quantity = quantity;
        this.price = item.getPrice();
        this.total = price * quantity;
        this.category = item.getCategory();
    }

    public String getItemName() { return itemName; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }
    public double getTotal() { return total; }
    public String getCategory() { return category; }
}