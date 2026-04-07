package com.eror.hotelmanagementgroup18.Rabeya;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class guest3 {

    @FXML
    private TableColumn<?, ?> cartItemCol;

    @FXML
    private TableColumn<?, ?> cartPriceCol;

    @FXML
    private TableColumn<?, ?> cartQtyCol;

    @FXML
    private TableView<?> cartTable;

    @FXML
    private TableColumn<?, ?> cartTotalCol;

    @FXML
    private Label cartTotalLabel;

    @FXML
    private ComboBox<?> deliveryTimeCombo;

    @FXML
    private TableColumn<?, ?> itemCategoryCol;

    @FXML
    private TableColumn<?, ?> itemDescCol;

    @FXML
    private TableColumn<?, ?> itemIdCol;

    @FXML
    private TableColumn<?, ?> itemNameCol;

    @FXML
    private TableColumn<?, ?> itemPriceCol;

    @FXML
    private ComboBox<?> itemSelectCombo;

    @FXML
    private ComboBox<?> mealCategoryCombo;

    @FXML
    private TableView<?> menuTable;

    @FXML
    private Label orderConfirmationMsg;

    @FXML
    private ComboBox<?> quantityCombo;

    @FXML
    private TextArea specialNotesArea;

    @FXML
    void addToCartBtn(ActionEvent event) {

    }

    @FXML
    void placeOrderBtn(ActionEvent event) {

    }

    @FXML
    void returnHomeBtn(ActionEvent actionEvent) throws IOException {

        try {
            Scene scene = ((Button) actionEvent.getSource()).getScene();
            Stage stage = (Stage) scene.getWindow();

            FXMLLoader scene2FxmlLoader = new FXMLLoader(guestDashboard.class.getResource("/com/example/demo/Rabeya/guestDashboard.fxml"));
            Scene scene2 = new Scene(scene2FxmlLoader.load());
            stage.setScene(scene2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
