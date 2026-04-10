package com.eror.hotelmanagementgroup18.arpita;

public class Booking_Scene2 {
    private int bookingId;
    private String guestName;
    private String date;
    private String status;

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
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

    @Override
    public String toString() {
        return "Booking_Scene2{" +
                "bookingId=" + bookingId +
                ", guestName='" + guestName + '\'' +
                ", date='" + date + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public Booking_Scene2(String guestName, String date, String status) {
        this.bookingId = bookingId;
        this.guestName = guestName;
        this.date = date;
        this.status = status;


    }
}
