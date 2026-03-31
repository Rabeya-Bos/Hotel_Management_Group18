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

public class User8Goal2Controller {

    @FXML private TextField typeField;
    @FXML private TextArea descArea;
    @FXML private TableView<Incident> incidentTable;
    @FXML private TableColumn<Incident, String> colId, colType, colDesc;

    private ObservableList<Incident> incidentList = FXCollections.observableArrayList();
    private int reportCounter = 101;

    @FXML
    public void initialize() {

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colDesc.setCellValueFactory(new PropertyValueFactory<>("description"));

        incidentTable.setItems(incidentList);
    }

    @FXML
    void handleSubmitBtn(ActionEvent event) {
        String type = typeField.getText().trim();
        String desc = descArea.getText().trim();

        if (type.isEmpty() || desc.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Field Error", "Incident type and description are required!");
            return;
        }


        String reportID = "INC-" + (reportCounter++);
        incidentList.add(new Incident(reportID, type, desc));

        showAlert(Alert.AlertType.INFORMATION, "Reported", "Incident " + reportID + " has been logged successfully.");


        typeField.clear();
        descArea.clear();
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