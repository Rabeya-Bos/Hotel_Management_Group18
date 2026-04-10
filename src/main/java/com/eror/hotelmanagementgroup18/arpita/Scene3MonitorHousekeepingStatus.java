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

public class Scene3MonitorHousekeepingStatus {

    @javafx.fxml.FXML
    private TableColumn<Housekeeping, String> ColRoomNumber;
    @javafx.fxml.FXML
    private TableColumn<Housekeeping, String> ColStatus;
    @javafx.fxml.FXML
    private TableView<Housekeeping> TableView1;
    @javafx.fxml.FXML
    private TextField TXTRoomNo;
    @javafx.fxml.FXML
    private TextField TXTStatus;


    private ObservableList<Housekeeping> housekeepingList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {

        ColRoomNumber.setCellValueFactory(new PropertyValueFactory<>("roomNo"));
        ColStatus.setCellValueFactory(new PropertyValueFactory<>("status"));


        TableView1.setItems(housekeepingList);
    }

    @javafx.fxml.FXML
    public void RBSatusOA(ActionEvent actionEvent) {

        String room = TXTRoomNo.getText();
        String status = TXTStatus.getText();

        if (!room.isEmpty() && !status.isEmpty()) {
            housekeepingList.add(new Housekeeping(room, status));
            TXTRoomNo.clear();
            TXTStatus.clear();
        }
    }

    @javafx.fxml.FXML
    public void RefreshOA(ActionEvent actionEvent) {
        TableView1.refresh();
    }

    @javafx.fxml.FXML
    public void BackOA(ActionEvent actionEvent) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/eror/hotelmanagementgroup18/arpita/Scene-2_AssignRoomstoGuests.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void NextOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/eror/hotelmanagementgroup18/arpita/Scene- 4-ApproveGuestCheck-In.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);

    }
}