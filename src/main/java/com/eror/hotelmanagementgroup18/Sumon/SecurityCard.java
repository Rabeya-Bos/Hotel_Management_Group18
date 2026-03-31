package com.eror.hotelmanagementgroup18.Sumon;

public class SecurityCard {
    private String staffId, accessLevel, status;

    public SecurityCard(String staffId, String accessLevel, String status) {
        this.staffId = staffId;
        this.accessLevel = accessLevel;
        this.status = status;
    }

    public String getStaffId() { return staffId; }
    public String getAccessLevel() { return accessLevel; }
    public String getStatus() { return status; }
}