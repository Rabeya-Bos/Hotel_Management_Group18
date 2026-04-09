package com.eror.hotelmanagementgroup18.Rabeya;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class Receptionist7 {

    @FXML
    private ComboBox<?> compensationCombo;

    @FXML
    private TextArea complaintDetailsArea;

    @FXML
    private TableColumn<?, ?> complaintIdCol;

    @FXML
    private TableColumn<?, ?> complaintStatusCol;

    @FXML
    private TableColumn<?, ?> complaintTypeCol;

    @FXML
    private TableView<?> complaintsTable;

    @FXML
    private TableColumn<?, ?> guestNameCol;

    @FXML
    private TableColumn<?, ?> priorityCol;

    @FXML
    private TextArea resolutionNotesArea;

    @FXML
    private Label statusLabel;

    @FXML
    void escalateBtn(ActionEvent event) {

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

    @FXML
    void resolveBtn(ActionEvent event) {

    }

}
