package com.eror.hotelmanagementgroup18.urmi;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

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
    }

    @javafx.fxml.FXML
    public void generateReportButtonOA(ActionEvent actionEvent) {
    }
}