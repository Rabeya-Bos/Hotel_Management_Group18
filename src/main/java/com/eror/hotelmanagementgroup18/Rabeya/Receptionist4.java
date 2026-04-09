package com.eror.hotelmanagementgroup18.Rabeya;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Receptionist4 {

    // --- Tables ---
    @FXML private TableView<UpgradeRequest> pendingRequestsTable;
    @FXML private TableColumn<UpgradeRequest, Integer> requestIdCol;
    @FXML private TableColumn<UpgradeRequest, String> guestNameCol;
    @FXML private TableColumn<UpgradeRequest, String> currentRoomCol;
    @FXML private TableColumn<UpgradeRequest, String> requestedSuiteCol;

    @FXML private TableView<Suite> availableSuitesTable;
    @FXML private TableColumn<Suite, Integer> suiteNoCol;
    @FXML private TableColumn<Suite, String> suiteTypeCol;
    @FXML private TableColumn<Suite, String> suiteViewCol;
    @FXML private TableColumn<Suite, Double> suitePriceCol;

    // --- Controls ---
    @FXML private ComboBox<Suite> suiteSelectCombo;
    @FXML private Label eligibilityLabel;
    @FXML private Label chargesLabel;
    @FXML private Label confirmationMsg;

    private UpgradeRequest selectedRequest;

    // --- Suite class ---
    public static class Suite implements Serializable {
        int suiteNo;
        String type;
        String view;
        double price;

        public Suite(int suiteNo, String type, String view, double price) {
            this.suiteNo = suiteNo;
            this.type = type;
            this.view = view;
            this.price = price;
        }

        public int getSuiteNo() { return suiteNo; }
        public String getType() { return type; }
        public String getView() { return view; }
        public double getPrice() { return price; }

        @Override
        public String toString() {
            return type + " (" + suiteNo + ")";
        }
    }

    // --- Upgrade Request class ---
    public static class UpgradeRequest implements Serializable {
        int id;
        String guestName;
        String currentRoom;
        String requestedSuite;

        public UpgradeRequest(int id, String guestName, String currentRoom, String requestedSuite) {
            this.id = id;
            this.guestName = guestName;
            this.currentRoom = currentRoom;
            this.requestedSuite = requestedSuite;
        }

        public int getId() { return id; }
        public String getGuestName() { return guestName; }
        public String getCurrentRoom() { return currentRoom; }
        public String getRequestedSuite() { return requestedSuite; }
    }

    // --- Initialize ---
    @FXML
    public void initialize() {

        // Setup columns (requests)
        requestIdCol.setCellValueFactory(d -> new javafx.beans.property.SimpleIntegerProperty(d.getValue().getId()).asObject());
        guestNameCol.setCellValueFactory(d -> new javafx.beans.property.SimpleStringProperty(d.getValue().getGuestName()));
        currentRoomCol.setCellValueFactory(d -> new javafx.beans.property.SimpleStringProperty(d.getValue().getCurrentRoom()));
        requestedSuiteCol.setCellValueFactory(d -> new javafx.beans.property.SimpleStringProperty(d.getValue().getRequestedSuite()));

        // Setup columns (suites)
        suiteNoCol.setCellValueFactory(d -> new javafx.beans.property.SimpleIntegerProperty(d.getValue().getSuiteNo()).asObject());
        suiteTypeCol.setCellValueFactory(d -> new javafx.beans.property.SimpleStringProperty(d.getValue().getType()));
        suiteViewCol.setCellValueFactory(d -> new javafx.beans.property.SimpleStringProperty(d.getValue().getView()));
        suitePriceCol.setCellValueFactory(d -> new javafx.beans.property.SimpleDoubleProperty(d.getValue().getPrice()).asObject());

        // Sample data
        List<UpgradeRequest> requests = List.of(
                new UpgradeRequest(1, "John Doe", "101", "Suite"),
                new UpgradeRequest(2, "Alice Smith", "102", "Deluxe Suite")
        );

        List<Suite> suites = List.of(
                new Suite(301, "Suite", "Sea View", 200),
                new Suite(302, "Deluxe Suite", "City View", 300)
        );

        pendingRequestsTable.getItems().addAll(requests);
        availableSuitesTable.getItems().addAll(suites);
        suiteSelectCombo.getItems().addAll(suites);
    }

    // --- Select request ---
    @FXML
    void selectRequestBtn(ActionEvent event) {
        selectedRequest = pendingRequestsTable.getSelectionModel().getSelectedItem();

        if (selectedRequest == null) {
            confirmationMsg.setText("Select a request first!");
            return;
        }

        eligibilityLabel.setText("Eligible ✅");
        confirmationMsg.setText("Request selected");
    }

    // --- Confirm upgrade ---
    @FXML
    void confirmUpgradeBtn(ActionEvent event) {

        if (selectedRequest == null || suiteSelectCombo.getValue() == null) {
            confirmationMsg.setText("Select request and suite!");
            return;
        }

        Suite selectedSuite = suiteSelectCombo.getValue();

        // Simple charge calculation
        double charge = selectedSuite.getPrice();
        chargesLabel.setText("Upgrade Charge: $" + charge);

        // Save upgrade
        try {
            File file = new File("upgrades.bin");
            ObjectOutputStream oos;

            if (file.exists()) {
                oos = new AppendableObjectOutputStream(new FileOutputStream(file, true));
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(file));
            }

            oos.writeObject(selectedRequest);
            oos.close();

            confirmationMsg.setText("Upgrade successful ✅");

        } catch (Exception e) {
            confirmationMsg.setText("Error saving upgrade!");
            e.printStackTrace();
        }
    }

    // --- Scene switch ---
    @FXML
    void homeBtn(ActionEvent actionEvent) throws IOException {
        Scene scene = ((Button) actionEvent.getSource()).getScene();
        Stage stage = (Stage) scene.getWindow();

        FXMLLoader loader = new FXMLLoader(guestDashboard.class.getResource("/com/eror/hotelmanagementgroup18/Rabeya/ReceptionistDashboard.fxml"));
        stage.setScene(new Scene(loader.load()));
    }

    // --- Fix append issue ---
    static class AppendableObjectOutputStream extends ObjectOutputStream {
        public AppendableObjectOutputStream(OutputStream out) throws IOException { super(out); }
        @Override protected void writeStreamHeader() throws IOException { reset(); }
    }
}