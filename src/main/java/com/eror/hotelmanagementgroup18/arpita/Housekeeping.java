package com.eror.hotelmanagementgroup18.arpita;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Housekeeping {
    private String room;
    private String status;


    public Housekeeping() {
    }


    public Housekeeping(String room, String status) {
        this.room = room;
        this.status = status;
    }




    public void switchScene(String fxmlPath, ActionEvent event) {
        try {
            var resource = getClass().getResource(fxmlPath);
            if (resource == null) {
                System.err.println("wrong destination: " + fxmlPath + " Not Available!");
                return;
            }
            FXMLLoader loader = new FXMLLoader(resource);
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
            System.out.println("successfully load: " + fxmlPath);
        } catch (IOException e) {
            System.err.println("problem in loading: " + fxmlPath);
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void ShiftChangeOA(ActionEvent actionEvent) {
        switchScene("/com/eror/hotelmanagementgroup18/arpita/Goal6-ShiftChangeRequest.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void ReportIssuesOA(ActionEvent actionEvent) {
        switchScene("/com/eror/hotelmanagementgroup18/arpita/Goal2-ReportMaintenanceIssue.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void MessagesOA(ActionEvent actionEvent) {
        switchScene("/com/eror/hotelmanagementgroup18/arpita/Goal8-Messages.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void FloorProgressOA(ActionEvent actionEvent) {
        switchScene("/com/eror/hotelmanagementgroup18/arpita/Goal7-FloorCleaningProgress.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void LostAndFoundOA(ActionEvent actionEvent) {
        switchScene("/com/eror/hotelmanagementgroup18/arpita/Goal3-Lost&Found.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void LoginOA(ActionEvent actionEvent) {
        // লগআউট করে মেইন স্ক্রিনে যাওয়ার জন্য
        switchScene("/com/eror/hotelmanagementgroup18/hello-view.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void ProfileOA(ActionEvent actionEvent) {
        switchScene("/com/eror/hotelmanagementgroup18/arpita/Goal4-UpdateProfile.fxml", actionEvent);
    }

    @javafx.fxml.FXML public void EmergencyOA(ActionEvent actionEvent) {
        switchScene("/com/eror/hotelmanagementgroup18/arpita/Goal5-EmergencyReport.fxml", actionEvent);

    }
    @javafx.fxml.FXML public void CleaningStatusOA(ActionEvent actionEvent) {
        switchScene("/com/eror/hotelmanagementgroup18/arpita/Goal1-UpdateCleaningStatus.fxml", actionEvent);

    }
}