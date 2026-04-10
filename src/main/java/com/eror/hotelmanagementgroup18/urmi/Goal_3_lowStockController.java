package com.eror.hotelmanagementgroup18.urmi;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class Goal_3_lowStockController
{
    @javafx.fxml.FXML
    private TableColumn<LowStock,String> thresholdCol;
    @javafx.fxml.FXML
    private TableView<LowStock> stockTV;
    @javafx.fxml.FXML
    private TextField thresholdTF;
    @javafx.fxml.FXML
    private TableColumn<LowStock,Integer> currentStockCol;
    @javafx.fxml.FXML
    private TableColumn<LowStock,Integer> itemCol;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void setThresholdButtonOA(ActionEvent actionEvent) {
    }
}