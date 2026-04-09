package com.eror.hotelmanagementgroup18.urmi;

import java.time.LocalDate;

public class SupplierDelivery {
    private String deliveryId;
    private String supplier;
    private String item;
    private int quantityOrdered;
    private int quantityReceived;
    private String status;
    private LocalDate deliveryDate;
    private String poId;

    public SupplierDelivery(String deliveryId, String supplier, String item, int quantityOrdered, int quantityReceived, String status, LocalDate deliveryDate, String poId) {
        this.deliveryId = deliveryId;
        this.supplier = supplier;
        this.item = item;
        this.quantityOrdered = quantityOrdered;
        this.quantityReceived = quantityReceived;
        this.status = status;
        this.deliveryDate = deliveryDate;
        this.poId = poId;
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

    public int getQuantityOrdered() {
        return quantityOrdered;
    }

    public void setQuantityOrdered(int quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
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

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getPoId() {
        return poId;
    }

    public void setPoId(String poId) {
        this.poId = poId;
    }

    @Override
    public String toString() {
        return "SupplierDelivery{" +
                "deliveryId='" + deliveryId + '\'' +
                ", supplier='" + supplier + '\'' +
                ", item='" + item + '\'' +
                ", quantityOrdered=" + quantityOrdered +
                ", quantityReceived=" + quantityReceived +
                ", status='" + status + '\'' +
                ", deliveryDate=" + deliveryDate +
                ", poId='" + poId + '\'' +
                '}';
    }
}
