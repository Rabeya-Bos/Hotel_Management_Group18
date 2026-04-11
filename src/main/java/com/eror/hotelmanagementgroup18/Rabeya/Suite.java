package com.eror.hotelmanagementgroup18.Rabeya;

import java.io.Serializable;

public class Suite implements Serializable {

    private int suiteNo;
    private String type;
    private String view;
    private double price;

    public Suite(int suiteNo, String type, String view, double price) {
        this.suiteNo = suiteNo;
        this.type = type;
        this.view = view;
        this.price = price;
    }

    public int getSuiteNo() { return suiteNo; }
    public String getType() { return type; }
    public String getView() { return view; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return type + " (" + suiteNo + ")";
    }
}