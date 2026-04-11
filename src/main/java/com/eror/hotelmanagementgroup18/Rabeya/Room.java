package com.eror.hotelmanagementgroup18.Rabeya;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Room {

    private final StringProperty roomNo;
    private final StringProperty type;
    private final StringProperty price;
    private final StringProperty capacity;
    private final StringProperty view;

    public Room(String roomNo, String type, String price, String capacity, String view) {
        this.roomNo = new SimpleStringProperty(roomNo);
        this.type = new SimpleStringProperty(type);
        this.price = new SimpleStringProperty(price);
        this.capacity = new SimpleStringProperty(capacity);
        this.view = new SimpleStringProperty(view);
    }

    // Getters for TableView binding
    public StringProperty roomNoProperty() {
        return roomNo;
    }

    public StringProperty typeProperty() {
        return type;
    }

    public StringProperty priceProperty() {
        return price;
    }

    public StringProperty capacityProperty() {
        return capacity;
    }

    public StringProperty viewProperty() {
        return view;
    }

    // Optional normal getters (useful for debugging)
    public String getRoomNo() {
        return roomNo.get();
    }

    public String getType() {
        return type.get();
    }

    public String getPrice() {
        return price.get();
    }

    public String getCapacity() {
        return capacity.get();
    }

    public String getView() {
        return view.get();
    }
}