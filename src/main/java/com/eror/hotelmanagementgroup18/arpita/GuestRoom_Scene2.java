package com.eror.hotelmanagementgroup18.arpita;

public class GuestRoom_Scene2 {

    private int bookingId;
    private String guestName;
    private String roomType;

    public GuestRoom_Scene2(int bookingId, String guestName, String roomType) {
        this.bookingId = bookingId;
        this.guestName = guestName;
        this.roomType = roomType;
    }

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

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    @Override
    public String toString() {
        return "GuestRoom_Scene2{" +
                "bookingId=" + bookingId +
                ", guestName='" + guestName + '\'' +
                ", roomType='" + roomType + '\'' +
                '}';
    }
}