package com.eror.hotelmanagementgroup18.urmi;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.time.LocalDate;

public class Goal_5_purchaseRequestController
{
    @javafx.fxml.FXML
    private ComboBox<String> vendorComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> filterStatusComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> itemComboBox;
    @javafx.fxml.FXML
    private TableColumn<PurchaseRequest,Integer> requestIdCol;
    @javafx.fxml.FXML
    private TableColumn<PurchaseRequest, LocalDate> requestDateCol;
    @javafx.fxml.FXML
    private TableView<PurchaseRequest> requestTV;
    @javafx.fxml.FXML
    private TableColumn<PurchaseRequest,String> itemNameCol;
    @javafx.fxml.FXML
    private Label statusLabel;
    @javafx.fxml.FXML
    private TableColumn<PurchaseRequest,String> statusCol;
    @javafx.fxml.FXML
    private TextArea reasonRequestTA;
    @javafx.fxml.FXML
    private TableColumn<PurchaseRequest,Integer> quantityCol;
    @javafx.fxml.FXML
    private TextField quantityTF;
    @javafx.fxml.FXML
    private TableColumn<PurchaseRequest,String> vendorCol;
    @javafx.fxml.FXML
    private TableColumn<PurchaseRequest,String> reasonCol;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void sendRequestButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void clearFormButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void resetFilterButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void filterButtonOA(ActionEvent actionEvent) {
    }
}