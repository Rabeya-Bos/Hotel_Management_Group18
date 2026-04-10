package com.eror.hotelmanagementgroup18.Sumon;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;

public class User7Goal2Controller {

    @FXML private TextField staffNameField, staffIdField, basePayField, overtimeField, bonusField;
    @FXML private ComboBox<String> monthCombo;
    @FXML private TableView<PayrollData> payrollTable;
    @FXML private TableColumn<PayrollData, String> colStaffId, colName, colBasePay, colOvertime, colTotal;

    private ObservableList<PayrollData> payrollList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        monthCombo.getItems().addAll("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");

        colStaffId.setCellValueFactory(new PropertyValueFactory<>("staffId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colBasePay.setCellValueFactory(new PropertyValueFactory<>("basePay"));
        colOvertime.setCellValueFactory(new PropertyValueFactory<>("overtime"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));

        payrollTable.setItems(payrollList);
    }

    @FXML
    void handleProcessBtn(ActionEvent event) {
        String id = staffIdField.getText().trim();
        String name = staffNameField.getText().trim();

        if (id.isEmpty() || name.isEmpty() || monthCombo.getValue() == null || basePayField.getText().isEmpty()) {
            showAlert("Error", "Please fill essential fields!");
            return;
        }

        for (PayrollData p : payrollList) {
            if (p.getStaffId().equals(id)) {
                showAlert("Error", "Staff ID " + id + " already processed!");
                return;
            }
        }

        try {
            double base = Double.parseDouble(basePayField.getText());
            double overtime = overtimeField.getText().isEmpty() ? 0 : Double.parseDouble(overtimeField.getText());
            double bonus = bonusField.getText().isEmpty() ? 0 : Double.parseDouble(bonusField.getText());
            double total = base + overtime + bonus;

            payrollList.add(new PayrollData(id, name, String.valueOf(base), String.valueOf(overtime), String.valueOf(total)));
            showAlert("Success", "Payroll added for " + name);
        } catch (NumberFormatException e) {
            showAlert("Error", "Numeric fields must contain numbers!");
        }
    }

    @FXML
    void handleBackBtn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/eror/hotelmanagementgroup18/Sumon/Admin_deshboard.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.show();
    }
}