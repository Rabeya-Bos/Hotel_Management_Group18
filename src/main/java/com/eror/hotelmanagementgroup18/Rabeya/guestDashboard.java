package com.eror.hotelmanagementgroup18.Rabeya;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class guestDashboard {

    // 🔁 Reusable method for switching scenes
    private void switchScene(ActionEvent event, String fxmlFile) {
        try {
            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🎯 Buttons (clean and short)

    @FXML
    void guest1Btn(ActionEvent event) {
        switchScene(event, "/com/eror/hotelmanagementgroup18/Rabeya/guest1.fxml");
    }

    @FXML
    void guest2Btn(ActionEvent event) {
        switchScene(event, "/com/eror/hotelmanagementgroup18/Rabeya/guest2.fxml");
    }

    @FXML
    void guest3Btn(ActionEvent event) {
        switchScene(event, "/com/eror/hotelmanagementgroup18/Rabeya/guest3.fxml");
    }

    @FXML
    void guest4Btn(ActionEvent event) {
        switchScene(event, "/com/eror/hotelmanagementgroup18/Rabeya/guest4.fxml");
    }

    @FXML
    void guest5Btn(ActionEvent event) {
        switchScene(event, "/com/eror/hotelmanagementgroup18/Rabeya/guest5.fxml");
    }

    @FXML
    void guest6Btn(ActionEvent event) {
        switchScene(event, "/com/eror/hotelmanagementgroup18/Rabeya/guest6.fxml");
    }

    @FXML
    void guest7Btn(ActionEvent event) {
        switchScene(event, "/com/eror/hotelmanagementgroup18/Rabeya/guest7.fxml");
    }

    @FXML
    void guest8Btn(ActionEvent event) {
        switchScene(event, "/com/eror/hotelmanagementgroup18/Rabeya/guest8.fxml");
    }

    // 🔓 Logout button (FIXED)
    @FXML
    void logoutBtn(ActionEvent event) {
        switchScene(event, "/com/eror/hotelmanagementgroup18/Rabeya/Login.fxml");
    }
}