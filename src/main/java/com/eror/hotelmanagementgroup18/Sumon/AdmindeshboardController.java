package com.eror.hotelmanagementgroup18.Sumon;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class AdmindeshboardController {

    private void navigate(ActionEvent event, String path) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(path));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            System.err.println("Error: " + path + " not found!");
            e.printStackTrace();
        }
    }

    @FXML
    void handleManageInventoryBtn(ActionEvent event) {
        navigate(event, "/com/eror/hotelmanagementgroup18/Sumon/user_7goal1.fxml");
    }

    @FXML
    void handlePayrollManagementBtn(ActionEvent event) {
        // এখানে আগে navigateTo ছিল, এখন navigate করে দেওয়া হয়েছে
        navigate(event, "/com/eror/hotelmanagementgroup18/Sumon/user_7goal2.fxml");
    }

    @FXML
    void handleSignOutBtn(ActionEvent event) {
        navigate(event, "/com/eror/hotelmanagementgroup18/hello-view.fxml");
    }


    @FXML
    void handlePricingControlsBtn(ActionEvent event) {
        navigate(event, "/com/eror/hotelmanagementgroup18/Sumon/user_7goal3.fxml");
    }

    @FXML
    void handleVIPGuestListBtn(ActionEvent event) {
        navigate(event, "/com/eror/hotelmanagementgroup18/Sumon/user_7goal4.fxml");
    }
}