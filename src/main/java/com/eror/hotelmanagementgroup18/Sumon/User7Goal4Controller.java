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

public class User7Goal4Controller {

    @FXML private TextField guestIdField;
    @FXML private TableView<VIPGuest> vipTable;
    @FXML private TableColumn<VIPGuest, String> colName, colPoints, colTier, colHistory;


    private ObservableList<VIPGuest> vipList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colPoints.setCellValueFactory(new PropertyValueFactory<>("points"));
        colTier.setCellValueFactory(new PropertyValueFactory<>("tier"));
        colHistory.setCellValueFactory(new PropertyValueFactory<>("history"));


        vipList.add(new VIPGuest("Arpita Saha", "8500", "Diamond Elite", "24 Visits"));
        vipList.add(new VIPGuest("Sumon Ahmed", "4200", "Platinum Plus", "10 Visits"));


        vipTable.setItems(vipList);
    }

    @FXML
    void handleVerifyBtn(ActionEvent event) {
        String id = guestIdField.getText().trim();


        if (id.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Entry Error", "Please provide a Guest ID.");
            return;
        }


        if (id.equals("1001")) {
            vipList.add(new VIPGuest("John Doe", "12000", "Diamond Elite", "45 Visits"));
            showAlert(Alert.AlertType.INFORMATION, "Success", "VIP Profile for ID: 1001 loaded.");
            guestIdField.clear();
        }
        else if (id.equals("1002")) {
            vipList.add(new VIPGuest("Jane Smith", "6500", "Gold Member", "18 Visits"));
            showAlert(Alert.AlertType.INFORMATION, "Success", "VIP Profile for ID: 1002 loaded.");
            guestIdField.clear();
        }
        else if (id.equals("1003")) {
            vipList.add(new VIPGuest("Rahim Khan", "9500", "Platinum", "32 Visits"));
            showAlert(Alert.AlertType.INFORMATION, "Success", "VIP Profile for ID: 1003 loaded.");
            guestIdField.clear();
        }
        else {

            showAlert(Alert.AlertType.ERROR, "Not Found", "No VIP profile found for ID: " + id);
        }
    }

    @FXML
    void handleBackBtn(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/eror/hotelmanagementgroup18/Sumon/Admin_deshboard.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            showAlert(Alert.AlertType.ERROR, "Navigation Error", "Could not load Dashboard.");
        }
    }

    private void showAlert(Alert.AlertType type, String title, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.show();
    }
}