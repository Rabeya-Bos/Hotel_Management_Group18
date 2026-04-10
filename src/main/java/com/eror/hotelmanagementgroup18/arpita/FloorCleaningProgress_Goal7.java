package com.eror.hotelmanagementgroup18.arpita;

import java.io.Serializable;
import java.time.LocalDate;

public class FloorCleaningProgress_Goal7 implements Serializable {

    private String floorNumber;
    private String assignedStaff;
    private String cleaningStatus;
    private boolean priority;
    private boolean additionalOption;
    private LocalDate date;

    public FloorCleaningProgress_Goal7(String floorNumber, String assignedStaff, String cleaningStatus, boolean priority, boolean additionalOption, LocalDate date) {
        this.floorNumber = floorNumber;
        this.assignedStaff = assignedStaff;
        this.cleaningStatus = cleaningStatus;
        this.priority = priority;
        this.additionalOption = additionalOption;
        this.date = date;
    }

    public String getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(String floorNumber) {
        this.floorNumber = floorNumber;
    }

    public String getAssignedStaff() {
        return assignedStaff;
    }

    public void setAssignedStaff(String assignedStaff) {
        this.assignedStaff = assignedStaff;
    }

    public String getCleaningStatus() {
        return cleaningStatus;
    }

    public void setCleaningStatus(String cleaningStatus) {
        this.cleaningStatus = cleaningStatus;
    }

    public boolean isPriority() {
        return priority;
    }

    public void setPriority(boolean priority) {
        this.priority = priority;
    }

    public boolean isAdditionalOption() {
        return additionalOption;
    }

    public void setAdditionalOption(boolean additionalOption) {
        this.additionalOption = additionalOption;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "FloorCleaningProgress_Goal7{" +
                "floorNumber='" + floorNumber + '\'' +
                ", assignedStaff='" + assignedStaff + '\'' +
                ", cleaningStatus='" + cleaningStatus + '\'' +
                ", priority=" + priority +
                ", additionalOption=" + additionalOption +
                ", date=" + date +
                '}';
    }
}
