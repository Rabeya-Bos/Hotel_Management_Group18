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
        itemComboBox.getItems().addAll("Rice", "Vegetables", "Meat", "Fish", "Spices", "Oil", "Cleaning Supplies", "Detergent", "Soap", "Towels");

        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        itemCol.setCellValueFactory(new PropertyValueFactory<>("item"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        datePicker.setValue(LocalDate.now());

    }


    @javafx.fxml.FXML
    public void saveSupplyButtonOA(ActionEvent actionEvent) {


    }

    @javafx.fxml.FXML
    public void nextButtonOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Goal_2_stockUsage.fxml"));
        Scene scene = new Scene((Parent)fxmlLoader.load());
        Button b = (Button)actionEvent.getSource();
        Stage stage = (Stage)b.getScene().getWindow();
        stage.setScene(scene);
    }
}




