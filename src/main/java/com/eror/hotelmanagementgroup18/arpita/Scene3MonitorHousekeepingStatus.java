package com.eror.hotelmanagementgroup18.arpita;

import com.eror.hotelmanagementgroup18.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;

public class Scene3MonitorHousekeepingStatus {

    @javafx.fxml.FXML
    private TableColumn<Room_Scene1, Integer> ColRoomNumber;

    @javafx.fxml.FXML
    private TableColumn<Room_Scene1, String> ColStatus;

    @javafx.fxml.FXML
    private TableView<Room_Scene1> TableView1;

    // ✅ ADD THESE (missing before)
    @javafx.fxml.FXML
    private RadioButton RBAll, RBClean, RBDirty, RBInProgress;

    @javafx.fxml.FXML
    private ToggleGroup statusGroup;

    @javafx.fxml.FXML
    public void initialize() {

        ColRoomNumber.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
        ColStatus.setCellValueFactory(new PropertyValueFactory<>("roomStatus"));

        // Set ToggleGroup
        RBAll.setToggleGroup(statusGroup);
        RBClean.setToggleGroup(statusGroup);
        RBDirty.setToggleGroup(statusGroup);
        RBInProgress.setToggleGroup(statusGroup);

        RBAll.setSelected(true);

        loadTableData();
    }

    // Load all data
    private void loadTableData() {

        TableView1.getItems().clear();

        try (ObjectInputStream stream =
                     new ObjectInputStream(new FileInputStream("room.bin"))) {

            while (true) {
                Room_Scene1 r = (Room_Scene1) stream.readObject();
                TableView1.getItems().add(r);
            }

        } catch (EOFException e) {
            // normal
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Refresh button
    @javafx.fxml.FXML
    public void RefreshOA(ActionEvent actionEvent) {
        loadTableData();
    }

    // Filter by status
    @javafx.fxml.FXML
    public void RBStatusOA(ActionEvent actionEvent) {

        TableView1.getItems().clear();

        String selectedStatus = "";

        if (RBAll.isSelected()) {
            selectedStatus = "ALL";
        } else if (RBClean.isSelected()) {
            selectedStatus = "Clean";
        } else if (RBDirty.isSelected()) {
            selectedStatus = "Dirty";
        } else if (RBInProgress.isSelected()) {
            selectedStatus = "In Progress";
        }

        try (ObjectInputStream stream =
                     new ObjectInputStream(new FileInputStream("room.bin"))) {

            while (true) {
                Room_Scene1 r = (Room_Scene1) stream.readObject();

                if (selectedStatus.equals("ALL") ||
                        r.getRoomStatus().equals(selectedStatus)) {

                    TableView1.getItems().add(r);
                }
            }

        } catch (EOFException e) {
            // end
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Navigation
    public void next(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                HelloApplication.class.getResource("Scene-4-ApproveGuestCheck-In.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }

    public void back(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                HelloApplication.class.getResource("Scene-2_AssignRoomstoGuests.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }
}