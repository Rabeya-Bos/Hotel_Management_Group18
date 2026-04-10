package com.eror.hotelmanagementgroup18.urmi;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

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
}