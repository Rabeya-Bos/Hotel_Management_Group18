package com.eror.hotelmanagementgroup18.arpita;

import java.io.Serializable;
import java.time.LocalDate;

public class EmergencyReport_Goal5 implements Serializable {

    private String location;
    private LocalDate date;
    private String description;
    private String emergencyType;
    private String securityLevel;
    private boolean status;
    private boolean additionalFlag;

    public EmergencyReport_Goal5(String location, LocalDate date, String description, String emergencyType, String securityLevel, boolean status, boolean additionalFlag) {
        this.location = location;
        this.date = date;
        this.description = description;
        this.emergencyType = emergencyType;
        this.securityLevel = securityLevel;
        this.status = status;
        this.additionalFlag = additionalFlag;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmergencyType() {
        return emergencyType;
    }

    public void setEmergencyType(String emergencyType) {
        this.emergencyType = emergencyType;
    }

    public String getSecurityLevel() {
        return securityLevel;
    }

    public void setSecurityLevel(String securityLevel) {
        this.securityLevel = securityLevel;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isAdditionalFlag() {
        return additionalFlag;
    }

    public void setAdditionalFlag(boolean additionalFlag) {
        this.additionalFlag = additionalFlag;
    }

    @Override
    public String toString() {
        return "EmergencyReport_Goal5{" +
                "location='" + location + '\'' +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", emergencyType='" + emergencyType + '\'' +
                ", securityLevel='" + securityLevel + '\'' +
                ", status=" + status +
                ", additionalFlag=" + additionalFlag +
                '}';
    }
}
