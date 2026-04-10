package com.eror.hotelmanagementgroup18.urmi;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class Goal_9_processPaymentController
{
    @javafx.fxml.FXML
    private TextField guestTF;
    @javafx.fxml.FXML
    private TableColumn<ProcessPayment,Double> amountCol;
    @javafx.fxml.FXML
    private TextField roomTF;
    @javafx.fxml.FXML
    private TableColumn<ProcessPayment,Integer> roomCol;
    @javafx.fxml.FXML
    private TextField amountTF;
    @javafx.fxml.FXML
    private TableColumn<ProcessPayment,String> guestCol;
    @javafx.fxml.FXML
    private TableView<ProcessPayment> paymentTV;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void addPaymentButtonOA(ActionEvent actionEvent) {
    }
}