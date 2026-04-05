package com.eror.hotelmanagementgroup18;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Login {
    @javafx.fxml.FXML
    private PasswordField passwordTextField;
    @javafx.fxml.FXML
    private Label errorLabel;
    @javafx.fxml.FXML
    private TextField usernameTextField;
    //Rabeya
    private final String GuestID = "Guest";
    private final String Guestpassword = "1234";
    private final String ReceptionistID = "Receptionist";
    private final String Receptionistpassword = "1234";

// baki members


//others user password

    @FXML
    public void LoginOnActionButton(ActionEvent actionEvent) throws IOException {
        String username = usernameTextField.getText().trim();
        String password = passwordTextField.getText().trim();
// Rabeya
        if (username.equals(GuestID) && password.equals(Guestpassword)) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demo/Rabeya/guestDashboard.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) usernameTextField.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } else if (username.equals(ReceptionistID) && password.equals(Receptionistpassword)) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demo/Rabeya/ReceptionistDashboard.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) usernameTextField.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } else {
            errorLabel.setText("Incorrect username or password. Please try again.");
        }
    }

}