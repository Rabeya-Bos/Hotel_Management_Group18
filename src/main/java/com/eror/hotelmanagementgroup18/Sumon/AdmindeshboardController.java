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

public class AdmindeshboardController {

    @FXML private Button manageInventoryBtn;
    @FXML private Button payrollBtn;
    @FXML private Button pricingBtn;
    @FXML private Button vipGuestBtn;
    @FXML private Button signOutBtn;

    @FXML
    private void handleManageInventoryBtn(ActionEvent event) throws IOException {
        navigateTo(event, "/com/eror/hotelmanagementgroup18/Sumon/user_7goal1.fxml");
    }

    @FXML
    private void handlePayrollBtn(ActionEvent event) throws IOException {
        navigateTo(event, "/com/eror/hotelmanagementgroup18/Sumon/user_7goal2.fxml");
    }

    @FXML
    private void handlePricingBtn(ActionEvent event) throws IOException {
        navigateTo(event, "/com/eror/hotelmanagementgroup18/Sumon/user_7goal3.fxml");
    }

    @FXML
    private void handleVIPGuestBtn(ActionEvent event) throws IOException {
        navigateTo(event, "/com/eror/hotelmanagementgroup18/Sumon/user_7goal4.fxml");
    }

    @FXML
    private void handleSignOutBtn(ActionEvent event) throws IOException {
        navigateTo(event, "/com/eror/hotelmanagementgroup18/Sumon/Login.fxml");
    }

    // Helper method for Scene Switching
    private void navigateTo(ActionEvent event, String path) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}