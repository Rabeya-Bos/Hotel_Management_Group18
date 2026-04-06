package com.eror.hotelmanagementgroup18.arpita;

import java.io.Serializable;

public class SeasonalPricing_Scene6 implements Serializable {

    private String startDate;
    private String endDate;
    private double price;

    // constructor
    public SeasonalPricing_Scene6(String startDate, String endDate, double price) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public double getPrice() {
        return price;
    }
}
