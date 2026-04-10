package com.eror.hotelmanagementgroup18.urmi;

public class LowStock {
    private String itemName;
    private int currentStock;
    private int threshold;

    public LowStock(String itemName, int currentStock, int threshold) {
        this.itemName = itemName;
        this.currentStock = currentStock;
        this.threshold = threshold;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(int currentStock) {
        this.currentStock = currentStock;
    }

    public int getThreshold() {
        return threshold;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

    @Override
    public String toString() {
        return "LowStock{" +
                "itemName='" + itemName + '\'' +
                ", currentStock=" + currentStock +
                ", threshold=" + threshold +
                '}';
    }
}
