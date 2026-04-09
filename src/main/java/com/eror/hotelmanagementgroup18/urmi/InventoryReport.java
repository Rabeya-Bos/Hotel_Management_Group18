package com.eror.hotelmanagementgroup18.urmi;

import java.time.LocalDate;

public class InventoryReport {
    private String category;
    private LocalDate date;
    private int quantity;
    private String transactionType; // "IN" for supply, "OUT" for usage
    private String itemName;

    public InventoryReport(String category, LocalDate date, int quantity, String transactionType, String itemName) {
        this.category = category;
        this.date = date;
        this.quantity = quantity;
        this.transactionType = transactionType;
        this.itemName = itemName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public String toString() {
        return "InventoryReport{" +
                "category='" + category + '\'' +
                ", date=" + date +
                ", quantity=" + quantity +
                ", transactionType='" + transactionType + '\'' +
                ", itemName='" + itemName + '\'' +
                '}';
    }
}
