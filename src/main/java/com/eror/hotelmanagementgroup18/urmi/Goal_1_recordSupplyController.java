package com.eror.hotelmanagementgroup18.urmi;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class Goal_1_recordSupplyController
{
    @javafx.fxml.FXML
    private TableColumn<RecordSupply, LocalDate> dateCol;
    @javafx.fxml.FXML
    private ComboBox<String> itemComboBox;
    @javafx.fxml.FXML
    private TableColumn<RecordSupply,Integer> quantityCol;
    @javafx.fxml.FXML
    private DatePicker datePicker;
    @javafx.fxml.FXML
    private TextField quantityTF;
    @javafx.fxml.FXML
    private TableView<RecordSupply> supplyTV;
    @javafx.fxml.FXML
    private Label statusLabel;
    @javafx.fxml.FXML
    private TableColumn<RecordSupply,Integer> itemCol;

    @javafx.fxml.FXML
    public void initialize() {


    }


    @javafx.fxml.FXML
    public void saveSupplyButtonOA(ActionEvent actionEvent) {


    }
}