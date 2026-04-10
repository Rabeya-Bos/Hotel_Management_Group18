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

public class Scene1ManageRoomAvailability {

    @javafx.fxml.FXML
    private TableColumn<Room_Scene1, String> ColRoomType;
    @javafx.fxml.FXML
    private TableColumn<Room_Scene1, Integer> ColRoomNO;
    @javafx.fxml.FXML
    private TableColumn<Room_Scene1, String> ColRoomStatus;

    @javafx.fxml.FXML
    private TextField TXTRoomStatus, TXTRoomType, TXTRoomNo;
    @javafx.fxml.FXML
    private TableView<Room_Scene1> TableView_1;
    @javafx.fxml.FXML
    private Label ResultLVL;
    @javafx.fxml.FXML
    private ComboBox<String> CmbAvailabilty;

    private ObservableList<Room_Scene1> roomList = FXCollections.observableArrayList();


    public Scene1ManageRoomAvailability() {
    }

    @javafx.fxml.FXML
    public void initialize() {
        CmbAvailabilty.getItems().addAll("Available", "Occupied", "Maintenance");

        ColRoomNO.setCellValueFactory(new PropertyValueFactory<>("roomNo"));
        ColRoomType.setCellValueFactory(new PropertyValueFactory<>("roomType"));
        ColRoomStatus.setCellValueFactory(new PropertyValueFactory<>("roomStatus"));

        TableView_1.setItems(roomList);
        loadInitialData();
    }

    private void loadInitialData() {
        File file = new File("Room_Availability.dat");
        if (!file.exists()) return;
        try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                Room_Scene1 t = (Room_Scene1) stream.readObject();
                roomList.add(t);
            }
        } catch (Exception e) {
            // End of file or error
        }
    }

    @javafx.fxml.FXML
    public void UpdateStatusOA(ActionEvent actionEvent) {
        Room_Scene1 selectedRoom = TableView_1.getSelectionModel().getSelectedItem();
        String newStatus = CmbAvailabilty.getValue();

        if (selectedRoom == null || newStatus == null) {
            ResultLVL.setText("Please select room and status!");
            return;
        }

        selectedRoom.setRoomStatus(newStatus);
        TableView_1.refresh();
        ResultLVL.setText("Status updated!");
    }

    @javafx.fxml.FXML
    public void SaveOA(ActionEvent actionEvent) {
        try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("Room_Availability.dat"))) {
            for (Room_Scene1 r : roomList) {
                stream.writeObject(r);
            }
            ResultLVL.setText("Data saved successfully!");
        } catch (IOException e) {
            ResultLVL.setText("Error saving file!");
        }
    }


    @javafx.fxml.FXML
    public void BackOA(ActionEvent actionEvent) throws IOException {

        String path = "/com/eror/hotelmanagementgroup18/arpita/Goal3-LostAndFound.fxml";
        switchScene(path, actionEvent);
    }

    @javafx.fxml.FXML
    public void NextOA(ActionEvent actionEvent) throws IOException {
        String path = "/com/eror/hotelmanagementgroup18/arpita/Scene-2_AssignRoomstoGuests.fxml";
        switchScene(path, actionEvent);
    }

    private void switchScene(String path, ActionEvent event) throws IOException {
        if (getClass().getResource(path) == null) {
            System.out.println("Path not found: " + path);
            return;
        }
        FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }
}