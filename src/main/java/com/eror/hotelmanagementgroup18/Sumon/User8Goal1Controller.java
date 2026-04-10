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

public class User8Goal1Controller {

    @FXML private TextField staffIdField;
    @FXML private ComboBox<String> levelCombo;
    @FXML private TableView<?> cardTable;
    @FXML private Button backBtn;

    @FXML
    public void initialize() {
        // Populating access levels
        levelCombo.getItems().addAll("Level 1: General", "Level 2: Staff Area", "Level 3: Management", "Level 4: Full Access");
    }


    @FXML
    private void handleUpdateCard(ActionEvent event) {
        String staffId = staffIdField.getText().trim();
        String accessLevel = levelCombo.getValue();

        // 1. Validation: Check for empty fields
        if (staffId.isEmpty() || accessLevel == null) {
            showAlert("Validation Error", "Please enter a Staff ID and select an Access Level.");
            return;
        }

        if (!staffId.matches("^[a-zA-Z0-9]+$")) {
            showAlert("Input Error", "Staff ID must contain only letters and numbers.");
            return;
        }

        System.out.println("Access updated for Staff: " + staffId + " to " + accessLevel);
        showAlert("Update Successful", "The access card for Staff ID " + staffId + " has been updated to " + accessLevel + ".");

        clearFields();
    }


    @FXML
    private void handleBackBtn(ActionEvent event) throws IOException {
        // Change this path if your Security Dashboard FXML has a different name
        Parent root = FXMLLoader.load(getClass().getResource("/com/eror/hotelmanagementgroup18.Sumon/Security_dashboard.fxml"));
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

    private void clearFields() {
        staffIdField.clear();
        levelCombo.getSelectionModel().clearSelection();
    }
}