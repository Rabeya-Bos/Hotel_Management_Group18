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

public class User7Goal1Controller {

    @FXML private TextField roomIdField, rateField;
    @FXML private ComboBox<String> typeCombo;
    @FXML private TableView<Room> inventoryTable;
    @FXML private TableColumn<Room, String> colRoomId, colType, colRate, colStatus;


    private ObservableList<Room> roomData = FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        typeCombo.getItems().addAll("Presidential Suite", "Luxury Deluxe", "Executive Room", "Standard Suite");

        colRoomId.setCellValueFactory(new PropertyValueFactory<>("roomId"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colRate.setCellValueFactory(new PropertyValueFactory<>("rate"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        inventoryTable.setItems(roomData);
    }

    @FXML
    void handleAddBtn(ActionEvent event) {
        String id = roomIdField.getText().trim();
        String rate = rateField.getText().trim();
        String type = typeCombo.getValue();


        if (id.isEmpty() || rate.isEmpty() || type == null) {
            showAlert(Alert.AlertType.WARNING, "Validation Error", "Please fill all fields!");
            return;
        }


        for (Room room : roomData) {
            if (room.getRoomId().equals(id)) {
                showAlert(Alert.AlertType.ERROR, "Duplicate Error", "Room No " + id + " already exists!");
                return;
            }
        }

        if (!id.matches("\\d+")) {
            showAlert(Alert.AlertType.ERROR, "Input Error", "Room ID must contain numbers only!");
            return;
        }

        try {
            double price = Double.parseDouble(rate);
            if (price <= 0) {
                showAlert(Alert.AlertType.ERROR, "Input Error", "Price must be greater than zero!");
                return;
            }
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Input Error", "Please enter a valid price (e.g. 500)!");
            return;
        }

        roomData.add(new Room(id, type, rate, "Available"));

        roomIdField.clear();
        rateField.clear();
        typeCombo.setValue(null);

        showAlert(Alert.AlertType.INFORMATION, "Success", "Luxury Room Added Successfully!");
    }

    @FXML
    void handleBackBtn(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/eror/hotelmanagementgroup18/Sumon/Admin_deshboard.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            showAlert(Alert.AlertType.ERROR, "Error", "Could not load Dashboard!");
        }
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}