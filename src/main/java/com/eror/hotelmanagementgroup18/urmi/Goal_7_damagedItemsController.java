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

public class Goal_7_damagedItemsController
{
    @javafx.fxml.FXML
    private ComboBox<String> itemComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> conditionComboBox;
    @javafx.fxml.FXML
    private TableColumn<DamagedItems, LocalDate> dateReportedCol;
    @javafx.fxml.FXML
    private ComboBox<String> filterConditionComboBox;
    @javafx.fxml.FXML
    private TableColumn<DamagedItems,String> itemNameCol;
    @javafx.fxml.FXML
    private Label statusLabel;
    @javafx.fxml.FXML
    private TableView<DamagedItems> removedItemsTV;
    @javafx.fxml.FXML
    private TableColumn<DamagedItems,String> statusCol;
    @javafx.fxml.FXML
    private TableColumn<DamagedItems,String> conditionCol;
    @javafx.fxml.FXML
    private TableColumn<DamagedItems,Integer> quantityCol;
    @javafx.fxml.FXML
    private TextArea reasonTA;
    @javafx.fxml.FXML
    private TextField quantityTF;
    @javafx.fxml.FXML
    private TableColumn<DamagedItems,Integer> recordIdCol;

    @javafx.fxml.FXML
    public void initialize() {
        itemComboBox.getItems().addAll("Rice", "Vegetables", "Meat", "Fish", "Spices", "Oil","Cleaning Supplies", "Detergent", "Soap", "Towels","Beverages", "Snacks", "Dairy Products", "Bread");

        conditionComboBox.getItems().addAll("Damaged", "Expired");

        recordIdCol.setCellValueFactory(new PropertyValueFactory<>("recordId"));
        itemNameCol.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        conditionCol.setCellValueFactory(new PropertyValueFactory<>("condition"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        dateReportedCol.setCellValueFactory(new PropertyValueFactory<>("dateReported"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    @javafx.fxml.FXML
    public void resetFilterButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void filterButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void removeStockButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backButtonOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Goal_6_supplierDelivery.fxml"));
        Scene scene = new Scene((Parent) fxmlLoader.load());
        Button b = (Button) actionEvent.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void nextButtonOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Goal_8_inventorySync.fxml"));
        Scene scene = new Scene((Parent) fxmlLoader.load());
        Button b = (Button) actionEvent.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        stage.setScene(scene);
    }
}