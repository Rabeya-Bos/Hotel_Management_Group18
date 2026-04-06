package com.eror.hotelmanagementgroup18.arpita;

import java.io.Serializable;

public class CleaningStatus_Scene1 implements Serializable {

    private int roomNumber;
    private String roomType;
    private String cleaningStatus;
    private String priority;
    private String additionalOption;

    // constructor
    public CleaningStatus_Scene1(int roomNumber, String roomType, String cleaningStatus,
                                 String priority, String additionalOption) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.cleaningStatus = cleaningStatus;
        this.priority = priority;
        this.additionalOption = additionalOption;
    }

    // getters
    public int getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public String getCleaningStatus() {
        return cleaningStatus;
    }

    public String getPriority() {
        return priority;
    }

    public String getAdditionalOption() {
        return additionalOption;
    }
}
