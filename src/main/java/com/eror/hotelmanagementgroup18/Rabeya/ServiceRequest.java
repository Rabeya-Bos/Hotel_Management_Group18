package com.eror.hotelmanagementgroup18.Rabeya;

import java.io.Serializable;

public class ServiceRequest implements Serializable {

    private String serviceType;
    private String serviceTime;
    private String serviceDate;
    private String instructions;
    private String additionalDetails;

    public ServiceRequest(String serviceType, String serviceTime, String serviceDate,
                          String instructions, String additionalDetails) {

        this.serviceType = serviceType;
        this.serviceTime = serviceTime;
        this.serviceDate = serviceDate;
        this.instructions = instructions;
        this.additionalDetails = additionalDetails;
    }

    public String getServiceType() {
        return serviceType;
    }

    public String getServiceTime() {
        return serviceTime;
    }

    public String getServiceDate() {
        return serviceDate;
    }

    public String getInstructions() {
        return instructions;
    }

    public String getAdditionalDetails() {
        return additionalDetails;
    }
}