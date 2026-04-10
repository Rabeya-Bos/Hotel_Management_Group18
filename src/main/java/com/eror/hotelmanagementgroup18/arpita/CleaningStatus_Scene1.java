package com.eror.hotelmanagementgroup18.arpita;

import java.io.Serializable;

public class CleaningStatus_Scene1 implements Serializable {

    private int roomNumber;
    private String roomType;
    private String cleaningStatus;
    private String priority;
    private String additionalOption;

    public CleaningStatus_Scene1(int roomNumber, String roomType, String cleaningStatus, String priority, String additionalOption) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.cleaningStatus = cleaningStatus;
        this.priority = priority;
        this.additionalOption = additionalOption;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getCleaningStatus() {
        return cleaningStatus;
    }

    public void setCleaningStatus(String cleaningStatus) {
        this.cleaningStatus = cleaningStatus;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getAdditionalOption() {
        return additionalOption;
    }

    public void setAdditionalOption(String additionalOption) {
        this.additionalOption = additionalOption;
    }

    @Override
    public String toString() {
        return "CleaningStatus_Scene1{" +
                "roomNumber=" + roomNumber +
                ", roomType='" + roomType + '\'' +
                ", cleaningStatus='" + cleaningStatus + '\'' +
                ", priority='" + priority + '\'' +
                ", additionalOption='" + additionalOption + '\'' +
                '}';
    }
}