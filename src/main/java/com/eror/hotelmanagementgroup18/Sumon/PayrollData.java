package com.eror.hotelmanagementgroup18.Sumon;

public class PayrollData {
    private String staffId;
    private String name;
    private double basePay;
    private double overtime;
    private double total;

    public PayrollData(String staffId, String name, double basePay, double overtime, double total) {
        this.staffId = staffId;
        this.name = name;
        this.basePay = basePay;
        this.overtime = overtime;
        this.total = total;
    }

    public String getStaffId() { return staffId; }
    public String getName() { return name; }
    public double getBasePay() { return basePay; }
    public double getOvertime() { return overtime; }
    public double getTotal() { return total; }
}