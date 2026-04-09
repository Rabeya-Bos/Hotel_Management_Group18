package com.eror.hotelmanagementgroup18.Rabeya;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.util.List;

public class guest8 {

    // --- FXML Controls ---
    @FXML private DatePicker arrivalDatePicker;
    @FXML private TextField flightField;
    @FXML private TextField signageField;
    @FXML private ComboBox<Integer> passengerCombo;
    @FXML private ComboBox<String> timeCombo;
    @FXML private ComboBox<Vehicle> vehicleCombo;
    @FXML private CheckBox meetGreetChk;
    @FXML private Label msgLabel;

    @FXML private TableView<Vehicle> vehiclesTable;
    @FXML private TableColumn<Vehicle, String> vehicleModelCol;
    @FXML private TableColumn<Vehicle, Integer> vehicleCapacityCol;
    @FXML private TableColumn<Vehicle, Double> vehiclePriceCol;
    @FXML private TableColumn<Vehicle, String> vehicleStatusCol;

    // --- Vehicle class ---
    public static class Vehicle implements Serializable {
        private String model;
        private int capacity;
        private double price;
        private String status;

        public Vehicle(String model, int capacity, double price, String status) {
            this.model = model;
            this.capacity = capacity;
            this.price = price;
            this.status = status;
        }

        public String getModel() { return model; }
        public int getCapacity() { return capacity; }
        public double getPrice() { return price; }
        public String getStatus() { return status; }

        @Override
        public String toString() { return model + " ($" + price + ")"; }
    }

    // --- Booking class ---
    public static class VehicleBooking implements Serializable {
        LocalDate date;
        String flight;
        String signage;
        Vehicle vehicle;
        int passengers;
        String time;
        boolean meetGreet;

        public VehicleBooking(LocalDate date, String flight, String signage,
                              Vehicle vehicle, int passengers, String time, boolean meetGreet) {
            this.date = date;
            this.flight = flight;
            this.signage = signage;
            this.vehicle = vehicle;
            this.passengers = passengers;
            this.time = time;
            this.meetGreet = meetGreet;
        }
    }

    // --- Initialize UI ---
    @FXML
    public void initialize() {
        // ComboBoxes
        passengerCombo.getItems().addAll(1,2,3,4,5,6,7,8);
        timeCombo.getItems().addAll("Morning", "Afternoon", "Evening");

        // Table columns
        vehicleModelCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getModel()));
        vehicleCapacityCol.setCellValueFactory(data -> new javafx.beans.property.SimpleIntegerProperty(data.getValue().getCapacity()).asObject());
        vehiclePriceCol.setCellValueFactory(data -> new javafx.beans.property.SimpleDoubleProperty(data.getValue().getPrice()).asObject());
        vehicleStatusCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getStatus()));

        // Sample vehicles
        List<Vehicle> vehicles = List.of(
                new Vehicle("Sedan", 3, 50, "Available"),
                new Vehicle("SUV", 5, 80, "Available"),
                new Vehicle("Minibus", 12, 150, "Available")
        );

        vehiclesTable.getItems().addAll(vehicles);
        vehicleCombo.getItems().addAll(vehicles);
    }

    // --- Check availability ---
    @FXML
    void checkBtn(ActionEvent event) {
        if (arrivalDatePicker.getValue() == null ||
                flightField.getText().isEmpty() ||
                signageField.getText().isEmpty() ||
                passengerCombo.getValue() == null ||
                timeCombo.getValue() == null ||
                vehicleCombo.getValue() == null) {

            msgLabel.setText("Please fill all fields to check availability!");
            return;
        }

        msgLabel.setText("Vehicle available ✅");
    }

    // --- Confirm booking ---
    @FXML
    void confirmBtn(ActionEvent event) {
        if (arrivalDatePicker.getValue() == null ||
                flightField.getText().isEmpty() ||
                signageField.getText().isEmpty() ||
                passengerCombo.getValue() == null ||
                timeCombo.getValue() == null ||
                vehicleCombo.getValue() == null) {

            msgLabel.setText("Please fill all fields before confirming!");
            return;
        }

        VehicleBooking booking = new VehicleBooking(
                arrivalDatePicker.getValue(),
                flightField.getText(),
                signageField.getText(),
                vehicleCombo.getValue(),
                passengerCombo.getValue(),
                timeCombo.getValue(),
                meetGreetChk.isSelected()
        );

        // Save to binary file
        try {
            File file = new File("vehicleBookings.bin");
            ObjectOutputStream oos;
            if (file.exists()) {
                oos = new AppendableObjectOutputStream(new FileOutputStream(file,true));
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(file));
            }
            oos.writeObject(booking);
            oos.close();
            msgLabel.setText("Booking confirmed ✅");
        } catch (Exception e) {
            msgLabel.setText("Error saving booking!");
            e.printStackTrace();
        }
    }

    // --- Scene switch back to dashboard ---
    @FXML
    void homeBtn(ActionEvent actionEvent) throws IOException {
        Scene scene = ((Button) actionEvent.getSource()).getScene();
        Stage stage = (Stage) scene.getWindow();

        FXMLLoader scene2FxmlLoader = new FXMLLoader(guestDashboard.class.getResource("/com/eror/hotelmanagementgroup18/Rabeya/guestDashboard.fxml"));
        Scene scene2 = new Scene(scene2FxmlLoader.load());
        stage.setScene(scene2);
    }

    // --- Custom ObjectOutputStream to append objects ---
    static class AppendableObjectOutputStream extends ObjectOutputStream {
        public AppendableObjectOutputStream(OutputStream out) throws IOException { super(out); }
        @Override
        protected void writeStreamHeader() throws IOException { reset(); }
    }
}