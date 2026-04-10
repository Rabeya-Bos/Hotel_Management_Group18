package com.eror.hotelmanagementgroup18.Sumon;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

public class SecurityDashboardController {

    @FXML private Button accessCardBtn;
    @FXML private Button incidentReportBtn;
    @FXML private Button signOutBtn;

    @FXML
    private void handleAccessCardBtn(ActionEvent event) throws IOException {
        navigateTo(event, "/com/eror/hotelmanagementgroup18/Sumon/user_8goal1.fxml");
    }

    @FXML
    private void handleIncidentReportingBtn(ActionEvent event) throws IOException {
        navigateTo(event, "/com/eror/hotelmanagementgroup18/Sumon/user_8goal2.fxml");
    }

    @FXML
    private void handleSignOutBtn(ActionEvent event) throws IOException {
        navigateTo(event, "/com/eror/hotelmanagementgroup18/Sumon/Login.fxml");
    }

    private void navigateTo(ActionEvent event, String path) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}