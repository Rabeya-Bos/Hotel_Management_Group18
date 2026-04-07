package com.eror.hotelmanagementgroup18.arpita;

import com.eror.hotelmanagementgroup18.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;

public class Scene2AssignRoomsToGuests {

    @javafx.fxml.FXML
    private TableColumn<GuestRoom_Scene2, Integer> ColBookingId;
    @javafx.fxml.FXML
    private TableColumn<GuestRoom_Scene2, String> ColGuestName;
    @javafx.fxml.FXML
    private TableColumn<GuestRoom_Scene2, String> ColRoomType;

    @javafx.fxml.FXML
    private TextField TXTBookingID;
    @javafx.fxml.FXML
    private TextField TXTGuestName;
    @javafx.fxml.FXML
    private Label LVLResult;
    @javafx.fxml.FXML
    private TableView<GuestRoom_Scene2> TableView1;
    @javafx.fxml.FXML
    private ComboBox<String> CmbRoomType;

    @javafx.fxml.FXML
    public void initialize() {
        ColBookingId.setCellValueFactory(new PropertyValueFactory<>("bookingId"));
        ColGuestName.setCellValueFactory(new PropertyValueFactory<>("guestName"));
        ColRoomType.setCellValueFactory(new PropertyValueFactory<>("roomType"));

        CmbRoomType.getItems().addAll("Single", "Double", "Suite");
    }

    @javafx.fxml.FXML
    public void AssignRoomOA(ActionEvent actionEvent) {

        String bookingIdText = TXTBookingID.getText();
        String guestName = TXTGuestName.getText();
        String roomType = CmbRoomType.getValue();

        if (bookingIdText.isEmpty() || guestName.isEmpty() || roomType == null) {
            LVLResult.setText("Fill all fields!");
            return;
        }

        int bookingId = Integer.parseInt(bookingIdText);

        //Get available room
        Room_Scene1 room = AvailableRoomOA();

        if (room == null) {
            LVLResult.setText("No available room!");
            return;
        }

        // Mark room occupied
        room.setRoomStatus("Occupied");

        //  Update file with this room
        UpdateRoomFile(room);

        //  Add to table
        GuestRoom_Scene2 gr = new GuestRoom_Scene2(bookingId, guestName, roomType);
        TableView1.getItems().add(gr);

        LVLResult.setText("Room Assigned Successfully!");
    }

    //  FIXED METHOD (no ActionEvent, correct return type)
    @javafx.fxml.FXML
    public Room_Scene1 AvailableRoomOA() {

        try (ObjectInputStream stream =
                     new ObjectInputStream(new FileInputStream("room.bin"))) {

            while (true) {
                Room_Scene1 r = (Room_Scene1) stream.readObject();

                String type = CmbRoomType.getValue();

                if (r.getRoomType().equals(type) &&
                        r.getRoomStatus().equals("Available")) {
                    return r;
                }
            }

        } catch (EOFException e) {
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //  FIXED METHOD (takes Room object)
    @javafx.fxml.FXML
    public void UpdateRoomFile(Room_Scene1 updatedRoom) {

        File inputFile = new File("room.bin");
        File tempFile = new File("temp.bin");

        try (
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(inputFile));
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(tempFile))
        ) {

            while (true) {
                Room_Scene1 r = (Room_Scene1) in.readObject();

                // Replace updated room
                if (r.getRoomNo() == updatedRoom.getRoomNo()) {
                    out.writeObject(updatedRoom);
                } else {
                    out.writeObject(r);
                }
            }

        } catch (EOFException e) {
            // finished reading
        } catch (Exception e) {
            e.printStackTrace();
        }

        //  Replace file
        inputFile.delete();
        tempFile.renameTo(inputFile);
    }

    @javafx.fxml.FXML
    public void next(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Scene-3-Monitor Housekeeping Status.fxml.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        Button b = (Button) actionEvent.getSource();
        Stage stage = (Stage) b.getScene().getWindow();

        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void back(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Scene-1-Manage Room Availability.fxml.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        Button b = (Button) actionEvent.getSource();
        Stage stage = (Stage) b.getScene().getWindow();

        stage.setScene(scene);
    }
}