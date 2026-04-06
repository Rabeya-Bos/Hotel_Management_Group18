package com.eror.hotelmanagementgroup18.arpita;

import java.io.Serializable;

public class StaffSchedule_Scene8 implements Serializable {

    private String staffName;
    private String department;
    private String shift;

    // constructor
    public StaffSchedule_Scene8(String staffName, String department, String shift) {
        this.staffName = staffName;
        this.department = department;
        this.shift = shift;
    }

    // getters
    public String getStaffName() {
        return staffName;
    }

    public String getDepartment() {
        return department;
    }

    public String getShift() {
        return shift;
    }
}
