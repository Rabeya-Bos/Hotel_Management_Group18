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

// baki member
//    //arpita
//    private final String EventCoordinatorID = "EventCoordinator";
//    private final String EventCoordinatorpassword = "EventC";
//    private final String CricketTraineeID = "CricketTrainee";
//    private final String CricketTraineepassword = "CricketT";
//    //urmi
//    private final String DirectorGeneralID = "DirectorGeneral";
//    private final String DirectorGeneralpassword = "DirectorG";
//    private final String CricketCoachID = "Cricket Coach";
//    private final String CricketCoachpassword = "Cricket Coach";
//    //Sumon
    private final String AdminDashID = "admin";
    private final String AdminDashPass = "1234";
    private final String SecurityDashID = "security";
    private final String SecurityDashPass = "1234";


//others user password

    @FXML
    public void LoginOnActionButton(ActionEvent actionEvent) throws IOException {
        String username = usernameTextField.getText().trim();
        String password = passwordTextField.getText().trim();
// Rabeya
        if (username.equals(GuestID) && password.equals(Guestpassword)) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/eror/hotelmanagementgroup18/Rabeya/guestDashboard.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) usernameTextField.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } else if (username.equals(ReceptionistID) && password.equals(Receptionistpassword)) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/eror/hotelmanagementgroup18/Rabeya/ReceptionistDashboard.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) usernameTextField.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
//
//            //Arpits
//        }   else if (username.equals(EventCoordinatorID) && password.equals(EventCoordinatorpassword)) {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/eror/hotelmanagementgroup18/Arpita/EventCdashbord.fxml"));
//            Parent root = loader.load();
//            Stage stage = (Stage) usernameTextField.getScene().getWindow();
//            stage.setScene(new Scene(root));
//            stage.show();
//        }else if (username.equals(CricketTraineeID) && password.equals(CricketTraineepassword)) {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/eror/hotelmanagementgroup18/Arpita/CTraineedashboard.fxml"));
//            Parent root = loader.load();
//            Stage stage = (Stage) usernameTextField.getScene().getWindow();
//            stage.setScene(new Scene(root));
//            stage.show();
//
//            //urmi
//        }else if (username.equals(DirectorGeneralID) && password.equals(DirectorGeneralpassword)) {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/eror/hotelmanagementgroup18/urmi/DirectorGdashboard.fxml"));
//            Parent root = loader.load();
//            Stage stage = (Stage) usernameTextField.getScene().getWindow();
//            stage.setScene(new Scene(root));
//            stage.show();
//        }else if (username.equals(CricketCoachID) && password.equals(CricketCoachpassword)) {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/eror/hotelmanagementgroup18/urmi/CricketCoachDashboard.fxml"));
//            Parent root = loader.load();
//            Stage stage = (Stage) usernameTextField.getScene().getWindow();
//            stage.setScene(new Scene(root));
//            stage.show();
// Sumon (Admin and Security Dashboard)
        } else if (username.equals(AdminDashID) && password.equals(AdminDashPass)) {
            // Admin Dashboard load korbe
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/eror/hotelmanagementgroup18/Sumon/Admindashboard.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) usernameTextField.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Admin Dashboard");
            stage.show();

        } else if (username.equals(SecurityDashID) && password.equals(SecurityDashPass)) {
            // Security Dashboard load korbe
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/eror/hotelmanagementgroup18/Sumon/SecurityDashboard.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) usernameTextField.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Security Dashboard");
            stage.show();

            //others path
        } else {
            errorLabel.setText("Incorrect username or password. Please try again.");
        }
    }

}