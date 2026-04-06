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

    public EmergencyReport_Goal5(String location, LocalDate date, String description,
                                 String emergencyType, String securityLevel,
                                 boolean status, boolean additionalFlag) {
        this.location = location;
        this.date = date;
        this.description = description;
        this.emergencyType = emergencyType;
        this.securityLevel = securityLevel;
        this.status = status;
        this.additionalFlag = additionalFlag;
    }

    public String getLocation() { return location; }
    public LocalDate getDate() { return date; }
    public String getDescription() { return description; }
    public String getEmergencyType() { return emergencyType; }
    public String getSecurityLevel() { return securityLevel; }
    public boolean isStatus() { return status; }
    public boolean isAdditionalFlag() { return additionalFlag; }
}
