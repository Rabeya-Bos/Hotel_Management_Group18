package com.eror.hotelmanagementgroup18.Rabeya;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class guest5 {

    @FXML
    private TableColumn<?, ?> amountCol;

    @FXML
    private TableView<?> billTable;

    @FXML
    private TextField cardNumberField;

    @FXML
    private PasswordField cvvField;

    @FXML
    private TableColumn<?, ?> descriptionCol;

    @FXML
    private DatePicker expiryDate;

    @FXML
    private TableColumn<?, ?> itemCol;

    @FXML
    private Label msgLabel;

    @FXML
    private ComboBox<?> paymentMethodCombo;

    @FXML
    private Label subtotalLabel;

    @FXML
    private Label taxLabel;

    @FXML
    private Label totalLabel;

    @FXML
    void expressCheckoutBtn(ActionEvent event) {

    }

    @FXML
    void homeBtn(ActionEvent actionEvent) throws IOException {

        try {
            Scene scene = ((Button) actionEvent.getSource()).getScene();
            Stage stage = (Stage) scene.getWindow();

            FXMLLoader scene2FxmlLoader = new FXMLLoader(guestDashboard.class.getResource("/com/eror/hotelmanagementgroup18/Rabeya/guestDashboard.fxml"));
            Scene scene2 = new Scene(scene2FxmlLoader.load());
            stage.setScene(scene2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void payNowBtn(ActionEvent event) {

    }

}
