package com.eror.hotelmanagementgroup18.Rabeya;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;
import java.util.List;

public class Receptionist1 {

    // --- FXML Controls ---
    @FXML private Label availabilityLabel;
    @FXML private Label confirmationMsg;
    @FXML private TextField guestNameField;
    @FXML private TextField passportField;
    @FXML private TextField phoneField;
    @FXML private ComboBox<String> roomCombo;
    @FXML private CheckBox champagneChk;
    @FXML private CheckBox flowersChk;
    @FXML private CheckBox tempControlChk;

    // --- RoomBooking class ---
    public static class RoomBooking implements Serializable {
        String guestName;
        String passport;
        String phone;
        String room;
        boolean champagne;
        boolean flowers;
        boolean tempControl;

        public RoomBooking(String guestName, String passport, String phone, String room,
                           boolean champagne, boolean flowers, boolean tempControl) {
            this.guestName = guestName;
            this.passport = passport;
            this.phone = phone;
            this.room = room;
            this.champagne = champagne;
            this.flowers = flowers;
            this.tempControl = tempControl;
        }
    }

    // --- Initialize ---
    @FXML
    public void initialize() {
        roomCombo.getItems().addAll("101", "102", "103", "201", "202", "203");
    }

    // --- Check availability ---
    @FXML
    void checkAvailabilityBtn(ActionEvent event) {
        if (guestNameField.getText().isEmpty() ||
                passportField.getText().isEmpty() ||
                phoneField.getText().isEmpty() ||
                roomCombo.getValue() == null) {

            availabilityLabel.setText("Please fill all fields!");
            return;
        }

        availabilityLabel.setText("Room " + roomCombo.getValue() + " is available ✅");
    }

    // --- Confirm booking ---
    @FXML
    void confirmBtn(ActionEvent event) {
        if (guestNameField.getText().isEmpty() ||
                passportField.getText().isEmpty() ||
                phoneField.getText().isEmpty() ||
                roomCombo.getValue() == null) {

            confirmationMsg.setText("Please fill all fields before confirming!");
            return;
        }

        RoomBooking booking = new RoomBooking(
                guestNameField.getText(),
                passportField.getText(),
                phoneField.getText(),
                roomCombo.getValue(),
                champagneChk.isSelected(),
                flowersChk.isSelected(),
                tempControlChk.isSelected()
        );

        try {
            File file = new File("roomBookings.bin");
            ObjectOutputStream oos;
            if (file.exists()) {
                oos = new AppendableObjectOutputStream(new FileOutputStream(file,true));
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(file));
            }
            oos.writeObject(booking);
            oos.close();
            confirmationMsg.setText("Booking confirmed ✅");
        } catch (Exception e) {
            confirmationMsg.setText("Error saving booking!");
            e.printStackTrace();
        }
    }

    // --- Scene switch back to dashboard ---
    @FXML
    void homeBtn(ActionEvent actionEvent) throws IOException {
        Scene scene = ((Button) actionEvent.getSource()).getScene();
        Stage stage = (Stage) scene.getWindow();

        FXMLLoader scene2FxmlLoader = new FXMLLoader(guestDashboard.class.getResource("/com/eror/hotelmanagementgroup18/Rabeya/ReceptionistDashboard.fxml"));
        Scene scene2 = new Scene(scene2FxmlLoader.load());
        stage.setScene(scene2);
    }

    // --- Appendable ObjectOutputStream ---
    static class AppendableObjectOutputStream extends ObjectOutputStream {
        public AppendableObjectOutputStream(OutputStream out) throws IOException { super(out); }
        @Override
        protected void writeStreamHeader() throws IOException { reset(); }
    }
}