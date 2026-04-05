package com.eror.hotelmanagementgroup18.Rabeya;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class guest1 {

    @FXML
    private ComboBox<?> adultsCombo;

    @FXML
    private Label availabilityStatus;

    @FXML
    private TableColumn<?, ?> capacityCol;

    @FXML
    private DatePicker checkInDate;

    @FXML
    private DatePicker checkOutDate;

    @FXML
    private ComboBox<?> childrenCombo;

    @FXML
    private Label confirmationMsg;

    @FXML
    private TextField emailField;

    @FXML
    private TextField guestNameField;

    @FXML
    private CheckBox helicopterChk;

    @FXML
    private TextField passportField;

    @FXML
    private TableColumn<?, ?> priceCol;

    @FXML
    private CheckBox privateChefChk;

    @FXML
    private TableColumn<?, ?> roomNoCol;

    @FXML
    private ComboBox<?> roomSelectCombo;

    @FXML
    private TableColumn<?, ?> roomTypeCol;

    @FXML
    private TableView<?> roomsTable;

    @FXML
    private TextArea specialRequestsArea;

    @FXML
    private TableColumn<?, ?> viewCol;

    @FXML
    private CheckBox yachtRentalChk;

    @FXML
    void checkAvailabilityBtn(ActionEvent event) {

    }

    @FXML
    void confirmBookingBtn(ActionEvent event) {

    }
    //SceneSwitcher
    @FXML
    void returnHomeBtn(ActionEvent actionEvent) throws IOException {

        try {
            Scene scene = ((Button) actionEvent.getSource()).getScene();
            Stage stage = (Stage) scene.getWindow();

            FXMLLoader scene2FxmlLoader = new FXMLLoader(guestDashboard.class.getResource("com/eror/hotelmanagementgroup18/Rabeya/guestDashboard.fxml"));
            Scene scene2 = new Scene(scene2FxmlLoader.load());
            stage.setScene(scene2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }}
