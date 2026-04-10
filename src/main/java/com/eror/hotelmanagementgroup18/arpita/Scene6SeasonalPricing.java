package com.eror.hotelmanagementgroup18.arpita;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;

public class Scene6SeasonalPricing {

    @javafx.fxml.FXML
    private Label LVLResult;
    @javafx.fxml.FXML
    private ComboBox<String> CmbSeason;
    @javafx.fxml.FXML
    private TableColumn ColEndDate;
    @javafx.fxml.FXML
    private TextField TXTPrice;
    @javafx.fxml.FXML
    private TableColumn ColStartDate;
    @javafx.fxml.FXML
    private TableColumn ColPrice;
    @javafx.fxml.FXML
    private TableView TableView1;

    @javafx.fxml.FXML
    public void initialize() {

        if (CmbSeason != null) {
            CmbSeason.getItems().addAll("Summer", "Winter", "Spring", "Autumn", "Holiday Season");
        }

        if (LVLResult != null) {
            LVLResult.setText("Pricing System Ready");
        }
    }

    @javafx.fxml.FXML
    public void SaveOA(ActionEvent actionEvent) {
        if (LVLResult != null) {
            LVLResult.setText("Data Saved Successfully!");
        }
    }

    @javafx.fxml.FXML
    public void BackOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/eror/hotelmanagementgroup18/arpita/Scene-5-LateCheck-OutRequests.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void UpdatePriceOA(ActionEvent actionEvent) {

        if (LVLResult != null && CmbSeason.getValue() != null) {
            LVLResult.setText("Price updated for " + CmbSeason.getValue());
        } else if (LVLResult != null) {
            LVLResult.setText("Error: Please select a season!");
        }
    }

    @javafx.fxml.FXML
    public void NextOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/eror/hotelmanagementgroup18/arpita/Scene-7-Apply Discount.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }
}