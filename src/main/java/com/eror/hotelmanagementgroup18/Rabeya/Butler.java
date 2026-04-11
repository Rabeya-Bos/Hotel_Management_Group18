package com.eror.hotelmanagementgroup18.Rabeya;

import java.io.Serializable;

public class Butler implements Serializable {

    private String name;
    private String specialization;
    private String status;
    private String assignedButler;
    private String serviceDate;

    public Butler(String name, String specialization, String status,
                  String assignedButler, String serviceDate) {
        this.name = name;
        this.specialization = specialization;
        this.status = status;
        this.assignedButler = assignedButler;
        this.serviceDate = serviceDate;
    }

    public String getName() { return name; }
    public String getSpecialization() { return specialization; }
    public String getStatus() { return status; }
    public String getAssignedButler() { return assignedButler; }
    public String getServiceDate() { return serviceDate; }

    @Override
    public String toString() {
        return name;
    }
}