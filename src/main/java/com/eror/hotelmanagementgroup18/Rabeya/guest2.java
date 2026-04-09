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

public class guest2 {

    // --- FXML Controls ---
    @FXML private TextField additionalDetailsField;
    @FXML private Label availabilityStatus;
    @FXML private Label confirmationMsg;
    @FXML private DatePicker serviceDate;
    @FXML private ComboBox<String> serviceTypeCombo;
    @FXML private ComboBox<String> serviceTimeCombo;
    @FXML private TextArea specialInstructionsArea;

    @FXML private TableView<Service> serviceTable;
    @FXML private TableColumn<Service, Integer> serviceIdCol;
    @FXML private TableColumn<Service, String> serviceNameCol;
    @FXML private TableColumn<Service, Double> servicePriceCol;
    @FXML private TableColumn<Service, String> serviceAvailabilityCol;

    // --- Service class ---
    public static class Service implements Serializable {
        private int id;
        private String name;
        private double price;
        private String availability;

        public Service(int id, String name, double price, String availability) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.availability = availability;
        }

        public int getId() { return id; }
        public String getName() { return name; }
        public double getPrice() { return price; }
        public String getAvailability() { return availability; }

        @Override
        public String toString() { return name + " ($" + price + ")"; }
    }

    // --- ServiceRequest class ---
    public static class ServiceRequest implements Serializable {
        String serviceName;
        String serviceType;
        String serviceTime;
        LocalDate date;
        String additionalDetails;
        String specialInstructions;

        public ServiceRequest(String serviceName, String serviceType, String serviceTime,
                              LocalDate date, String additionalDetails, String specialInstructions) {
            this.serviceName = serviceName;
            this.serviceType = serviceType;
            this.serviceTime = serviceTime;
            this.date = date;
            this.additionalDetails = additionalDetails;
            this.specialInstructions = specialInstructions;
        }
    }

    // --- Initialize UI ---
    @FXML
    public void initialize() {
        // ComboBox values
        serviceTypeCombo.getItems().addAll("Spa", "Massage", "Excursion", "Dining");
        serviceTimeCombo.getItems().addAll("Morning", "Afternoon", "Evening");

        // Table columns
        serviceIdCol.setCellValueFactory(data -> new javafx.beans.property.SimpleIntegerProperty(data.getValue().getId()).asObject());
        serviceNameCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getName()));
        servicePriceCol.setCellValueFactory(data -> new javafx.beans.property.SimpleDoubleProperty(data.getValue().getPrice()).asObject());
        serviceAvailabilityCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getAvailability()));

        // Sample services
        List<Service> services = List.of(
                new Service(1, "Full Body Massage", 120, "Available"),
                new Service(2, "Private Spa Session", 200, "Available"),
                new Service(3, "Dinner by the Beach", 80, "Available"),
                new Service(4, "City Tour Excursion", 150, "Available")
        );

        serviceTable.getItems().addAll(services);
    }

    // --- Check availability ---
    @FXML
    void checkAvailabilityBtn(ActionEvent event) {
        if (serviceDate.getValue() == null) {
            availabilityStatus.setText("Select a service date!");
            return;
        }
        if (serviceTypeCombo.getValue() == null) {
            availabilityStatus.setText("Select a service type!");
            return;
        }
        if (serviceTimeCombo.getValue() == null) {
            availabilityStatus.setText("Select a service time!");
            return;
        }
        availabilityStatus.setText("Service available ✅");
    }

    // --- Confirm request ---
    @FXML
    void confirmRequestBtn(ActionEvent event) {
        if (serviceDate.getValue() == null ||
                serviceTypeCombo.getValue() == null ||
                serviceTimeCombo.getValue() == null ||
                additionalDetailsField.getText().isEmpty()) {

            confirmationMsg.setText("Please fill all required fields!");
            return;
        }

        Service selectedService = serviceTable.getSelectionModel().getSelectedItem();
        if (selectedService == null) {
            confirmationMsg.setText("Select a service from the table!");
            return;
        }

        ServiceRequest request = new ServiceRequest(
                selectedService.getName(),
                serviceTypeCombo.getValue(),
                serviceTimeCombo.getValue(),
                serviceDate.getValue(),
                additionalDetailsField.getText(),
                specialInstructionsArea.getText()
        );

        // Save to binary file
        try {
            File file = new File("serviceRequests.bin");
            ObjectOutputStream oos;
            if (file.exists()) {
                oos = new AppendableObjectOutputStream(new FileOutputStream(file,true));
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(file));
            }
            oos.writeObject(request);
            oos.close();
            confirmationMsg.setText("Service request confirmed!");
        } catch (Exception e) {
            confirmationMsg.setText("Error saving service request!");
            e.printStackTrace();
        }
    }

    // --- Scene switch back to dashboard ---
    @FXML
    void returnHomeBtn(ActionEvent actionEvent) throws IOException {
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