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
import java.net.URL;

public class Login {
    @FXML private PasswordField passwordTextField;
    @FXML private Label errorLabel;
    @FXML private TextField usernameTextField;

    // Credentials
    private final String GuestID = "Guest";
    private final String Guestpassword = "1234";
    private final String ReceptionistID = "Receptionist";
    private final String Receptionistpassword = "1234";

//    arpita
//    private final String GuestID = "Guest";
//    private final String Guestpassword = "1234";
//    private final String ReceptionistID = "Receptionist";
//    private final String Receptionistpassword = "1234";

//    urmi
//    private final String GuestID = "Guest";
//    private final String Guestpassword = "1234";
//    private final String ReceptionistID = "Receptionist";
//    private final String Receptionistpassword = "1234";

    // Sumon
    private final String AdminDashID = "admin";
    private final String AdminDashPass = "1234";
    private final String SecurityDashID = "security";
    private final String SecurityDashPass = "1234";



    @FXML
    public void LoginOnActionButton(ActionEvent actionEvent) throws IOException {
        String username = usernameTextField.getText().trim();
        String password = passwordTextField.getText().trim();

        // --- Rabeya ---
        if (username.equals(GuestID) && password.equals(Guestpassword)) {
            loadDashboard("/com/eror/hotelmanagementgroup18/Rabeya/guestDashboard.fxml", "Guest Dashboard");
        }
        else if (username.equals(ReceptionistID) && password.equals(Receptionistpassword)) {
            loadDashboard("/com/eror/hotelmanagementgroup18/Rabeya/ReceptionistDashboard.fxml", "Receptionist Dashboard");
        }

        // --- Arpita
        // else if (username.equals(EventCoordinatorID) && password.equals(EventCoordinatorpassword)) {
        //     loadDashboard("/com/eror/hotelmanagementgroup18/Arpita/EventCdashbord.fxml", "Event Dashboard");
        // }

        // --- Urmi
        // else if (username.equals(DirectorGeneralID) && password.equals(DirectorGeneralpassword)) {
        //     loadDashboard("/com/eror/hotelmanagementgroup18/urmi/DirectorGdashboard.fxml", "Director Dashboard");
        // }

        // Sumon
        else if (username.equals(AdminDashID) && password.equals(AdminDashPass)) {
            loadDashboard("/com/eror/hotelmanagementgroup18/Sumon/Admin_deshboard.fxml", "Admin Dashboard");
        }
        else if (username.equals(SecurityDashID) && password.equals(SecurityDashPass)) {
            loadDashboard("/com/eror/hotelmanagementgroup18/Sumon/security_dashboard.fxml", "Security Dashboard");
        }

        else {
            errorLabel.setText("Incorrect username or password. Please try again.");
        }
    }

    private void loadDashboard(String fxmlPath, String title) throws IOException {
        URL fxmlLocation = getClass().getResource(fxmlPath);
        if (fxmlLocation == null) {
            errorLabel.setText("Error: FXML file not found at " + fxmlPath);
            return;
        }
        Parent root = FXMLLoader.load(fxmlLocation);
        Stage stage = (Stage) usernameTextField.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle(title);
        stage.show();
    }
}