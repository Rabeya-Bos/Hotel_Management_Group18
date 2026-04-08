package com.eror.hotelmanagementgroup18.Rabeya;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class guest4 {

    @FXML
    private Label availabilityLabel;

    @FXML
    private TextArea healthNotesArea;

    @FXML
    private Label msgLabel;

    @FXML
    private DatePicker spaDate;

    @FXML
    private ComboBox<?> therapistPrefCombo;

    @FXML
    private ComboBox<?> timeSlotCombo;

    @FXML
    private ComboBox<?> treatmentSelectCombo;

    @FXML
    void checkBtn(ActionEvent event) {

    }

    @FXML
    void confirmBtn(ActionEvent event) {

    }

    @FXML
    void homeBtn(ActionEvent actionEvent) throws IOException {

        try {
            Scene scene = ((Button) actionEvent.getSource()).getScene();
            Stage stage = (Stage) scene.getWindow();

            FXMLLoader scene2FxmlLoader = new FXMLLoader(guestDashboard.class.getResource("/com/example/demo/Rabeya/guestDashboard.fxml"));
            Scene scene2 = new Scene(scene2FxmlLoader.load());
            stage.setScene(scene2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
