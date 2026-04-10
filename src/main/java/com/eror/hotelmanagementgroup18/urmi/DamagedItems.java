package com.eror.hotelmanagementgroup18.urmi;

import java.time.LocalDate;

public class DamagedItems {
    private String recordId;
    private String itemName;
    private String condition;
    private int quantity;
    private LocalDate dateReported;
    private String status;

    public DamagedItems(String recordId, String itemName, String condition, int quantity, LocalDate dateReported, String status) {
        this.recordId = recordId;
        this.itemName = itemName;
        this.condition = condition;
        this.quantity = quantity;
        this.dateReported = dateReported;
        this.status = status;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getDateReported() {
        return dateReported;
    }

    public void setDateReported(LocalDate dateReported) {
        this.dateReported = dateReported;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "DamagedItems{" +
                "recordId='" + recordId + '\'' +
                ", itemName='" + itemName + '\'' +
                ", condition='" + condition + '\'' +
                ", quantity=" + quantity +
                ", dateReported=" + dateReported +
                ", status='" + status + '\'' +
                '}';
    }
}