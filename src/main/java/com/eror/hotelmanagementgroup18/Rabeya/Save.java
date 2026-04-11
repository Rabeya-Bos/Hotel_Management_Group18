package com.eror.hotelmanagementgroup18.Rabeya;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Save {

    @FXML
    private TableView<ServiceRequest> tableview;

    @FXML
    private TableColumn<ServiceRequest, String> colservicetime;

    @FXML
    private TableColumn<ServiceRequest, String> Colphonenumber;

    @FXML
    private TableColumn<ServiceRequest, String> colservicetype;

    @FXML
    private TableColumn<ServiceRequest, String> Colguestname;

    @FXML
    private TableColumn<ServiceRequest, String> colservicedate;

    // ---------- INITIALIZE ----------
    @FXML
    public void initialize() {

        colservicetype.setCellValueFactory(d ->
                new javafx.beans.property.SimpleStringProperty(d.getValue().getServiceType()));

        colservicetime.setCellValueFactory(d ->
                new javafx.beans.property.SimpleStringProperty(d.getValue().getServiceTime()));

        colservicedate.setCellValueFactory(d ->
                new javafx.beans.property.SimpleStringProperty(d.getValue().getServiceDate()));

        Colguestname.setCellValueFactory(d ->
                new javafx.beans.property.SimpleStringProperty(d.getValue().getInstructions()));

        Colphonenumber.setCellValueFactory(d ->
                new javafx.beans.property.SimpleStringProperty(d.getValue().getAdditionalDetails()));
    }

    // ---------- LOAD DATA ----------
    @FXML
    public void LoadButtonOA(ActionEvent event) {

        ObservableList<ServiceRequest> list = FXCollections.observableArrayList();

        try {
            ObjectInputStream ois =
                    new ObjectInputStream(new FileInputStream("serviceData.bin"));

            while (true) {
                try {
                    list.add((ServiceRequest) ois.readObject());
                } catch (EOFException e) {
                    break;
                }
            }

            ois.close();

        } catch (Exception e) {
            System.out.println("No data file found!");
        }

        tableview.setItems(list);
    }

    // ---------- BACK BUTTON ----------
    @FXML
    public void BackButtonOA(ActionEvent event) {
        try {
            javafx.fxml.FXMLLoader loader =
                    new javafx.fxml.FXMLLoader(
                            getClass().getResource("guest2.fxml")
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