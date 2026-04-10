package com.eror.hotelmanagementgroup18.urmi;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class Goal_12_refundAdjustmentController
{
    @javafx.fxml.FXML
    private TextField invoiceIdTF;
    @javafx.fxml.FXML
    private TableColumn<RefundAdjustment,String> reasonCol;
    @javafx.fxml.FXML
    private TableView<RefundAdjustment> refundTV;
    @javafx.fxml.FXML
    private TableColumn<RefundAdjustment,Integer> invoiceCol;
    @javafx.fxml.FXML
    private TextField refundAmountTF;
    @javafx.fxml.FXML
    private TextField reasonTF;
    @javafx.fxml.FXML
    private Label messageLabel;
    @javafx.fxml.FXML
    private TableColumn<RefundAdjustment,Double> refundAmountCol;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void processRefundButtonOA(ActionEvent actionEvent) {
    }
}