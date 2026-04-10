package com.eror.hotelmanagementgroup18.urmi;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.time.LocalDate;

public class Goal_15_transactionSearchController
{
    @javafx.fxml.FXML
    private TableColumn<TransactionSearch,Integer> invoiceIdCol;
    @javafx.fxml.FXML
    private DatePicker fromDatePicker;
    @javafx.fxml.FXML
    private ComboBox<String> searchByComboBox;
    @javafx.fxml.FXML
    private TableColumn<TransactionSearch,Double> amountCol;
    @javafx.fxml.FXML
    private Label resultCountLabel;
    @javafx.fxml.FXML
    private DatePicker toDatePicker;
    @javafx.fxml.FXML
    private TableColumn<TransactionSearch,String> guestNameCol;
    @javafx.fxml.FXML
    private Label statusLabel;
    @javafx.fxml.FXML
    private TableColumn<TransactionSearch, LocalDate> dateCol;
    @javafx.fxml.FXML
    private TableView<TransactionSearch> transactionTV;
    @javafx.fxml.FXML
    private TableColumn<TransactionSearch,Integer> paymentCol;
    @javafx.fxml.FXML
    private TextField searchValueTF;
    @javafx.fxml.FXML
    private TableColumn<TransactionSearch,Integer> transactionIdCol;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void searchButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void resetButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void viewDetailsButtonOA(ActionEvent actionEvent) {
    }
}