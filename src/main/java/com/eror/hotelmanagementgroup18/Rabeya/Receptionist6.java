package com.eror.hotelmanagementgroup18.Rabeya;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class Receptionist6 {

    @FXML
    private Label availabilityLabel;

    @FXML
    private TableColumn<?, ?> capacityCol;

    @FXML
    private ComboBox<?> cateringCombo;

    @FXML
    private Label confirmationMsg;

    @FXML
    private DatePicker endDatePicker;

    @FXML
    private ComboBox<?> eventTypeCombo;

    @FXML
    private ComboBox<?> guestCountCombo;

    @FXML
    private TextField guestNameField;

    @FXML
    private TableColumn<?, ?> priceCol;

    @FXML
    private TextArea requirementsArea;

    @FXML
    private DatePicker startDatePicker;

    @FXML
    private TableColumn<?, ?> statusCol;

    @FXML
    private TableColumn<?, ?> venueIdCol;

    @FXML
    private TableColumn<?, ?> venueNameCol;

    @FXML
    private TableView<?> venuesTable;

    @FXML
    void checkAvailabilityBtn(ActionEvent event) {

    }

    @FXML
    void confirmEventBtn(ActionEvent event) {

    }

    @FXML
    void homeBtn(ActionEvent actionEvent) throws IOException {

        try {
            Scene scene = ((Button) actionEvent.getSource()).getScene();
            Stage stage = (Stage) scene.getWindow();

            FXMLLoader scene2FxmlLoader = new FXMLLoader(guestDashboard.class.getResource("/com/eror/hotelmanagementgroup18/Rabeya/ReceptionistDashboard.fxml"));
            Scene scene2 = new Scene(scene2FxmlLoader.load());
            stage.setScene(scene2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
