package com.eror.hotelmanagementgroup18.Sumon;

public class PayrollData {
    private String staffId, name, basePay, overtime, total;

    public PayrollData(String staffId, String name, String basePay, String overtime, String total) {
        this.staffId = staffId;
        this.name = name;
        this.basePay = basePay;
        this.overtime = overtime;
        this.total = total;
    }

    public String getStaffId() { return staffId; }
    public String getName() { return name; }
    public String getBasePay() { return basePay; }
    public String getOvertime() { return overtime; }
    public String getTotal() { return total; }
}