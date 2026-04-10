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

public class User8Goal2Controller {

    @FXML private TextField typeField;
    @FXML private TextArea descArea;
    @FXML private TableView<?> incidentTable;
    @FXML private Button backBtn;


    @FXML
    private void handleSubmitReport(ActionEvent event) {
        String incidentType = typeField.getText().trim();
        String description = descArea.getText().trim();

        // 1. Validation: Check if fields are empty
        if (incidentType.isEmpty() || description.isEmpty()) {
            showAlert("Missing Information", "Please provide both the incident type and a detailed description.");
            return;
        }

        // 2. Validation: Length check (ensure description is detailed enough)
        if (description.length() < 10) {
            showAlert("Detail Required", "Please provide more details in the description (at least 10 characters).");
            return;
        }

        // Logic for successful submission (e.g., saving to database or list)
        System.out.println("Incident Reported: " + incidentType);
        showAlert("Report Submitted", "Incident report has been successfully recorded.");

        clearFields();
    }


    @FXML
    private void handleBackBtn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/eror/hotelmanagementgroup18/Sumon/Security_dashboard.fxml"));
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
        typeField.clear();
        descArea.clear();
    }
}