package com.eror.hotelmanagementgroup18.urmi;

public class RefundAdjustment {
    private String invoiceId;
    private double refundAmount;
    private String reason;

    public RefundAdjustment(String invoiceId, double refundAmount, String reason) {
        this.invoiceId = invoiceId;
        this.refundAmount = refundAmount;
        this.reason = reason;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public double getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(double refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "RefundAdjustment{" +
                "invoiceId='" + invoiceId + '\'' +
                ", refundAmount=" + refundAmount +
                ", reason='" + reason + '\'' +
                '}';
    }
}
