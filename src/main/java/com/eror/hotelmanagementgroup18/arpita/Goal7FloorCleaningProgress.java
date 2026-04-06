package com.eror.hotelmanagementgroup18.arpita;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.*;
import java.time.LocalDate;

public class Goal7FloorCleaningProgress {

    @javafx.fxml.FXML
    private ComboBox<String> CmbFloorNumber;
    @javafx.fxml.FXML
    private ComboBox<String> CmbAssignedStaff;
    @javafx.fxml.FXML
    private ComboBox<String> CmbCleaningStatus;
    @javafx.fxml.FXML
    private RadioButton RBPriority;
    @javafx.fxml.FXML
    private CheckBox CBAdditionalOption;
    @javafx.fxml.FXML
    private DatePicker Date1;

    @javafx.fxml.FXML
    public void initialize() {

        CmbFloorNumber.getItems().addAll("1", "2", "3", "4", "5");

        CmbAssignedStaff.getItems().addAll(
                "Rahim", "Karim", "John", "Alice"
        );

        CmbCleaningStatus.getItems().addAll(
                "Pending", "In Progress", "Completed"
        );
    }

    // UPDATE STATUS (Save data)
    @javafx.fxml.FXML
    public void UpdateStatus(ActionEvent actionEvent) {

        String floor = CmbFloorNumber.getValue();
        String staff = CmbAssignedStaff.getValue();
        String status = CmbCleaningStatus.getValue();
        LocalDate date = Date1.getValue();
        boolean priority = RBPriority.isSelected();
        boolean extra = CBAdditionalOption.isSelected();

        if (floor == null || staff == null || status == null || date == null) {
            showAlert("Please fill all fields!");
            return;
        }

        FloorCleaningProgress_Goal7 obj =
                new FloorCleaningProgress_Goal7(
                        floor, staff, status, priority, extra, date
                );

        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream("cleaning.bin", true))) {

            oos.writeObject(obj);
            showAlert("Status Updated Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //  CLEAR FORM
    @javafx.fxml.FXML
    public void ClearOA(ActionEvent actionEvent) {

        CmbFloorNumber.setValue(null);
        CmbAssignedStaff.setValue(null);
        CmbCleaningStatus.setValue(null);
        Date1.setValue(null);
        RBPriority.setSelected(false);
        CBAdditionalOption.setSelected(false);
    }

    //  ALERT HELPER
    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(msg);
        alert.show();
    }

    @javafx.fxml.FXML
    public void NextOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void BackOA(ActionEvent actionEvent) {
    }
}