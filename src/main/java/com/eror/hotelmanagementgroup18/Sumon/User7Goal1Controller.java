package com.eror.hotelmanagementgroup18.Sumon;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;

public class User7Goal1Controller {

    @FXML private TextField addRoomIdField;
    @FXML private TextField rateField;
    @FXML private ComboBox<String> floorCombo;
    @FXML private ComboBox<String> typeCombo;
    @FXML private Button backBtn;
    @FXML private Button addBtn;

    @FXML
    public void initialize() {
        // Initialize ComboBox options
        floorCombo.getItems().addAll("Floor 1", "Floor 2", "Floor 3", "Floor 4");
        typeCombo.getItems().addAll("Single", "Double", "Suite", "Deluxe");
    }

    @FXML
    private void handleAddBtn(ActionEvent event) {
        String roomId = addRoomIdField.getText();
        String rateStr = rateField.getText();
        String floor = floorCombo.getValue();
        String type = typeCombo.getValue();

        // Validation: Check for empty fields
        if (roomId.isEmpty() || rateStr.isEmpty() || floor == null || type == null) {
            showAlert("Error", "Please fill in all required fields.");
            return;
        }

        // Validation: Check if rate is a valid positive number
        try {
            double rate = Double.parseDouble(rateStr);
            if (rate <= 0) {
                showAlert("Error", "Rate must be a positive value greater than zero.");
                return;
            }
        } catch (NumberFormatException e) {
            showAlert("Error", "Invalid input. Please enter a numeric value for the rate.");
            return;
        }

        // Logic for successful entry
        System.out.println("Room " + roomId + " added successfully.");
        showAlert("Success", "Room details have been saved successfully.");
        clearFields();
    }

    // Navigation back to Admin Dashboard
    @FXML
    private void handleBackBtn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/eror/hotelmanagementgroup18/Sumon/Admin_deshboard.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    // Helper method to display alerts
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Helper method to clear input fields
    private void clearFields() {
        addRoomIdField.clear();
        rateField.clear();
        floorCombo.getSelectionModel().clearSelection();
        typeCombo.getSelectionModel().clearSelection();
    }
}