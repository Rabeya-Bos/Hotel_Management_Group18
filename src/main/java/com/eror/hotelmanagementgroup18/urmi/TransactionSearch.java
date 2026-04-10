package com.eror.hotelmanagementgroup18.urmi;

import java.time.LocalDate;

public class TransactionSearch {
    private String transactionId;
    private String invoiceId;
    private String guestName;
    private double amount;
    private String paymentMethod;
    private LocalDate transactionDate;

    public TransactionSearch(String transactionId, String invoiceId, String guestName, double amount, String paymentMethod, LocalDate transactionDate) {
        this.transactionId = transactionId;
        this.invoiceId = invoiceId;
        this.guestName = guestName;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.transactionDate = transactionDate;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public String toString() {
        return "TransactionSearch{" +
                "transactionId='" + transactionId + '\'' +
                ", invoiceId='" + invoiceId + '\'' +
                ", guestName='" + guestName + '\'' +
                ", amount=" + amount +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
