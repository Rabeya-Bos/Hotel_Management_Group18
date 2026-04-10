package com.eror.hotelmanagementgroup18.arpita;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

public class Manager {

    private void switchScene(String fxmlPath, ActionEvent event) {
        try {
            // চেক করা হচ্ছে ফাইলটি আসলে আছে কি না
            if (getClass().getResource(fxmlPath) == null) {
                System.out.println("Error: FXML file not found at -> " + fxmlPath);
                return;
            }
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void HousekeepingStatusOA(ActionEvent actionEvent) {
        // .java নয়, .fxml লোড করতে হবে
        switchScene("/com/eror/hotelmanagementgroup18/arpita/Scene-3-MonitorHousekeepingStatus.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    void CheckINRequestOA(ActionEvent actionEvent) {
        switchScene("/com/eror/hotelmanagementgroup18/arpita/Scene-4-ApproveGuestCheck-In.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void DisscountOA(ActionEvent actionEvent) {
        switchScene("/com/eror/hotelmanagementgroup18/arpita/Scene-7-Apply Discount.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void GuestBookingOA(ActionEvent actionEvent) {
        switchScene("/com/eror/hotelmanagementgroup18/arpita/Scene-2_AssignRoomstoGuests.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void PricingOA(ActionEvent actionEvent) {
        switchScene("/com/eror/hotelmanagementgroup18/arpita/Scene-6-SeasonalPricing.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void LoginOA(ActionEvent actionEvent) {
        switchScene("/com/eror/hotelmanagementgroup18/hello-view.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void LateCheckoutOA(ActionEvent actionEvent) {
        switchScene("/com/eror/hotelmanagementgroup18/arpita/Scene-5-LateCheck-OutRequests.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void RoomManagemenOA(ActionEvent actionEvent) {
        switchScene("/com/eror/hotelmanagementgroup18/arpita/Scene-1-ManageRoomAvailability.fxml", actionEvent);
    }

    // আপনার লাস্ট এররটি এই মেথডটি না থাকার কারণে আসছিল
    @javafx.fxml.FXML
    public void StaffSchedulingOA(ActionEvent actionEvent) {
        switchScene("/com/eror/hotelmanagementgroup18/arpita/Scene-8-StaffScheduling.fxml", actionEvent);
    }
}