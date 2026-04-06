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

    public ShiftChangeRequest_Goal6(String staffName, String currentShift, String requestedShift,
                                    LocalDate fromDate, LocalDate toDate,
                                    String reason, boolean status, boolean additionalOption) {
        this.staffName = staffName;
        this.currentShift = currentShift;
        this.requestedShift = requestedShift;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.reason = reason;
        this.status = status;
        this.additionalOption = additionalOption;
    }

    public String getStaffName() { return staffName; }
    public String getCurrentShift() { return currentShift; }
    public String getRequestedShift() { return requestedShift; }
    public LocalDate getFromDate() { return fromDate; }
    public LocalDate getToDate() { return toDate; }
    public String getReason() { return reason; }
    public boolean isStatus() { return status; }
    public boolean isAdditionalOption() { return additionalOption; }
}
