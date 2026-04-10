package com.eror.hotelmanagementgroup18.urmi;

import java.time.LocalDate;

public class RecordSupply {
    private LocalDate date;
    private String item;
    private int quantity;

    public RecordSupply(LocalDate date, String item, int quantity) {
        this.date = date;
        this.item = item;
        this.quantity = quantity;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "RecordSupply{" +
                "date=" + date +
                ", item='" + item + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
