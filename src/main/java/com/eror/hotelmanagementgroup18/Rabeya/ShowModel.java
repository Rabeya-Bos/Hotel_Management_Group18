package com.eror.hotelmanagementgroup18.Rabeya;

import java.io.Serializable;

public class ShowModel implements Serializable {

    private String name;
    private String email;
    private String passport;
    private String checkIn;
    private String checkOut;
    private String roomType;
    private String adults;
    private String children;

    public ShowModel(String name, String email, String passport,
                     String checkIn, String checkOut,
                     String roomType, String adults, String children) {

        this.name = name;
        this.email = email;
        this.passport = passport;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.roomType = roomType;
        this.adults = adults;
        this.children = children;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassport() { return passport; }
    public String getCheckIn() { return checkIn; }
    public String getCheckOut() { return checkOut; }
    public String getRoomType() { return roomType; }
    public String getAdults() { return adults; }
    public String getChildren() { return children; }
}