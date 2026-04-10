package com.eror.hotelmanagementgroup18.urmi;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

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
    }

    @javafx.fxml.FXML
    public void updateUsageButtonOA(ActionEvent actionEvent) {
    }
}