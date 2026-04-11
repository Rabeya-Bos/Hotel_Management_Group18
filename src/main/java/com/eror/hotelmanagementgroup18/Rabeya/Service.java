package com.eror.hotelmanagementgroup18.Rabeya;

import javafx.beans.property.SimpleStringProperty;

public class Service {

    private SimpleStringProperty serviceId;
    private SimpleStringProperty serviceName;
    private SimpleStringProperty servicePrice;
    private SimpleStringProperty availability;

    public Service(String serviceId, String serviceName, String servicePrice, String availability) {
        this.serviceId = new SimpleStringProperty(serviceId);
        this.serviceName = new SimpleStringProperty(serviceName);
        this.servicePrice = new SimpleStringProperty(servicePrice);
        this.availability = new SimpleStringProperty(availability);
    }

    public SimpleStringProperty serviceIdProperty() {
        return serviceId;
    }

    public SimpleStringProperty serviceNameProperty() {
        return serviceName;
    }

    public SimpleStringProperty servicePriceProperty() {
        return servicePrice;
    }

    public SimpleStringProperty availabilityProperty() {
        return availability;
    }
}