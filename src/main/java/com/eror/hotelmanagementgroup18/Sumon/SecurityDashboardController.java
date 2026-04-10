package com.eror.hotelmanagementgroup18.Sumon;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class SecurityDashboardController {

    private void navigate(ActionEvent event, String path) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(path));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            System.err.println("Error: Could not load " + path);
            e.printStackTrace();
        }
    }

    @FXML void handleAccessCardBtn(ActionEvent event) { navigate(event, "/com/eror/hotelmanagementgroup18/Sumon/user_8goal1.fxml"); }
    @FXML void handleIncidentReportBtn(ActionEvent event) { navigate(event, "/com/eror/hotelmanagementgroup18/Sumon/user_8goal2.fxml"); }
    @FXML void handleSurveillanceBtn(ActionEvent event) { navigate(event, "/com/eror/hotelmanagementgroup18/Sumon/user_8goal3.fxml"); }
    @FXML void handleEmergencyBtn(ActionEvent event) { navigate(event, "/com/eror/hotelmanagementgroup18/Sumon/user_8goal4.fxml"); }
    @FXML void handleCCTVBtn(ActionEvent event) { navigate(event, "/com/eror/hotelmanagementgroup18/Sumon/user_8goal5.fxml"); }
    @FXML void handleVIPParkingBtn(ActionEvent event) { navigate(event, "/com/eror/hotelmanagementgroup18/Sumon/user_8goal6.fxml"); }
    @FXML void handleLostFoundBtn(ActionEvent event) { navigate(event, "/com/eror/hotelmanagementgroup18/Sumon/user_8goal7.fxml"); }
    @FXML void handleRestrictedZoneBtn(ActionEvent event) { navigate(event, "/com/eror/hotelmanagementgroup18/Sumon/user_8goal8.fxml"); }

    @FXML
    void handleSignOutBtn(ActionEvent event) {
        navigate(event, "/com/eror/hotelmanagementgroup18/hello-view.fxml");
    }
}