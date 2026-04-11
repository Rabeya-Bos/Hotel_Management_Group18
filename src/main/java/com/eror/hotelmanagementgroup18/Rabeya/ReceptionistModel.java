package com.eror.hotelmanagementgroup18.Rabeya;

import java.io.Serializable;

public class ReceptionistModel implements Serializable {

    private String name;
    private String passport;
    private String phone;
    private String room;
    private boolean flowers;
    private boolean champagne;
    private boolean tempControl;

    public ReceptionistModel(String name, String passport, String phone,
                             String room, boolean flowers,
                             boolean champagne, boolean tempControl) {

        this.name = name;
        this.passport = passport;
        this.phone = phone;
        this.room = room;
        this.flowers = flowers;
        this.champagne = champagne;
        this.tempControl = tempControl;
    }

    public String getName() { return name; }
    public String getPassport() { return passport; }
    public String getPhone() { return phone; }
    public String getRoom() { return room; }

    public String getAmenities() {
        String a = "";
        if (flowers) a += "Flowers ";
        if (champagne) a += "Champagne ";
        if (tempControl) a += "TempControl ";
        return a.trim();
    }
}