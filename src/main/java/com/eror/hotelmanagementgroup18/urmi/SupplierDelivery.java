package com.eror.hotelmanagementgroup18.urmi;

import java.time.LocalDate;

public class SupplierDelivery {
    private String deliveryId;
    private String supplier;
    private String item;
    private int quantityReceived;
    private String status;

    public SupplierDelivery(String deliveryId, String supplier, String item, int quantityReceived, String status) {
        this.deliveryId = deliveryId;
        this.supplier = supplier;
        this.item = item;
        this.quantityReceived = quantityReceived;
        this.status = status;
    }

    public String getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(String deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getQuantityReceived() {
        return quantityReceived;
    }

    public void setQuantityReceived(int quantityReceived) {
        this.quantityReceived = quantityReceived;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SupplierDelivery{" +
                "deliveryId='" + deliveryId + '\'' +
                ", supplier='" + supplier + '\'' +
                ", item='" + item + '\'' +
                ", quantityReceived=" + quantityReceived +
                ", status='" + status + '\'' +
                '}';
    }
}
