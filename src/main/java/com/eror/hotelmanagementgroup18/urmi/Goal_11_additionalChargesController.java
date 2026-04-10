package com.eror.hotelmanagementgroup18.urmi;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class Goal_11_additionalChargesController
{
    @javafx.fxml.FXML
    private Label totalLabel;
    @javafx.fxml.FXML
    private TableColumn<AdditionalCharges,String> chargeTypeCol;
    @javafx.fxml.FXML
    private TableColumn<AdditionalCharges,Double> amountCol;
    @javafx.fxml.FXML
    private ComboBox<String> chargeTypeComboBox;
    @javafx.fxml.FXML
    private TextField amountTF;
    @javafx.fxml.FXML
    private TableColumn<AdditionalCharges,Integer> guestCol;
    @javafx.fxml.FXML
    private TextField guestIdTF;
    @javafx.fxml.FXML
    private TableView<AdditionalCharges> chargeTV;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void addChargeButtonOA(ActionEvent actionEvent) {
    }
}