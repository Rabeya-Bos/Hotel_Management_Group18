package com.eror.hotelmanagementgroup18.Sumon;

public class Incident {
    private String id, type, description;

    public Incident(String id, String type, String description) {
        this.id = id;
        this.type = type;
        this.description = description;
    }

    public String getId() { return id; }
    public String getType() { return type; }
    public String getDescription() { return description; }
}