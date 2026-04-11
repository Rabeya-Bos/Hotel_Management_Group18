package com.eror.hotelmanagementgroup18.urmi;

import com.eror.hotelmanagementgroup18.HelloApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Goal_3_lowStockController
{
    @javafx.fxml.FXML
    private TableColumn<LowStock,String> thresholdCol;
    @javafx.fxml.FXML
    private TableView<LowStock> stockTV;
    @javafx.fxml.FXML
    private TextField thresholdTF;
    @javafx.fxml.FXML
    private TableColumn<LowStock,Integer> currentStockCol;
    @javafx.fxml.FXML
    private TableColumn<LowStock,Integer> itemCol;




    @javafx.fxml.FXML
    public void initialize() {
        itemCol.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        currentStockCol.setCellValueFactory(new PropertyValueFactory<>("currentStock"));
        thresholdCol.setCellValueFactory(new PropertyValueFactory<>("threshold"));



    }

    @javafx.fxml.FXML
    public void setThresholdButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backButtonOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Goal_2_stockUsage.fxml"));
        Scene scene = new Scene((Parent) fxmlLoader.load());
        Button b = (Button) actionEvent.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void nextButtonOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Goal_4_inventoryReport.fxml"));
        Scene scene = new Scene((Parent) fxmlLoader.load());
        Button b = (Button) actionEvent.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        stage.setScene(scene);
    }
}