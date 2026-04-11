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

public class Goal_16_shiftClosingController
{
    @javafx.fxml.FXML
    private TextField cashierNameTF;
    @javafx.fxml.FXML
    private TextField totalOnlineTF;
    @javafx.fxml.FXML
    private TableColumn<ShiftClosing,Integer> countCol;
    @javafx.fxml.FXML
    private TableColumn<ShiftClosing,Double> amountCol;
    @javafx.fxml.FXML
    private TextField totalCashTF;
    @javafx.fxml.FXML
    private TextField shiftDateTF;
    @javafx.fxml.FXML
    private TextArea notesTA;
    @javafx.fxml.FXML
    private TextField totalCardTF;
    @javafx.fxml.FXML
    private TableView<ShiftClosing> shiftSummaryTV;
    @javafx.fxml.FXML
    private Label submissionStatusLabel;
    @javafx.fxml.FXML
    private TextField grandTotalTF;
    @javafx.fxml.FXML
    private Label statusLabel;
    @javafx.fxml.FXML
    private TableColumn<ShiftClosing,String> TypeCol;

    @javafx.fxml.FXML
    public void initialize() {
        TypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        countCol.setCellValueFactory(new PropertyValueFactory<>("count"));
        amountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
    }

    @javafx.fxml.FXML
    public void submitReportButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void printReportButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backButtonOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Goal_15_transactionSearch.fxml"));
        Scene scene = new Scene((Parent) fxmlLoader.load());
        Button b = (Button) actionEvent.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        stage.setScene(scene);
    }
}