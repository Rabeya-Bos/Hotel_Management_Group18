package com.eror.hotelmanagementgroup18.urmi;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.time.LocalDate;

public class Goal_13_dailyCashSummaryController
{
    @javafx.fxml.FXML
    private TableView<DailyCashSummary> summaryTable;
    @javafx.fxml.FXML
    private TableColumn<DailyCashSummary,Double> amountCol;
    @javafx.fxml.FXML
    private TableColumn<DailyCashSummary,LocalDate> dateCol;
    @javafx.fxml.FXML
    private DatePicker datePicker;
    @javafx.fxml.FXML
    private TableColumn<DailyCashSummary,Integer> transactionIdCol;
    @javafx.fxml.FXML
    private TableColumn<DailyCashSummary,String> paymentMethodCol;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void generateSummary(ActionEvent actionEvent) {
    }
}