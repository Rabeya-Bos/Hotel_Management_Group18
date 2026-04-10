package com.eror.hotelmanagementgroup18.urmi;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

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
}