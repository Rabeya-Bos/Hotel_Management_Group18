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
        invoiceCol.setCellValueFactory(new PropertyValueFactory<>("invoiceId"));
        refundAmountCol.setCellValueFactory(new PropertyValueFactory<>("refundAmount"));
        reasonCol.setCellValueFactory(new PropertyValueFactory<>("reason"));
    }

    @javafx.fxml.FXML
    public void processRefundButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backButtonOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Goal_11_additionalCharges.fxml"));
        Scene scene = new Scene((Parent) fxmlLoader.load());
        Button b = (Button) actionEvent.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void nextButtonOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Goal_13_dailyCashSummary.fxml"));
        Scene scene = new Scene((Parent) fxmlLoader.load());
        Button b = (Button) actionEvent.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        stage.setScene(scene);
    }
}