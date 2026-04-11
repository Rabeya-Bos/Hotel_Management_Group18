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

public class Goal_4_inventoryReportController
{
    @javafx.fxml.FXML
    private ComboBox<String> categoryComboBox;
    @javafx.fxml.FXML
    private ToggleGroup reportTypeGroup;
    @javafx.fxml.FXML
    private TableColumn<InventoryReport, LocalDate> dateCol;
    @javafx.fxml.FXML
    private RadioButton dailyRB;
    @javafx.fxml.FXML
    private TableColumn<InventoryReport,Integer> quantityCol;
    @javafx.fxml.FXML
    private TableColumn<InventoryReport,String> categoryCol;
    @javafx.fxml.FXML
    private RadioButton monthlyRB;
    @javafx.fxml.FXML
    private TableView<InventoryReport> reportTV;

    @javafx.fxml.FXML
    public void initialize() {
        categoryComboBox.getItems().addAll("All Categories","Food & Beverages","Cleaning Supplies","Kitchen Equipment","Linens & Fabrics","Amenities","Stationery","Maintenance Supplies");

        categoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));

    }

    @javafx.fxml.FXML
    public void generateReportButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backButtonOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Goal_3_lowStock.fxml"));
        Scene scene = new Scene((Parent) fxmlLoader.load());
        Button b = (Button) actionEvent.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void nextButtonOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Goal_5_purchaseRequest.fxml"));
        Scene scene = new Scene((Parent) fxmlLoader.load());
        Button b = (Button) actionEvent.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        stage.setScene(scene);
    }
}