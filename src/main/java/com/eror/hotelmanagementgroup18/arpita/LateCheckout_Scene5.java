package com.eror.hotelmanagementgroup18.arpita;

public class LateCheckout_Scene5 {
    private int bookingId;
    private String bookingName;
    private String checkOutDate;
    private String decision;

    public LateCheckout_Scene5(int bookingId, String bookingName, String checkOutDate, String decision) {
        this.bookingId = bookingId;
        this.bookingName = bookingName;
        this.checkOutDate = checkOutDate;
        this.decision = decision;
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

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    @Override
    public String toString() {
        return "LateCheckout_Scene5{" +
                "bookingId=" + bookingId +
                ", bookingName='" + bookingName + '\'' +
                ", checkOutDate='" + checkOutDate + '\'' +
                ", decision='" + decision + '\'' +
                '}';
    }
}
