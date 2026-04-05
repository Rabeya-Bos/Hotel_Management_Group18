package com.eror.hotelmanagementgroup18.Rabeya;


import com.eror.hotelmanagementgroup18.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class guestDashboard {

    @FXML
    void guest1Btn(ActionEvent actionEvent) throws IOException {

        try {
            Scene scene = ((Button) actionEvent.getSource()).getScene();
            Stage stage = (Stage) scene.getWindow();

            FXMLLoader scene2FxmlLoader = new FXMLLoader(guestDashboard.class.getResource("com/eror/hotelmanagementgroup18/Rabeya/guest1.fxml"));
            Scene scene2 = new Scene(scene2FxmlLoader.load());
            stage.setScene(scene2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void guest2Btn(ActionEvent actionEvent) throws IOException {

        try {
            Scene scene = ((Button) actionEvent.getSource()).getScene();
            Stage stage = (Stage) scene.getWindow();

            FXMLLoader scene2FxmlLoader = new FXMLLoader(guestDashboard.class.getResource("com/eror/hotelmanagementgroup18/Rabeya/guest2.fxml"));
            Scene scene2 = new Scene(scene2FxmlLoader.load());
            stage.setScene(scene2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void guest3Btn(ActionEvent actionEvent) throws IOException {

        try {
            Scene scene = ((Button) actionEvent.getSource()).getScene();
            Stage stage = (Stage) scene.getWindow();

            FXMLLoader scene2FxmlLoader = new FXMLLoader(guestDashboard.class.getResource("com/eror/hotelmanagementgroup18/Rabeya/guest3.fxml"));
            Scene scene2 = new Scene(scene2FxmlLoader.load());
            stage.setScene(scene2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void guest4Btn(ActionEvent actionEvent) throws IOException {

        try {
            Scene scene = ((Button) actionEvent.getSource()).getScene();
            Stage stage = (Stage) scene.getWindow();

            FXMLLoader scene2FxmlLoader = new FXMLLoader(guestDashboard.class.getResource("com/eror/hotelmanagementgroup18/Rabeya/guest4.fxml"));
            Scene scene2 = new Scene(scene2FxmlLoader.load());
            stage.setScene(scene2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void guest5Btn(ActionEvent actionEvent) throws IOException {

        try {
            Scene scene = ((Button) actionEvent.getSource()).getScene();
            Stage stage = (Stage) scene.getWindow();

            FXMLLoader scene2FxmlLoader = new FXMLLoader(guestDashboard.class.getResource("com/eror/hotelmanagementgroup18/Rabeya/guest5.fxml"));
            Scene scene2 = new Scene(scene2FxmlLoader.load());
            stage.setScene(scene2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void guest6Btn(ActionEvent actionEvent) throws IOException {

        try {
            Scene scene = ((Button) actionEvent.getSource()).getScene();
            Stage stage = (Stage) scene.getWindow();

            FXMLLoader scene2FxmlLoader = new FXMLLoader(guestDashboard.class.getResource("com/eror/hotelmanagementgroup18/Rabeya/guest6.fxml"));
            Scene scene2 = new Scene(scene2FxmlLoader.load());
            stage.setScene(scene2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void guest7Btn(ActionEvent actionEvent) throws IOException {

        try {
            Scene scene = ((Button) actionEvent.getSource()).getScene();
            Stage stage = (Stage) scene.getWindow();

            FXMLLoader scene2FxmlLoader = new FXMLLoader(guestDashboard.class.getResource("com/eror/hotelmanagementgroup18/Rabeya/guest7.fxml"));
            Scene scene2 = new Scene(scene2FxmlLoader.load());
            stage.setScene(scene2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void guest8Btn(ActionEvent actionEvent) throws IOException {

        try {
            Scene scene = ((Button) actionEvent.getSource()).getScene();
            Stage stage = (Stage) scene.getWindow();

            FXMLLoader scene2FxmlLoader = new FXMLLoader(guestDashboard.class.getResource("com/eror/hotelmanagementgroup18/Rabeya/guest8.fxml"));
            Scene scene2 = new Scene(scene2FxmlLoader.load());
            stage.setScene(scene2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void logoutBtn(ActionEvent actionEvent) throws IOException {

        try {
            Scene scene = ((Button) actionEvent.getSource()).getScene();
            Stage stage = (Stage) scene.getWindow();

            FXMLLoader scene2FxmlLoader = new FXMLLoader(Login.class.getResource("com/eror/hotelmanagementgroup18/Login.fxml"));
            Scene scene2 = new Scene(scene2FxmlLoader.load());
            stage.setScene(scene2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

}}
