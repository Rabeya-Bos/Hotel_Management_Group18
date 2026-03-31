package com.eror.hotelmanagementgroup18.Sumon;

public class VIPGuest {
    private String name, points, tier, history;

    public VIPGuest(String name, String points, String tier, String history) {
        this.name = name;
        this.points = points;
        this.tier = tier;
        this.history = history;
    }

    public String getName() { return name; }
    public String getPoints() { return points; }
    public String getTier() { return tier; }
    public String getHistory() { return history; }
}