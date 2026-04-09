package com.eror.hotelmanagementgroup18;

public class User {
    public String getGuestID() {
        return GuestID;
    }

    public String getGuestpassword() {
        return Guestpassword;
    }

    public String getReceptionistID() {
        return ReceptionistID;
    }

    public String getReceptionistpassword() {
        return Receptionistpassword;
    }

    private final String GuestID = "Guest";
    private final String Guestpassword = "1234";
    private final String ReceptionistID = "Receptionist";
    private final String Receptionistpassword = "1234";


    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "GuestID='" + GuestID + '\'' +
                ", Guestpassword='" + Guestpassword + '\'' +
                ", ReceptionistID='" + ReceptionistID + '\'' +
                ", Receptionistpassword='" + Receptionistpassword + '\'' +
                '}';
    }
}
