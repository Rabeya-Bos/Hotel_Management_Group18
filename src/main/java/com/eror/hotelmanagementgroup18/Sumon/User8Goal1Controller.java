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

public class User8Goal1Controller {

    @FXML private TextField staffIdField;
    @FXML private ComboBox<String> levelCombo;
    @FXML private TableView<SecurityCard> cardTable;
    @FXML private TableColumn<SecurityCard, String> colStaffId, colLevel, colStatus;

    private ObservableList<SecurityCard> cardList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        levelCombo.getItems().addAll("Floor 1-5", "Admin Office", "Server Room", "Full Access");


        colStaffId.setCellValueFactory(new PropertyValueFactory<>("staffId"));
        colLevel.setCellValueFactory(new PropertyValueFactory<>("accessLevel"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        cardTable.setItems(cardList);
    }

    @FXML
    void handleUpdateBtn(ActionEvent event) {
        String id = staffIdField.getText().trim();
        String level = levelCombo.getValue();


        if (id.isEmpty() || level == null) {
            showAlert(Alert.AlertType.WARNING, "Error", "Please fill all fields!");
            return;
        }


        for (SecurityCard card : cardList) {
            if (card.getStaffId().equals(id)) {
                showAlert(Alert.AlertType.ERROR, "Duplicate", "Staff ID " + id + " already has an access card!");
                return;
            }
        }


        cardList.add(new SecurityCard(id, level, "Active"));
        showAlert(Alert.AlertType.INFORMATION, "Success", "Access Card Updated for Staff: " + id);

        staffIdField.clear();
        levelCombo.setValue(null);
    }

    @FXML
    void handleBackBtn(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/com/eror/hotelmanagementgroup18/Sumon/Security_dashboard.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    private void showAlert(Alert.AlertType type, String title, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.show();
    }
}