package com.eror.hotelmanagementgroup18.urmi;

import java.time.LocalDate;

public class ProcessPayment {
    private String guestId;
    private String roomNumber;
    private double amount;

    public ProcessPayment(String guestId, String roomNumber, double amount) {
        this.guestId = guestId;
        this.roomNumber = roomNumber;
        this.amount = amount;
    }

    public String getGuestId() {
        return guestId;
    }

    public void setGuestId(String guestId) {
        this.guestId = guestId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "ProcessPayment{" +
                "guestId='" + guestId + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                ", amount=" + amount +
                '}';
    }
}
