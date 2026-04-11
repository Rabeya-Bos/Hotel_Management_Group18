package com.eror.hotelmanagementgroup18.urmi;

import com.eror.hotelmanagementgroup18.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class Goal_8_inventorySyncConroller
{
    @javafx.fxml.FXML
    private TableColumn<InventorySync,String> departmentCol;
    @javafx.fxml.FXML
    private TableColumn<InventorySync,String> statusCol;
    @javafx.fxml.FXML
    private TableView<InventorySync> syncLogTV;
    @javafx.fxml.FXML
    private TextField connectedDepartmentsTF;
    @javafx.fxml.FXML
    private Label syncStatusLabel;
    @javafx.fxml.FXML
    private Label messageLabel;
    @javafx.fxml.FXML
    private TableColumn<InventorySync, LocalDate> timestampCol;

    @javafx.fxml.FXML
    public void initialize() {
        timestampCol.setCellValueFactory(new PropertyValueFactory<>("timestamp"));
        departmentCol.setCellValueFactory(new PropertyValueFactory<>("department"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    @javafx.fxml.FXML
    public void syncInventoryButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void refreshButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void viewDetailsButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backButtonOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Goal_7_damagedItems.fxml"));
        Scene scene = new Scene((Parent) fxmlLoader.load());
        Button b = (Button) actionEvent.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        stage.setScene(scene);
    }
}