package com.eror.hotelmanagementgroup18.Sumon;

public class PricingData {
    private String roomId, currentRate, multiplier, newRate;

    public PricingData(String roomId, String currentRate, String multiplier, String newRate) {
        this.roomId = roomId;
        this.currentRate = currentRate;
        this.multiplier = multiplier;
        this.newRate = newRate;
    }

    public String getRoomId() { return roomId; }
    public String getCurrentRate() { return currentRate; }
    public String getMultiplier() { return multiplier; }
    public String getNewRate() { return newRate; }
}