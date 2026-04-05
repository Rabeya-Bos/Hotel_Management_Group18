package com.eror.hotelmanagementgroup18.Rabeya;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class guest2 {

    @FXML
    private TextField additionalDetailsField;

    @FXML
    private Label availabilityStatus;

    @FXML
    private Label confirmationMsg;

    @FXML
    private TableColumn<?, ?> serviceAvailabilityCol;

    @FXML
    private DatePicker serviceDate;

    @FXML
    private TableColumn<?, ?> serviceIdCol;

    @FXML
    private TableColumn<?, ?> serviceNameCol;

    @FXML
    private TableColumn<?, ?> servicePriceCol;

    @FXML
    private TableView<?> serviceTable;

    @FXML
    private ComboBox<?> serviceTimeCombo;

    @FXML
    private ComboBox<?> serviceTypeCombo;

    @FXML
    private TextArea specialInstructionsArea;

    @FXML
    void checkAvailabilityBtn(ActionEvent event) {

    }

    @FXML
    void confirmRequestBtn(ActionEvent event) {

    }

    @FXML
    void returnHomeBtn(ActionEvent actionEvent) throws IOException {

        try {
            Scene scene = ((Button) actionEvent.getSource()).getScene();
            Stage stage = (Stage) scene.getWindow();

            FXMLLoader scene2FxmlLoader = new FXMLLoader(guestDashboard.class.getResource("/com/example/demo/Rabeya/guestDashboard.fxml"));
            Scene scene2 = new Scene(scene2FxmlLoader.load());
            stage.setScene(scene2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }}

