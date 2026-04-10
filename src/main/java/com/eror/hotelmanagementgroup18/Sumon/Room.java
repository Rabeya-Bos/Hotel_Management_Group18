package com.eror.hotelmanagementgroup18.Sumon;

public class Room {
    private String roomId;
    private String type;
    private String rate;
    private String status;

    public Room(String roomId, String type, String rate, String status) {
        this.roomId = roomId;
        this.type = type;
        this.rate = rate;
        this.status = status;
    }

    public String getRoomId() { return roomId; }
    public String getType() { return type; }
    public String getRate() { return rate; }
    public String getStatus() { return status; }
}