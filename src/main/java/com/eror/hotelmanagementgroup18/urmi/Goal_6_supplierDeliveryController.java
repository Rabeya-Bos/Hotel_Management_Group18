package com.eror.hotelmanagementgroup18.urmi;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class Goal_6_supplierDeliveryController
{
    @javafx.fxml.FXML
    private TextField deliveryIdTF;
    @javafx.fxml.FXML
    private TableColumn<SupplierDelivery,Integer> deliveryIdCol;
    @javafx.fxml.FXML
    private TableColumn<SupplierDelivery,String> supplierCol;
    @javafx.fxml.FXML
    private TextField quantityOrdredTF;
    @javafx.fxml.FXML
    private TableView<SupplierDelivery> deliveryTV;
    @javafx.fxml.FXML
    private Label itemLabel;
    @javafx.fxml.FXML
    private TextField quantityReceivedTF;
    @javafx.fxml.FXML
    private Label statusLabel;
    @javafx.fxml.FXML
    private TableColumn<SupplierDelivery,String> itemCol;
    @javafx.fxml.FXML
    private TableColumn<SupplierDelivery,String> orderedCol;
    @javafx.fxml.FXML
    private TableColumn<SupplierDelivery,String> statusCol;
    @javafx.fxml.FXML
    private TableColumn<SupplierDelivery,String> receivedCol;
    @javafx.fxml.FXML
    private TextField itemTF;
    @javafx.fxml.FXML
    private TextField searchPOTF;
    @javafx.fxml.FXML
    private ComboBox<String> supplierComboBox;
    @javafx.fxml.FXML
    private Label quantityOrderedLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void searchButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void updateInventoryButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void verifyDeliveryButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void refreshButtonOA(ActionEvent actionEvent) {
    }
}