package com.eror.hotelmanagementgroup18.Rabeya;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class Receptionist5 {

    @FXML
    private Label confirmationMsg;

    @FXML
    private TableColumn<?, ?> descriptionCol;

    @FXML
    private Label memberNameLabel;

    @FXML
    private Label pointsLabel;

    @FXML
    private TableColumn<?, ?> pointsNeededCol;

    @FXML
    private TextField pointsToAddField;

    @FXML
    private TableColumn<?, ?> rewardIdCol;

    @FXML
    private TableColumn<?, ?> rewardNameCol;

    @FXML
    private ComboBox<?> rewardSelectCombo;

    @FXML
    private TableView<?> rewardsTable;

    @FXML
    private TextField searchMemberField;

    @FXML
    private Label tierLabel;

    @FXML
    void addPointsBtn(ActionEvent event) {

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
    void redeemBtn(ActionEvent event) {

    }

    @FXML
    void searchMemberBtn(ActionEvent event) {

    }

}
