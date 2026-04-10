package com.eror.hotelmanagementgroup18.arpita;

import com.eror.hotelmanagementgroup18.HelloApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.text.BreakIterator;

public class Scene1ManageRoomAvailability
{
    @javafx.fxml.FXML
    private TableColumn<Scene1ManageRoomAvailability,String> ColRoomType;
    @javafx.fxml.FXML
    private TextField TXTRoomStatus;
    @javafx.fxml.FXML
    private TextField TXTRoomType;
    @javafx.fxml.FXML
    private TableColumn<Scene1ManageRoomAvailability,Integer> ColRoomNO;
    @javafx.fxml.FXML
    private TableColumn<Scene1ManageRoomAvailability,String>ColRoomStatus;
    @javafx.fxml.FXML
    private TextField TXTRoomNo;
    @javafx.fxml.FXML
    private TableView <Room_Scene1>TableView_1;
    @javafx.fxml.FXML
    private Label ResultLVL;
    @javafx.fxml.FXML
    private ComboBox <String>CmbAvailabilty;

    private ObservableList<Scene1ManageRoomAvailability> roomList = FXCollections.observableArrayList();

    public Scene1ManageRoomAvailability(int i, String aDouble, String occupied) {
    }


    @javafx.fxml.FXML
    public void initialize() {
        CmbAvailabilty.getItems().addAll("Available", "Occupied", "Maintenance");

        roomList.add(new Scene1ManageRoomAvailability(101, "Single", "Available"));
        roomList.add(new Scene1ManageRoomAvailability(102, "Double", "Occupied"));
        roomList.add(new Scene1ManageRoomAvailability(103, "Suite", "Maintenance"));

        ColRoomNO.setCellValueFactory(new PropertyValueFactory<>("roomNo"));
        ColRoomType.setCellValueFactory(new PropertyValueFactory<>("roomType"));
        ColRoomStatus.setCellValueFactory(new PropertyValueFactory<>("roomStatus"));


        try (ObjectInputStream stream = new ObjectInputStream(
                new FileInputStream("Room_Availability.dat")
        )) {
            TableView_1.getItems().clear(); // clear old data first

            while (true) {
                Room_Scene1 t = (Room_Scene1) stream.readObject();
                TableView_1.getItems().add(t);
            }

        } catch (EOFException e) {
            // End of file reached (normal case)
            ResultLVL.setText("Data loaded successfully!");

        } catch (IOException e) {
            ResultLVL.setText("Could not load data from file!");

        } catch (ClassNotFoundException e) {
            ResultLVL.setText("Invalid data in the file!");
        }
    }

    @javafx.fxml.FXML
    public void UpdateStatusOA(ActionEvent actionEvent) {
        Room_Scene1 selectedRoom = TableView_1.getSelectionModel().getSelectedItem();
        String newStatus = CmbAvailabilty.getValue();

        if (selectedRoom == null) {
            ResultLVL.setText("Select a room first!");
            return;
        }

        if (newStatus == null) {
            ResultLVL.setText("Select a status!");
            return;
        }

        selectedRoom.setRoomStatus(newStatus);
        TableView_1.refresh();

        ResultLVL.setText("Status updated!");

    }


    @javafx.fxml.FXML
    public void SaveOA(ActionEvent actionEvent) {
        try (ObjectOutputStream stream =
                     new ObjectOutputStream(new FileOutputStream("room.bin"))) {

            for (Room_Scene1 r : TableView_1.getItems()) {
                stream.writeObject(r);
            }

            ResultLVL.setText("Saved successfully!");

        } catch (IOException e) {
            ResultLVL.setText("Error saving file!");
        }
    }




    @javafx.fxml.FXML
    public void NextOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Scene-2_AssignRoomstoGuests.fxml.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        Button b = (Button) actionEvent.getSource();
        Stage stage = (Stage) b.getScene().getWindow();

        stage.setScene(scene);
    }
}