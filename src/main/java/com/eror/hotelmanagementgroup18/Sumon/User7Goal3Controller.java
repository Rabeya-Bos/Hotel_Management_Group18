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

public class User7Goal3Controller {

    @FXML private TextField roomIdField;
    @FXML private TextField currentRateField;
    @FXML private TextField multiplierField;
    @FXML private TextField newRateField;
    @FXML private ComboBox<String> seasonCombo;

    @FXML private Button backBtn;
    @FXML private Button addBtn;

    @FXML private TableView<?> pricingTable;
    @FXML private TableColumn<?, ?> colRoomId;
    @FXML private TableColumn<?, ?> colCurrentRate;
    @FXML private TableColumn<?, ?> colMultiplier;
    @FXML private TableColumn<?, ?> colNewRate;

    @FXML
    public void initialize() {
        // Populate the season options in ComboBox
        seasonCombo.getItems().addAll("Peak Season", "Off-Season", "Holiday Event", "Weekend Special");

        // Ensure newRateField is not manually editable since it's calculated
        newRateField.setEditable(false);
    }

    /**
     * Handles the 'Add' action with full validation and rate calculation.
     */
    @FXML
    private void handleAddBtn(ActionEvent event) {
        // 1. Validation: Check if any required field is empty
        if (roomIdField.getText().isEmpty() || currentRateField.getText().isEmpty() ||
                multiplierField.getText().isEmpty() || seasonCombo.getValue() == null) {

            showAlert("Input Error", "All fields are required. Please check your inputs.");
            return;
        }

        // 2. Validation: Numeric checks and calculation logic
        try {
            double currentRate = Double.parseDouble(currentRateField.getText());
            double multiplier = Double.parseDouble(multiplierField.getText());

            if (currentRate <= 0 || multiplier <= 0) {
                showAlert("Value Error", "Rate and Multiplier must be greater than zero.");
                return;
            }

            // Perform Calculation: New Rate = Current Rate * Multiplier
            double calculatedRate = currentRate * multiplier;

            // Display the calculated result formatted to 2 decimal places
            newRateField.setText(String.format("%.2f", calculatedRate));

            // Success confirmation
            System.out.println("Pricing calculated for Room: " + roomIdField.getText());
            showAlert("Success", "Seasonal pricing has been calculated and added successfully.");

            // clearFields(); // Uncomment if you want fields to clear after success

        } catch (NumberFormatException e) {
            showAlert("Format Error", "Please enter valid numeric values for Current Rate and Multiplier.");
        }
    }

    /**
     * Navigates back to the Admin Dashboard.
     */
    @FXML
    private void handleBackBtn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/eror/hotelmanagementgroup18/Sumon/Admin_deshboard.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    /**
     * Helper method to show alerts without Bengali text.
     */
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     * Resets all input fields.
     */
    private void clearFields() {
        roomIdField.clear();
        currentRateField.clear();
        multiplierField.clear();
        newRateField.clear();
        seasonCombo.getSelectionModel().clearSelection();
    }
}