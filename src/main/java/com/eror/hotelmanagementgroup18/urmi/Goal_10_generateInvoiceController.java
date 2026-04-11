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

public class Goal_10_generateInvoiceController
{
    @javafx.fxml.FXML
    private TextField guestTF;
    @javafx.fxml.FXML
    private TableColumn<GenerateInvoice,Integer> nightCol;
    @javafx.fxml.FXML
    private TableColumn<GenerateInvoice,Integer> totalCol;
    @javafx.fxml.FXML
    private TextField nightTF;
    @javafx.fxml.FXML
    private TableView<GenerateInvoice> invoiceTV;
    @javafx.fxml.FXML
    private TableColumn<GenerateInvoice,Integer> guestCol;

    @javafx.fxml.FXML
    public void initialize() {
        guestCol.setCellValueFactory(new PropertyValueFactory<>("guestId"));
        nightCol.setCellValueFactory(new PropertyValueFactory<>("nightsStayed"));
        totalCol.setCellValueFactory(new PropertyValueFactory<>("totalAmount"));
    }

    @javafx.fxml.FXML
    public void addInvoiceButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backButtonOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Goal_9_processPayment.fxml"));
        Scene scene = new Scene((Parent) fxmlLoader.load());
        Button b = (Button) actionEvent.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void nextButtonOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Goal_11_additionalCharges.fxml"));
        Scene scene = new Scene((Parent) fxmlLoader.load());
        Button b = (Button) actionEvent.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        stage.setScene(scene);
    }
}