package com.eror.hotelmanagementgroup18.urmi;

public class LowStock {
    private String itemName;
    private int currentStock;
    private int threshold;
    private boolean isLowStock;

    public LowStock(String itemName, boolean isLowStock, int threshold, int currentStock) {
        this.itemName = itemName;
        this.isLowStock = isLowStock;
        this.threshold = threshold;
        this.currentStock = currentStock;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getThreshold() {
        return threshold;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

    public boolean isLowStock() {
        return isLowStock;
    }

    public void setLowStock(boolean lowStock) {
        isLowStock = lowStock;
    }

    public int getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(int currentStock) {
        this.currentStock = currentStock;
    }

    @Override
    public String toString() {
        return "LowStock{" +
                "itemName='" + itemName + '\'' +
                ", currentStock=" + currentStock +
                ", threshold=" + threshold +
                ", isLowStock=" + isLowStock +
                '}';
    }
}
