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

    public LostFound_Goal3(int itemId, String itemName, String category,
                            String location, String date,
                            String status, String valuable) {

        this.itemId = itemId;
        this.itemName = itemName;
        this.category = category;
        this.location = location;
        this.date = date;
        this.status = status;
        this.valuable = valuable;
    }

    // getters
    public int getItemId() { return itemId; }
    public String getItemName() { return itemName; }
    public String getCategory() { return category; }
    public String getLocation() { return location; }
    public String getDate() { return date; }
    public String getStatus() { return status; }
    public String getValuable() { return valuable; }

    // setters (needed for update)
    public void setItemName(String itemName) { this.itemName = itemName; }
    public void setCategory(String category) { this.category = category; }
    public void setLocation(String location) { this.location = location; }
    public void setDate(String date) { this.date = date; }
    public void setStatus(String status) { this.status = status; }
    public void setValuable(String valuable) { this.valuable = valuable; }
}