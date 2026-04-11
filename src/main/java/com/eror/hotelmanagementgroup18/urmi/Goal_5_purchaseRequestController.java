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
        itemComboBox.getItems().addAll("Rice", "Vegetables", "Meat", "Fish", "Spices", "Oil","Cleaning Supplies", "Detergent", "Soap", "Towels","Beverages", "Snacks", "Dairy Products", "Bread","Kitchen Equipment", "Linens", "Amenities", "Stationery");

        vendorComboBox.getItems().addAll("ABC Supplies Co.","Global Foods Ltd.","Hotel Essentials Inc.","Fresh Produce Distributors","Quality Meats & More","Clean & Shine Solutions","Beverage World","Premium Linens Corp.");


        requestIdCol.setCellValueFactory(new PropertyValueFactory<>("requestId"));
        itemNameCol.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        vendorCol.setCellValueFactory(new PropertyValueFactory<>("vendor"));
        requestDateCol.setCellValueFactory(new PropertyValueFactory<>("requestDate"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        reasonCol.setCellValueFactory(new PropertyValueFactory<>("reason"));


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

    @javafx.fxml.FXML
    public void backButtonOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Goal_4_inventoryReport.fxml"));
        Scene scene = new Scene((Parent) fxmlLoader.load());
        Button b = (Button) actionEvent.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void nextButtonOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Goal_6_supplierDelivery.fxml"));
        Scene scene = new Scene((Parent) fxmlLoader.load());
        Button b = (Button) actionEvent.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        stage.setScene(scene);
    }
}