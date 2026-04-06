package com.eror.hotelmanagementgroup18.arpita;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Housekeeping {

    private String selectedPage = "";

    @javafx.fxml.FXML
    public void ShiftChangeOA(ActionEvent actionEvent) {
        selectedPage = "Goal 6-Shift Change Request.fxml";
    }

    @javafx.fxml.FXML
    public void EmergencyOA(ActionEvent actionEvent) {
        selectedPage = "Goal 5-Emergency Report.fxml";
    }

    @javafx.fxml.FXML
    public void ReportIssuesOA(ActionEvent actionEvent) {
        selectedPage = "Goal 2- Report Maintenance Issue.fxml";
    }

    @javafx.fxml.FXML
    public void MessagesOA(ActionEvent actionEvent) {
        selectedPage = "Goal 8-Messages.fxml";
    }

    @javafx.fxml.FXML
    public void FloorProgressOA(ActionEvent actionEvent) {
        selectedPage = "Goal 7- Floor Cleaning Progress.fxml";
    }

    @javafx.fxml.FXML
    public void LostAndFoundOA(ActionEvent actionEvent) {
        selectedPage = "Goal 3-Lost & Found.fxml";
    }

    @javafx.fxml.FXML
    public void CleaningStatusOA(ActionEvent actionEvent) {
        selectedPage = "Goal 1- Update Cleaning Status.fxml";
    }

    @javafx.fxml.FXML
    public void ProfileOA(ActionEvent actionEvent) {
        selectedPage = "Goal 4-Update Profile.fxml";
    }

    @javafx.fxml.FXML
    public void LoginOA(ActionEvent actionEvent) throws IOException {

        if (selectedPage == null || selectedPage.isEmpty()) {
            System.out.println("Please select an option first!");
            return;
        }

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(selectedPage)
        );

        Scene scene = new Scene(loader.load());

        Button button = (Button) actionEvent.getSource();
        Stage stage = (Stage) button.getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }
}