package com.eror.hotelmanagementgroup18.urmi;

import java.time.LocalDate;

public class InventoryReport {
    private String category;
    private LocalDate date;
    private int quantity;

    public InventoryReport(String category, LocalDate date, int quantity) {
        this.category = category;
        this.date = date;
        this.quantity = quantity;
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

    @Override
    public String toString() {
        return "InventoryReport{" +
                "category='" + category + '\'' +
                ", date=" + date +
                ", quantity=" + quantity +
                '}';
    }
}
