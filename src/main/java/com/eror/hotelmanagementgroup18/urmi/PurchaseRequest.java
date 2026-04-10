package com.eror.hotelmanagementgroup18.urmi;

import java.time.LocalDate;

public class PurchaseRequest {
    private String requestId;
    private String itemName;
    private int quantity;
    private String vendor;
    private LocalDate requestDate;
    private String status;
    private String reason;

    public PurchaseRequest(String requestId, String reason, String status, LocalDate requestDate, String vendor, int quantity, String itemName) {
        this.requestId = requestId;
        this.reason = reason;
        this.status = status;
        this.requestDate = requestDate;
        this.vendor = vendor;
        this.quantity = quantity;
        this.itemName = itemName;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "PurchaseRequest{" +
                "requestId='" + requestId + '\'' +
                ", itemName='" + itemName + '\'' +
                ", quantity=" + quantity +
                ", vendor='" + vendor + '\'' +
                ", requestDate=" + requestDate +
                ", status='" + status + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }
}
