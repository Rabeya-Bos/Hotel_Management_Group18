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

public class User7Goal4Controller {

    @FXML private Button backBtn;
    @FXML private TextField guestIdField;
    @FXML private TableView<?> vipTable;

    /**
     * Verifies the Guest ID and loads the profile.
     * Validation ensures the field is not empty and has a valid format.
     */
    @FXML
    private void handleVerifyProfile(ActionEvent event) {
        String guestId = guestIdField.getText().trim();

        // 1. Check if ID field is empty
        if (guestId.isEmpty()) {
            showAlert("Validation Error", "Please enter a valid Guest ID.");
            return;
        }

        // 2. Check for alphanumeric format
        if (!guestId.matches("^[a-zA-Z0-9]+$")) {
            showAlert("Format Error", "Guest ID should only contain letters and numbers.");
            return;
        }

        // Simulation logic
        System.out.println("Processing verification for Guest ID: " + guestId);

        // Mock result
        if (guestId.startsWith("VIP")) {
            showAlert("Success", "VIP Guest Profile found for " + guestId);
        } else {
            showAlert("Search Info", "No VIP profile found for the entered ID.");
        }
    }

    /**
     * Navigation back to Admin Dashboard
     */
    @FXML
    private void handleBackBtn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/eror/hotelmanagementgroup18/Sumon/Admin_deshboard.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}