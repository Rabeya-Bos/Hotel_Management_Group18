package com.eror.hotelmanagementgroup18.urmi;

import com.eror.hotelmanagementgroup18.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

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
        guestCol.setCellValueFactory(new PropertyValueFactory<>("guestId"));
        roomCol.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
        amountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));

    }

    @javafx.fxml.FXML
    public void addPaymentButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void nextButtonOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Goal_10_generateInvoice.fxml"));
        Scene scene = new Scene((Parent) fxmlLoader.load());
        Button b = (Button) actionEvent.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        stage.setScene(scene);

    }
}