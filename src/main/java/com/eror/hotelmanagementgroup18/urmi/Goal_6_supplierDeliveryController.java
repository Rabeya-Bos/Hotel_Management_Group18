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
        supplierComboBox.getItems().addAll("ABC Supplies Co.","Global Foods Ltd.","Hotel Essentials Inc.","Fresh Produce Distributors","Quality Meats & More","Clean & Shine Solutions","Beverage World","Premium Linens Corp.","Tech Equipment Suppliers","Furniture Masters");

        deliveryIdCol.setCellValueFactory(new PropertyValueFactory<>("deliveryId"));
        supplierCol.setCellValueFactory(new PropertyValueFactory<>("supplier"));
        itemCol.setCellValueFactory(new PropertyValueFactory<>("item"));
        orderedCol.setCellValueFactory(new PropertyValueFactory<>("quantityOrdered"));
        receivedCol.setCellValueFactory(new PropertyValueFactory<>("quantityReceived"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
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

    @javafx.fxml.FXML
    public void backButtonOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Goal_5_purchaseRequest.fxml"));
        Scene scene = new Scene((Parent) fxmlLoader.load());
        Button b = (Button) actionEvent.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void nextButtonOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Goal_7_damagedItems.fxml"));
        Scene scene = new Scene((Parent) fxmlLoader.load());
        Button b = (Button) actionEvent.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        stage.setScene(scene);
    }
}