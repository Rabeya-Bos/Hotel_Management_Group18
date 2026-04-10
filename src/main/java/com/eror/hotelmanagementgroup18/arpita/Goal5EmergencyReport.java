package com.eror.hotelmanagementgroup18.arpita;

import com.eror.hotelmanagementgroup18.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;

public class Goal5EmergencyReport {

    @javafx.fxml.FXML
    private TextField TXTLocation;
    @javafx.fxml.FXML
    private DatePicker DateBox;
    @javafx.fxml.FXML
    private TextArea TextArea1;
    @javafx.fxml.FXML
    private ComboBox<String> CmbEmmergencyType;
    @javafx.fxml.FXML
    private ComboBox<String> CmbSecurityLevel;
    @javafx.fxml.FXML
    private RadioButton RBStatus;
    @javafx.fxml.FXML
    private CheckBox CBAditionalFlags;

    @javafx.fxml.FXML
    public void initialize() {

        CmbEmmergencyType.getItems().addAll(
                "Fire", "Medical", "Security", "Technical"
        );

        CmbSecurityLevel.getItems().addAll(
                "Low", "Medium", "High"
        );
    }

    //  SUBMIT
    @javafx.fxml.FXML
    public void SubmitReportOA(ActionEvent actionEvent) {

        String location = TXTLocation.getText();
        LocalDate date = DateBox.getValue();
        String description = TextArea1.getText();
        String type = CmbEmmergencyType.getValue();
        String level = CmbSecurityLevel.getValue();
        boolean status = RBStatus.isSelected();
        boolean flag = CBAditionalFlags.isSelected();

        if (location.isEmpty() || date == null || description.isEmpty()
                || type == null || level == null) {
            showAlert("Please fill all fields!");
            return;
        }

        EmergencyReport_Goal5 report = new EmergencyReport_Goal5(
                location, date, description, type, level, status, flag
        );

        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream("emergency.bin", true))) {

            oos.writeObject(report);
            showAlert("Report Submitted Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //  CLEAR
    @javafx.fxml.FXML
    public void ClearOA(ActionEvent actionEvent) {

        TXTLocation.clear();
        DateBox.setValue(null);
        TextArea1.clear();
        CmbEmmergencyType.setValue(null);
        CmbSecurityLevel.setValue(null);
        RBStatus.setSelected(false);
        CBAditionalFlags.setSelected(false);
    }

    //  DELETE (clears file)
    @javafx.fxml.FXML
    public void DeleteOA(ActionEvent actionEvent) {

        File file = new File("emergency.bin");

        if (file.exists()) {
            file.delete();
            showAlert("All reports deleted!");
        } else {
            showAlert("No file found!");
        }
    }

    //  UPDATE (simple overwrite last entry)
    @javafx.fxml.FXML
    public void UpdateOA(ActionEvent actionEvent) {

        SubmitReportOA(actionEvent); // simple reuse
        showAlert("Updated (New Entry Added)");
    }

    //  ALERT HELPER
    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(msg);
        alert.show();
    }



    @javafx.fxml.FXML
    public void NextOA(ActionEvent actionEvent) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Goal 6-ShiftChangeRequest.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        Button b = (Button) actionEvent.getSource();
        Stage stage = (Stage) b.getScene().getWindow();

        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void BackOA(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Goal 4-UpdateProfile.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        Button b = (Button) actionEvent.getSource();
        Stage stage = (Stage) b.getScene().getWindow();

        stage.setScene(scene);
    }
}