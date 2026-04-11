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
        chargeTypeComboBox.getItems().addAll("Mini Bar", "Room Service", "Laundry Service", "Spa Services","Phone Calls", "Internet Usage", "Parking Fee", "Late Check-out Fee","Extra Bed", "Pet Fee", "Breakfast", "Lunch", "Dinner","Movie Rental", "Transportation", "Tour Booking", "Concierge Service", "Damaged Item");

        guestCol.setCellValueFactory(new PropertyValueFactory<>("guestId"));
        chargeTypeCol.setCellValueFactory(new PropertyValueFactory<>("chargeType"));
        amountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
    }

    @javafx.fxml.FXML
    public void addChargeButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backButtonOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Goal_10_generateInvoice.fxml"));
        Scene scene = new Scene((Parent) fxmlLoader.load());
        Button b = (Button) actionEvent.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void nextButtonOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Goal_12_refundAdjustment.fxml"));
        Scene scene = new Scene((Parent) fxmlLoader.load());
        Button b = (Button) actionEvent.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        stage.setScene(scene);
    }
}