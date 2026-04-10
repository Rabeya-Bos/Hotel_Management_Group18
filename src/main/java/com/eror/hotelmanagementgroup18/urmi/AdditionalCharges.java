package com.eror.hotelmanagementgroup18.urmi;

public class AdditionalCharges {
    private String guestId;
    private String chargeType;
    private double amount;

    public AdditionalCharges(String guestId, String chargeType, double amount) {
        this.guestId = guestId;
        this.chargeType = chargeType;
        this.amount = amount;
    }

    public String getGuestId() {
        return guestId;
    }

    public void setGuestId(String guestId) {
        this.guestId = guestId;
    }

    public String getChargeType() {
        return chargeType;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "AdditionalCharges{" +
                "guestId='" + guestId + '\'' +
                ", chargeType='" + chargeType + '\'' +
                ", amount=" + amount +
                '}';
    }
}