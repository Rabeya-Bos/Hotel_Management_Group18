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

public class User7Goal3Controller {

    @FXML private TextField roomIdField, currentRateField, multiplierField, newRateField;
    @FXML private ComboBox<String> seasonCombo;
    @FXML private TableView<PricingData> pricingTable;
    @FXML private TableColumn<PricingData, String> colRoomId, colCurrentRate, colMultiplier, colNewRate;

    private ObservableList<PricingData> pricingList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        seasonCombo.getItems().addAll("Holiday Season", "Summer Peak", "Weekend Special", "Conference Event");

        colRoomId.setCellValueFactory(new PropertyValueFactory<>("roomId"));
        colCurrentRate.setCellValueFactory(new PropertyValueFactory<>("currentRate"));
        colMultiplier.setCellValueFactory(new PropertyValueFactory<>("multiplier"));
        colNewRate.setCellValueFactory(new PropertyValueFactory<>("newRate"));

        pricingTable.setItems(pricingList);
    }

    @FXML
    void handleAddBtn(ActionEvent event) {
        String id = roomIdField.getText().trim();
        String current = currentRateField.getText().trim();
        String mult = multiplierField.getText().trim();

        if (id.isEmpty() || current.isEmpty() || mult.isEmpty() || seasonCombo.getValue() == null) {
            showAlert("Error", "Please fill all fields!");
            return;
        }


        for (PricingData p : pricingList) {
            if (p.getRoomId().equals(id)) {
                showAlert("Duplicate", "Pricing for Room " + id + " is already set!");
                return;
            }
        }

        try {
            double cRate = Double.parseDouble(current);
            double mValue = Double.parseDouble(mult);
            double nRate = cRate * mValue;
            newRateField.setText(String.format("%.2f", nRate));

            pricingList.add(new PricingData(id, current, mult, String.valueOf(nRate)));
            showAlert("Success", "Pricing Updated for Room " + id);

            roomIdField.clear(); currentRateField.clear(); multiplierField.clear();
        } catch (NumberFormatException e) {
            showAlert("Error", "Please enter valid numbers!");
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
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.show();
    }
}