package com.eror.hotelmanagementgroup18.urmi;

import java.time.LocalDate;

public class StockUsage {
    private String department;
    private String item;
    private int quantityUsed;
    private LocalDate usageDate;

    public StockUsage(String department, String item, int quantityUsed, LocalDate usageDate) {
        this.department = department;
        this.item = item;
        this.quantityUsed = quantityUsed;
        this.usageDate = usageDate;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getQuantityUsed() {
        return quantityUsed;
    }

    public void setQuantityUsed(int quantityUsed) {
        this.quantityUsed = quantityUsed;
    }

    public LocalDate getUsageDate() {
        return usageDate;
    }

    public void setUsageDate(LocalDate usageDate) {
        this.usageDate = usageDate;
    }

    @Override
    public String toString() {
        return "StockUsage{" +
                "department='" + department + '\'' +
                ", item='" + item + '\'' +
                ", quantityUsed=" + quantityUsed +
                ", usageDate=" + usageDate +
                '}';
    }
}
