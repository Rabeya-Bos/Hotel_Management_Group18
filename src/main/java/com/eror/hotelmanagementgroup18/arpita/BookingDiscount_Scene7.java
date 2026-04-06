package com.eror.hotelmanagementgroup18.arpita;

import java.io.Serializable;

public class BookingDiscount_Scene7 implements Serializable {

    private int bookingId;
    private String bookingName;
    private int roomNo;
    private double totalAmount;
    private String status;

    // constructor
    public BookingDiscount_Scene7(int bookingId, String bookingName, int roomNo, double totalAmount, String status) {
        this.bookingId = bookingId;
        this.bookingName = bookingName;
        this.roomNo = roomNo;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    // getters
    public int getBookingId() {
        return bookingId;
    }

    public String getBookingName() {
        return bookingName;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getStatus() {
        return status;
    }

    // setter (needed)
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}