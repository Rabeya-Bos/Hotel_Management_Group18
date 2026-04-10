package com.eror.hotelmanagementgroup18.urmi;

public class InventorySync {
    private String timestamp;
    private String department;
    private String status;

    public InventorySync(String timestamp, String department, String status) {
        this.timestamp = timestamp;
        this.department = department;
        this.status = status;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "InventorySync{" +
                "timestamp='" + timestamp + '\'' +
                ", department='" + department + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
