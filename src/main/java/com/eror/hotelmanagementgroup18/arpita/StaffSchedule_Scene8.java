package com.eror.hotelmanagementgroup18.arpita;

import java.io.Serializable;

public class StaffSchedule_Scene8 implements Serializable {

    private String staffName;
    private String department;
    private String shift;

    public StaffSchedule_Scene8(String staffName, String department, String shift) {
        this.staffName = staffName;
        this.department = department;
        this.shift = shift;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }
}
