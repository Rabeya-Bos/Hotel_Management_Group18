package com.eror.hotelmanagementgroup18.arpita;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;

public class Scene2AssignRoomsToGuests {

    @javafx.fxml.FXML
    private TableColumn<Booking_Scene2, String> ColGuestName;
    @javafx.fxml.FXML
    private TableColumn<Booking_Scene2, String> ColRoomType;
    @javafx.fxml.FXML
    private TableColumn<Booking_Scene2, String> ColBookingId;
    @javafx.fxml.FXML
    private TableView<Booking_Scene2> TableView1;

    @javafx.fxml.FXML
    private ComboBox<String> CmbRoomType;
    @javafx.fxml.FXML
    private TextField TXTBookingID, TXTGuestName;
    @javafx.fxml.FXML
    private Label LVLResult;

    private ObservableList<Booking_Scene2> bookingList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {

        ColGuestName.setCellValueFactory(new PropertyValueFactory<>("guestName"));
        ColRoomType.setCellValueFactory(new PropertyValueFactory<>("roomType"));
        ColBookingId.setCellValueFactory(new PropertyValueFactory<>("bookingId"));


        TableView1.setItems(bookingList);
    }

    @javafx.fxml.FXML
    public void AssignRoomOA(ActionEvent actionEvent) {
        String name = TXTGuestName.getText();
        String id = TXTBookingID.getText();
        String type = CmbRoomType.getValue();

        if (name.isEmpty() || id.isEmpty() || type == null) {
            LVLResult.setText("Error: Please fill all fields!");
            return;
        }


        Booking_Scene2 newBooking = new Booking_Scene2(name, type, id);
        bookingList.add(newBooking);
        LVLResult.setText("Room Assigned to " + name);


        TXTGuestName.clear();
        TXTBookingID.clear();
    }

    @javafx.fxml.FXML
    public void UpdateRoomFile(ActionEvent actionEvent) {

        if (bookingList.isEmpty()) {
            LVLResult.setText("No data to save!");
        } else {
            LVLResult.setText("File updated successfully with " + bookingList.size() + " entries.");
        }
    }

    @javafx.fxml.FXML
    public void AvailableRoomOA(ActionEvent actionEvent) {
        LVLResult.setText("Checking for available rooms...");
    }

    @javafx.fxml.FXML
    public void BackOA(ActionEvent actionEvent) throws IOException {
        String path = "/com/eror/hotelmanagementgroup18/arpita/Scene-1-ManageRoomAvailability.fxml";
        switchScene(path, actionEvent);
    }

    @javafx.fxml.FXML
    public void NextOA(ActionEvent actionEvent) throws IOException {

        LVLResult.setText("Moving to next goal...");
    }

    private void switchScene(String path, ActionEvent event) throws IOException {
        if (getClass().getResource(path) == null) {
            LVLResult.setText("FXML File not found!");
            return;
        }
        FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }
}