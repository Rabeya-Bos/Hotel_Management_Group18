package com.eror.hotelmanagementgroup18.arpita;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;

public class Scene3MonitorHousekeepingStatus
{
    @javafx.fxml.FXML
    private TableColumn<Room_Scene1,Integer> ColRoomNumber;
    @javafx.fxml.FXML
    private TextField TXTRoomNo;
    @javafx.fxml.FXML
    private TextField TXTStatus;
    @javafx.fxml.FXML
    private TableColumn<Room_Scene1,String> ColStatus;
    @javafx.fxml.FXML
    private TableView<Room_Scene1> TableView1;

    @javafx.fxml.FXML
    private RadioButton RBAll;
    @javafx.fxml.FXML
    private RadioButton RBClean;
    @javafx.fxml.FXML
    private RadioButton RBDirty;
    @javafx.fxml.FXML
    private RadioButton RBInProgress;

    @javafx.fxml.FXML
    private ToggleGroup statusGroup;

    private ObservableList<Room_Scene1> roomList = FXCollections.observableArrayList();
    private static final String ROOM_FILE = "rooms.txt";

    @javafx.fxml.FXML
    public void initialize() {
        ColRoomNumber.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
        ColStatus.setCellValueFactory(new PropertyValueFactory<>("roomStatus"));

        RBAll.setToggleGroup(statusGroup);
        RBClean.setToggleGroup(statusGroup);
        RBDirty.setToggleGroup(statusGroup);
        RBInProgress.setToggleGroup(statusGroup);

        RBAll.setSelected(true);

        // ✔ Load data initially
        loadTableData();
    }

    //  Load data from file
    private void loadTableData() {
        TableView1.getItems().clear();

        try (ObjectInputStream stream =
                     new ObjectInputStream(new FileInputStream("room.bin"))) {

            while (true) {
                Room_Scene1 r = (Room_Scene1) stream.readObject();
                TableView1.getItems().add(r);
            }

        } catch (EOFException e) {
            // file end
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @javafx.fxml.FXML
    public void NextOA(ActionEvent actionEvent) {
        if (TXTRoomNo.getText().isEmpty() || TXTStatus.getText().isEmpty()) {
            return;
        }

        int roomNo = Integer.parseInt(TXTRoomNo.getText());
        String newStatus = TXTStatus.getText();

        File inputFile = new File("room.bin");
        File tempFile = new File("temp.bin");

        try (
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(inputFile));
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(tempFile))
        ) {

            while (true) {
                Room_Scene1 r = (Room_Scene1) in.readObject();

                if (r.getRoomNo() == roomNo) {
                    r.setRoomStatus(newStatus); // ✔ update status
                }

                out.writeObject(r);
            }

        } catch (EOFException e) {
            // done
        } catch (Exception e) {
            e.printStackTrace();
        }

        // ✔ replace file
        inputFile.delete();
        tempFile.renameTo(inputFile);

        // ✔ refresh table
        loadTableData();

        // ✔ clear fields
        TXTRoomNo.clear();
        TXTStatus.clear();
    }

    @javafx.fxml.FXML
    public void RefreshOA(ActionEvent actionEvent) {
        loadTableData();
    }

    @javafx.fxml.FXML
    public void BackOA(ActionEvent actionEvent) {
        System.out.println("Back button pressed");
    }

    @javafx.fxml.FXML
    public void RBSatusOA(ActionEvent actionEvent) {
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
}