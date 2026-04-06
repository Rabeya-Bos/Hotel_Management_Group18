package com.eror.hotelmanagementgroup18.arpita;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Manager {

    private String selectedPage = ""; // stores selected option

    @javafx.fxml.FXML
    public void StaffSchedulingOA(ActionEvent actionEvent) {
        selectedPage = "Scene-8-Staff Scheduling.fxml";
    }

    @javafx.fxml.FXML
    public void HousekeepingStatusOA(ActionEvent actionEvent) {
        selectedPage = "Scene-3-Monitor Housekeeping Status.fxml";
    }

    @javafx.fxml.FXML
    public void CheckINRequestOA(ActionEvent actionEvent) {
        selectedPage = "Scene- 4-Approve Guest Check-In.fxml";
    }

    @javafx.fxml.FXML
    public void DisscountOA(ActionEvent actionEvent) {
        selectedPage = "Scene-7-Apply Discount.fxml";
    }

    @javafx.fxml.FXML
    public void GuestBookingOA(ActionEvent actionEvent) {
        selectedPage = "Scene- 2_Assign Rooms to Guests.fxml";
    }

    @javafx.fxml.FXML
    public void PricingOA(ActionEvent actionEvent) {
        selectedPage = "Scene- 6-Seasonal Pricing.fxml";
    }

    @javafx.fxml.FXML
    public void LateCheckoutOA(ActionEvent actionEvent) {
        selectedPage = "Scene- 5- Late Check-Out Requests.fxml";
    }

    @javafx.fxml.FXML
    public void RoomManagemenOA(ActionEvent actionEvent) {
        selectedPage = "Scene-1-Manage Room Availability.fxml"; // important
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