package com.eror.hotelmanagementgroup18.arpita;

import java.io.Serializable;

public class MaintenanceIssue_Goal2 implements Serializable {

    private int roomNumber;
    private String issueType;
    private String severity;
    private String description;
    private String status;
    private String flag;

    public MaintenanceIssue_Goal2(int roomNumber, String issueType, String severity, String description, String status, String flag) {
        this.roomNumber = roomNumber;
        this.issueType = issueType;
        this.severity = severity;
        this.description = description;
        this.status = status;
        this.flag = flag;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getIssueType() {
        return issueType;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "MaintenanceIssue_Goal2{" +
                "roomNumber=" + roomNumber +
                ", issueType='" + issueType + '\'' +
                ", severity='" + severity + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", flag='" + flag + '\'' +
                '}';
    }
}