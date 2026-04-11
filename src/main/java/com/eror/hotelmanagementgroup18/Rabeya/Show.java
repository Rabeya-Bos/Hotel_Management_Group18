package com.eror.hotelmanagementgroup18.Rabeya;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Show {

    @FXML private TableView<ShowModel> tableView;

    @FXML private TableColumn<ShowModel, String> nameCol;
    @FXML private TableColumn<ShowModel, String> emailCol;
    @FXML private TableColumn<ShowModel, String> roomCol;
    @FXML private TableColumn<ShowModel, String> passportCol;

    @FXML private TableColumn<ShowModel, String> checkInCol;
    @FXML private TableColumn<ShowModel, String> checkOutCol;

    @FXML private TableColumn<ShowModel, String> adultsCol;
    @FXML private TableColumn<ShowModel, String> childrenCol;

    @FXML
    public void initialize() {

        nameCol.setCellValueFactory(d -> new javafx.beans.property.SimpleStringProperty(d.getValue().getName()));
        emailCol.setCellValueFactory(d -> new javafx.beans.property.SimpleStringProperty(d.getValue().getEmail()));
        roomCol.setCellValueFactory(d -> new javafx.beans.property.SimpleStringProperty(d.getValue().getRoomType()));
        passportCol.setCellValueFactory(d -> new javafx.beans.property.SimpleStringProperty(d.getValue().getPassport()));

        checkInCol.setCellValueFactory(d -> new javafx.beans.property.SimpleStringProperty(d.getValue().getCheckIn()));
        checkOutCol.setCellValueFactory(d -> new javafx.beans.property.SimpleStringProperty(d.getValue().getCheckOut()));

        adultsCol.setCellValueFactory(d -> new javafx.beans.property.SimpleStringProperty(d.getValue().getAdults()));
        childrenCol.setCellValueFactory(d -> new javafx.beans.property.SimpleStringProperty(d.getValue().getChildren()));
    }

    @FXML
    public void LoadButtonOA() {

        ObservableList<ShowModel> list = FXCollections.observableArrayList();

        try {
            ObjectInputStream ois =
                    new ObjectInputStream(new FileInputStream("guestData.bin"));

            while (true) {
                try {
                    list.add((ShowModel) ois.readObject());
                } catch (EOFException e) {
                    break;
                }
            }

            ois.close();

        } catch (Exception e) {
            System.out.println("No data file found!");
        }

        tableView.setItems(list);
    }

    @FXML
    public void BackButtonOA(ActionEvent event) {
        try {
            javafx.fxml.FXMLLoader loader =
                    new javafx.fxml.FXMLLoader(
                            getClass().getResource("guest1.fxml")
                    );

            javafx.scene.Scene scene = new javafx.scene.Scene(loader.load());

            javafx.stage.Stage stage =
                    (javafx.stage.Stage) ((Button) event.getSource())
                            .getScene().getWindow();

            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}