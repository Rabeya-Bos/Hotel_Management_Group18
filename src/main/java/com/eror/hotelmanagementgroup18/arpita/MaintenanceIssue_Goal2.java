package com.eror.hotelmanagementgroup18.arpita;

import java.io.Serializable;

public class MaintenanceIssue_Goal2 implements Serializable {

    private int roomNumber;
    private String issueType;
    private String severity;
    private String description;
    private String status;
    private String flag;

    // constructor
    public MaintenanceIssue_Goal2(int roomNumber, String issueType,
                                   String severity, String description,
                                   String status, String flag) {

        this.roomNumber = roomNumber;
        this.issueType = issueType;
        this.severity = severity;
        this.description = description;
        this.status = status;
        this.flag = flag;
    }

    // getters
    public int getRoomNumber() {
        return roomNumber;
    }

    public String getIssueType() {
        return issueType;
    }

    public String getSeverity() {
        return severity;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public String getFlag() {
        return flag;
    }

    // setter (optional for future update)
    public void setStatus(String status) {
        this.status = status;
    }
}