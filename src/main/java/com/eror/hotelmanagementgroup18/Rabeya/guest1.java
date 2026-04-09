package com.eror.hotelmanagementgroup18.Rabeya;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class guest1 {

    // --- FXML Controls ---
    @FXML private ComboBox<Integer> adultsCombo;
    @FXML private ComboBox<Integer> childrenCombo;
    @FXML private ComboBox<Room> roomSelectCombo;
    @FXML private DatePicker checkInDate;
    @FXML private DatePicker checkOutDate;
    @FXML private TextField guestNameField;
    @FXML private TextField emailField;
    @FXML private TextField passportField;
    @FXML private TextArea specialRequestsArea;
    @FXML private CheckBox yachtRentalChk;
    @FXML private CheckBox privateChefChk;
    @FXML private CheckBox helicopterChk;
    @FXML private Label availabilityStatus;
    @FXML private Label confirmationMsg;

    @FXML private TableView<Room> roomsTable;
    @FXML private TableColumn<Room, Integer> roomNoCol;
    @FXML private TableColumn<Room, String> roomTypeCol;
    @FXML private TableColumn<Room, Integer> capacityCol;
    @FXML private TableColumn<Room, Double> priceCol;
    @FXML private TableColumn<Room, String> viewCol;

    // --- Room class ---
    public static class Room implements Serializable {
        private int roomNo;
        private String type;
        private int capacity;
        private double price;
        private String view;

        public Room(int roomNo, String type, int capacity, double price, String view) {
            this.roomNo = roomNo;
            this.type = type;
            this.capacity = capacity;
            this.price = price;
            this.view = view;
        }

        public int getRoomNo() { return roomNo; }
        public String getType() { return type; }
        public int getCapacity() { return capacity; }
        public double getPrice() { return price; }
        public String getView() { return view; }

        @Override
        public String toString() {
            return type + " (" + roomNo + ")";
        }
    }

    // --- Booking class ---
    public static class Booking implements Serializable {
        String name, email, passport;
        Room room;
        LocalDate checkIn, checkOut;
        int adults, children;
        boolean yacht, chef, helicopter;
        String specialRequests;
        double totalPrice;

        public Booking(String name, String email, String passport, Room room,
                       LocalDate checkIn, LocalDate checkOut,
                       int adults, int children,
                       boolean yacht, boolean chef, boolean helicopter,
                       String specialRequests, double totalPrice) {
            this.name = name;
            this.email = email;
            this.passport = passport;
            this.room = room;
            this.checkIn = checkIn;
            this.checkOut = checkOut;
            this.adults = adults;
            this.children = children;
            this.yacht = yacht;
            this.chef = chef;
            this.helicopter = helicopter;
            this.specialRequests = specialRequests;
            this.totalPrice = totalPrice;
        }
    }

    // --- Initialize UI ---
    @FXML
    public void initialize() {

        // ComboBox values
        adultsCombo.getItems().addAll(1,2,3,4,5);
        childrenCombo.getItems().addAll(0,1,2,3);

        // Table columns
        roomNoCol.setCellValueFactory(data -> new javafx.beans.property.SimpleIntegerProperty(data.getValue().getRoomNo()).asObject());
        roomTypeCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getType()));
        capacityCol.setCellValueFactory(data -> new javafx.beans.property.SimpleIntegerProperty(data.getValue().getCapacity()).asObject());
        priceCol.setCellValueFactory(data -> new javafx.beans.property.SimpleDoubleProperty(data.getValue().getPrice()).asObject());
        viewCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getView()));

        // Sample rooms
        List<Room> rooms = List.of(
                new Room(101,"Single",1,100,"City"),
                new Room(102,"Double",2,150,"Sea"),
                new Room(201,"Family",4,300,"Garden")
        );

        roomsTable.getItems().addAll(rooms);
        roomSelectCombo.getItems().addAll(rooms);
    }

    // --- Check availability ---
    @FXML
    void checkAvailabilityBtn(ActionEvent event) {
        if (checkInDate.getValue() == null || checkOutDate.getValue() == null) {
            availabilityStatus.setText("Select both check-in and check-out dates!");
            return;
        }
        if (checkOutDate.getValue().isBefore(checkInDate.getValue())) {
            availabilityStatus.setText("Check-out must be after check-in!");
            return;
        }
        if (roomSelectCombo.getValue() == null) {
            availabilityStatus.setText("Select a room!");
            return;
        }

        availabilityStatus.setText("Room available ✅");
    }

    // --- Confirm booking ---
    @FXML
    void confirmBookingBtn(ActionEvent event) {
        // Validate fields
        if (guestNameField.getText().isEmpty() ||
                emailField.getText().isEmpty() ||
                passportField.getText().isEmpty() ||
                roomSelectCombo.getValue() == null ||
                checkInDate.getValue() == null ||
                checkOutDate.getValue() == null ||
                adultsCombo.getValue() == null ||
                childrenCombo.getValue() == null) {

            confirmationMsg.setText("Please fill all required fields!");
            return;
        }

        // Validate dates
        LocalDate checkIn = checkInDate.getValue();
        LocalDate checkOut = checkOutDate.getValue();
        if (checkOut.isBefore(checkIn)) {
            confirmationMsg.setText("Check-out must be after check-in!");
            return;
        }

        Room selectedRoom = roomSelectCombo.getValue();

        // Calculate total price
        long days = checkOut.toEpochDay() - checkIn.toEpochDay();
        double totalPrice = selectedRoom.getPrice() * days;
        if (yachtRentalChk.isSelected()) totalPrice += 500;
        if (privateChefChk.isSelected()) totalPrice += 300;
        if (helicopterChk.isSelected()) totalPrice += 1000;

        // Create booking object
        Booking booking = new Booking(
                guestNameField.getText(),
                emailField.getText(),
                passportField.getText(),
                selectedRoom,
                checkIn,
                checkOut,
                adultsCombo.getValue(),
                childrenCombo.getValue(),
                yachtRentalChk.isSelected(),
                privateChefChk.isSelected(),
                helicopterChk.isSelected(),
                specialRequestsArea.getText(),
                totalPrice
        );

        // Save booking to binary file
        try {
            File file = new File("booking.bin");
            ObjectOutputStream oos;
            if (file.exists()) {
                oos = new AppendableObjectOutputStream(new FileOutputStream(file,true));
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(file));
            }
            oos.writeObject(booking);
            oos.close();

            confirmationMsg.setText("Booking Confirmed! Total: $" + totalPrice);
        } catch (Exception e) {
            confirmationMsg.setText("Error saving booking!");
            e.printStackTrace();
        }
    }

    // --- Scene switch back to dashboard ---
    @FXML
    void returnHomeBtn(ActionEvent actionEvent) throws IOException {
        Scene scene = ((Button) actionEvent.getSource()).getScene();
        Stage stage = (Stage) scene.getWindow();

        FXMLLoader scene2FxmlLoader = new FXMLLoader(guestDashboard.class.getResource("/com/eror/hotelmanagementgroup18/Rabeya/guestDashboard.fxml"));
        Scene scene2 = new Scene(scene2FxmlLoader.load());
        stage.setScene(scene2);
    }

    // --- Custom ObjectOutputStream to append objects ---
    static class AppendableObjectOutputStream extends ObjectOutputStream {
        public AppendableObjectOutputStream(OutputStream out) throws IOException { super(out); }
        @Override
        protected void writeStreamHeader() throws IOException { reset(); }
    }
}