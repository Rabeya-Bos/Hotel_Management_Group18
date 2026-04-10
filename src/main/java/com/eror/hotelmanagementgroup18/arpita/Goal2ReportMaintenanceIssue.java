package com.eror.hotelmanagementgroup18.arpita;

import com.eror.hotelmanagementgroup18.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;

public class Goal2ReportMaintenanceIssue {

    @javafx.fxml.FXML
    private RadioButton RBOpen, RBInProgress;

    @javafx.fxml.FXML
    private ToggleGroup statusGroup;

    @javafx.fxml.FXML
    private TextField TXTRoomNumber;

    @javafx.fxml.FXML
    private ComboBox<String> CmbSecurityLevel;

    @javafx.fxml.FXML
    private ComboBox<String> CmbIssueType;

    @javafx.fxml.FXML
    private CheckBox CBAdditionalFlags;

    @javafx.fxml.FXML
    private TextArea TXTAreaIssuesDescription;

    @javafx.fxml.FXML
    private Label LVLResult;

    @javafx.fxml.FXML
    public void initialize() {

        CmbIssueType.getItems().addAll(
                "Electrical", "Plumbing", "Furniture", "AC", "Other"
        );

        CmbSecurityLevel.getItems().addAll(
                "Low", "Medium", "High"
        );
    }

    // Submit Report
    @javafx.fxml.FXML
    public void SubmitReportOA(ActionEvent actionEvent) {

        if (TXTRoomNumber.getText().isEmpty() ||
                CmbIssueType.getValue() == null ||
                CmbSecurityLevel.getValue() == null ||
                TXTAreaIssuesDescription.getText().isEmpty()) {

            showResult("Fill all required fields!");
            return;
        }

        int roomNo;

        try {
            roomNo = Integer.parseInt(TXTRoomNumber.getText());
        } catch (NumberFormatException e) {
            showResult("Room number must be a valid number!");
            return;
        }

        String type = CmbIssueType.getValue();
        String severity = CmbSecurityLevel.getValue();
        String description = TXTAreaIssuesDescription.getText();

        String status;
        if (RBOpen.isSelected()) {
            status = "Open";
        } else if (RBInProgress.isSelected()) {
            status = "In Progress";
        } else {
            showResult("Select status!");
            return;
        }

        String flag = CBAdditionalFlags.isSelected() ? "Urgent" : "Normal";

        MaintenanceIssue_Goal2 issue =
                new MaintenanceIssue_Goal2(roomNo, type, severity, description, status, flag);

        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream("maintenance.bin", true)) {

                         protected void writeStreamHeader() throws IOException {
                             reset();
                         }
                     }) {

            out.writeObject(issue);

        } catch (Exception e) {
            e.printStackTrace();
            showResult("Error saving file!");
            return;
        }

        showResult("Report Submitted!");
        ClearOA(null);
    }

    // Clear
    @javafx.fxml.FXML
    public void ClearOA(ActionEvent actionEvent) {

        TXTRoomNumber.clear();
        CmbIssueType.setValue(null);
        CmbSecurityLevel.setValue(null);
        TXTAreaIssuesDescription.clear();
        CBAdditionalFlags.setSelected(false);
        statusGroup.selectToggle(null);

        showResult("");
    }

    // helper
    private void showResult(String msg) {
        LVLResult.setText(msg);
    }

    // Navigation
    public void next(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Goal 3-Lost&Found.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }

    public void back(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Goal 1-UpdateCleaningStatus.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }
}