package com.eror.hotelmanagementgroup18.urmi;

import com.eror.hotelmanagementgroup18.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
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
        searchByComboBox.getItems().addAll("Transaction ID", "Invoice ID", "Guest Name", "Payment Method");
        searchByComboBox.setValue("Transaction ID");

        transactionIdCol.setCellValueFactory(new PropertyValueFactory<>("transactionId"));
        invoiceIdCol.setCellValueFactory(new PropertyValueFactory<>("invoiceId"));
        guestNameCol.setCellValueFactory(new PropertyValueFactory<>("guestName"));
        amountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        paymentCol.setCellValueFactory(new PropertyValueFactory<>("paymentMethod"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
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

    @javafx.fxml.FXML
    public void backButtonOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Goal_14_paymentMethod.fxml"));
        Scene scene = new Scene((Parent) fxmlLoader.load());
        Button b = (Button) actionEvent.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void nextButtonOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Goal_16_shiftClosing.fxml"));
        Scene scene = new Scene((Parent) fxmlLoader.load());
        Button b = (Button) actionEvent.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        stage.setScene(scene);
    }
}