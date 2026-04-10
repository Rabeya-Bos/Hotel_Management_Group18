package com.eror.hotelmanagementgroup18.urmi;

import java.time.LocalDate;

public class GenerateInvoice {
    private String guestId;
    private int nightsStayed;
    private double totalAmount;

    public GenerateInvoice(String guestId, int nightsStayed, double totalAmount) {
        this.guestId = guestId;
        this.nightsStayed = nightsStayed;
        this.totalAmount = totalAmount;
    }

    public String getGuestId() {
        return guestId;
    }

    public void setGuestId(String guestId) {
        this.guestId = guestId;
    }

    public int getNightsStayed() {
        return nightsStayed;
    }

    public void setNightsStayed(int nightsStayed) {
        this.nightsStayed = nightsStayed;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "GenerateInvoice{" +
                "guestId='" + guestId + '\'' +
                ", nightsStayed=" + nightsStayed +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
