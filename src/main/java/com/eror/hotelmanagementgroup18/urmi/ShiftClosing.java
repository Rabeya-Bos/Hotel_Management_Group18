package com.eror.hotelmanagementgroup18.urmi;

public class ShiftClosing {
    private String Type;
    private int Count;
    private double Amount;

    public ShiftClosing(String type, int count, double amount) {
        Type = type;
        Count = count;
        Amount = amount;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int count) {
        Count = count;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double amount) {
        Amount = amount;
    }

    @Override
    public String toString() {
        return "ShiftClosing{" +
                "Type='" + Type + '\'' +
                ", Count=" + Count +
                ", Amount=" + Amount +
                '}';
    }
}
