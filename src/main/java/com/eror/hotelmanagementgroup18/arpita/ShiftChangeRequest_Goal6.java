package com.eror.hotelmanagementgroup18.arpita;

import java.io.Serializable;
import java.time.LocalDate;

public class ShiftChangeRequest_Goal6 implements Serializable {

    private String staffName;
    private String currentShift;
    private String requestedShift;
    private LocalDate fromDate;
    private LocalDate toDate;
    private String reason;
    private boolean status;
    private boolean additionalOption;

    public ShiftChangeRequest_Goal6(String staffName, String currentShift, String requestedShift, LocalDate fromDate, LocalDate toDate, String reason, boolean status, boolean additionalOption) {
        this.staffName = staffName;
        this.currentShift = currentShift;
        this.requestedShift = requestedShift;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.reason = reason;
        this.status = status;
        this.additionalOption = additionalOption;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getCurrentShift() {
        return currentShift;
    }

    public void setCurrentShift(String currentShift) {
        this.currentShift = currentShift;
    }

    public String getRequestedShift() {
        return requestedShift;
    }

    public void setRequestedShift(String requestedShift) {
        this.requestedShift = requestedShift;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isAdditionalOption() {
        return additionalOption;
    }

    public void setAdditionalOption(boolean additionalOption) {
        this.additionalOption = additionalOption;
    }

    @Override
    public String toString() {
        return "ShiftChangeRequest_Goal6{" +
                "staffName='" + staffName + '\'' +
                ", currentShift='" + currentShift + '\'' +
                ", requestedShift='" + requestedShift + '\'' +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", reason='" + reason + '\'' +
                ", status=" + status +
                ", additionalOption=" + additionalOption +
                '}';
    }
}
