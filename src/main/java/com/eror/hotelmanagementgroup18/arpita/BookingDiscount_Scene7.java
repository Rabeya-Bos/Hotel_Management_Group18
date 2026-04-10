package com.eror.hotelmanagementgroup18.arpita;

import java.io.Serializable;

public class BookingDiscount_Scene7 implements Serializable {

    private int bookingId;
    private String bookingName;
    private int roomNo;
    private double totalAmount;
    private String status;

    public BookingDiscount_Scene7(int bookingId, String bookingName, int roomNo, double totalAmount, String status) {
        this.bookingId = bookingId;
        this.bookingName = bookingName;
        this.roomNo = roomNo;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getBookingName() {
        return bookingName;
    }

    public void setBookingName(String bookingName) {
        this.bookingName = bookingName;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BookingDiscount_Scene7{" +
                "bookingId=" + bookingId +
                ", bookingName='" + bookingName + '\'' +
                ", roomNo=" + roomNo +
                ", totalAmount=" + totalAmount +
                ", status='" + status + '\'' +
                '}';
    }
}
