package com.eror.hotelmanagementgroup18.Sumon;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;

public class User7Goal2Controller {

    // FXML IDs
    @FXML private TextField staffNameField, staffIdField, basePayField, overtimeField, bonusField;
    @FXML private ComboBox<String> monthCombo;
    @FXML private TableView<PayrollData> payrollTable;
    @FXML private TableColumn<PayrollData, String> colStaffId, colName;
    @FXML private TableColumn<PayrollData, Double> colBasePay, colOvertime, colTotal;

    @FXML
    public void initialize() {
        monthCombo.getItems().addAll("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");

        colStaffId.setCellValueFactory(new PropertyValueFactory<>("staffId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colBasePay.setCellValueFactory(new PropertyValueFactory<>("basePay"));
        colOvertime.setCellValueFactory(new PropertyValueFactory<>("overtime"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
    }

    @FXML
    private void handleProcessPayroll(ActionEvent event) {

        if (staffNameField.getText().isEmpty() || staffIdField.getText().isEmpty() ||
                basePayField.getText().isEmpty() || monthCombo.getValue() == null) {

            showErrorMessage("Validation Error", "All mandatory fields must be filled!");
            return;
        }

        try {

            String name = staffNameField.getText();
            String id = staffIdField.getText();
            double base = Double.parseDouble(basePayField.getText());
            double overtime = overtimeField.getText().isEmpty() ? 0 : Double.parseDouble(overtimeField.getText());
            double bonus = bonusField.getText().isEmpty() ? 0 : Double.parseDouble(bonusField.getText());


            if (base < 0 || overtime < 0 || bonus < 0) {
                showErrorMessage("Input Error", "Salary values cannot be negative!");
                return;
            }


            double total = base + overtime + bonus;


            PayrollData newData = new PayrollData(id, name, base, overtime, total);
            payrollTable.getItems().add(newData);


            clearForm();

        } catch (NumberFormatException e) {
            showErrorMessage("Format Error", "Please enter valid numbers in Salary/Overtime/Bonus fields.");
        }
    }

    private void showErrorMessage(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private void clearForm() {
        staffNameField.clear();
        staffIdField.clear();
        basePayField.clear();
        overtimeField.clear();
        bonusField.clear();
        monthCombo.getSelectionModel().clearSelection();
    }
}