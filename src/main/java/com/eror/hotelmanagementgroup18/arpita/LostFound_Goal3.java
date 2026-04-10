package com.eror.hotelmanagementgroup18.arpita;

import java.io.Serializable;

public class LostFound_Goal3 implements Serializable {

    private int itemId;
    private String itemName;
    private String category;
    private String location;
    private String date;
    private String status;
    private String valuable;

    public LostFound_Goal3(int itemId, String itemName, String category, String location, String date, String status, String valuable) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.category = category;
        this.location = location;
        this.date = date;
        this.status = status;
        this.valuable = valuable;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getValuable() {
        return valuable;
    }

    public void setValuable(String valuable) {
        this.valuable = valuable;
    }

    @Override
    public String toString() {
        return "LostFound_Goal3{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", category='" + category + '\'' +
                ", location='" + location + '\'' +
                ", date='" + date + '\'' +
                ", status='" + status + '\'' +
                ", valuable='" + valuable + '\'' +
                '}';
    }
}