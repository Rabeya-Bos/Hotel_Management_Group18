package com.eror.hotelmanagementgroup18.urmi;

import com.eror.hotelmanagementgroup18.HelloApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class Goal_2_stockUsageController
{
    @javafx.fxml.FXML
    private TableColumn<StockUsage,String> departmentCol;
    @javafx.fxml.FXML
    private ComboBox<String> itemComboBox;
    @javafx.fxml.FXML
    private TableColumn<StockUsage,Integer> quantityCol;
    @javafx.fxml.FXML
    private TextField quantityTF;
    @javafx.fxml.FXML
    private ComboBox<String> departmentComboBox;
    @javafx.fxml.FXML
    private TableView<StockUsage> usageTV;
    @javafx.fxml.FXML
    private TableColumn<StockUsage,Integer> itemCol;

    @javafx.fxml.FXML
    public void initialize() {
        departmentComboBox.getItems().addAll("Kitchen", "Housekeeping", "Restaurant", "Bar", "Maintenance", "Laundry", "Front Office");

        itemComboBox.getItems().addAll("Rice", "Vegetables", "Meat", "Fish", "Spices", "Oil", "Cleaning Supplies", "Detergent", "Soap", "Towels", "Beverages", "Snacks", "Dairy Products", "Bread");

        departmentCol.setCellValueFactory(new PropertyValueFactory<>("department"));
        itemCol.setCellValueFactory(new PropertyValueFactory<>("item"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantityUsed"));

            }

    @javafx.fxml.FXML
    public void updateUsageButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backButtonOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Goal_1_recordSupply.fxml"));
        Scene scene = new Scene((Parent)fxmlLoader.load());
        Button b = (Button)actionEvent.getSource();
        Stage stage = (Stage)b.getScene().getWindow();
        stage.setScene(scene);

    }

    @javafx.fxml.FXML
    public void nextButtonOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Goal_3_lowStock.fxml"));
        Scene scene = new Scene((Parent)fxmlLoader.load());
        Button b = (Button)actionEvent.getSource();
        Stage stage = (Stage)b.getScene().getWindow();
        stage.setScene(scene);
    }
}