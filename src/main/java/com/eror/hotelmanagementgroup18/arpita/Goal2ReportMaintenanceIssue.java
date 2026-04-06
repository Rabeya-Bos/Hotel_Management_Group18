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
    private RadioButton RDOStatus;

    @javafx.fxml.FXML
    private TextField TXTRoomNumber;

    @javafx.fxml.FXML
    private ComboBox<String> CmbSecurityLevel;

    @javafx.fxml.FXML
    private ComboBox<String> CmbIssueType;

    @javafx.fxml.FXML
    private CheckBox CBAditionalFlags;

    @javafx.fxml.FXML
    private TextArea TXTAreaIssuesDescription;

    @javafx.fxml.FXML
    private Label LVLResult; // ✅ FIXED (was missing)

    @javafx.fxml.FXML
    public void initialize() {

        CmbIssueType.getItems().addAll(
                "Electrical",
                "Plumbing",
                "Furniture",
                "AC",
                "Other"
        );

        CmbSecurityLevel.getItems().addAll(
                "Low",
                "Medium",
                "High"
        );
    }

    //  Submit Report
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
        String status = RDOStatus.isSelected() ? "Open" : "In Progress";
        String flag = CBAditionalFlags.isSelected() ? "Urgent" : "Normal";

        MaintenanceIssue_Goal2 issue =
                new MaintenanceIssue_Goal2(roomNo, type, severity, description, status, flag);

        //  FIXED try syntax
        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream("maintenance.bin", true)) {

                         @Override
                         protected void writeStreamHeader() throws IOException {
                             reset(); // prevents header corruption
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

    //  Update
    @javafx.fxml.FXML
    public void UpdateOA(ActionEvent actionEvent) {
        SubmitReportOA(actionEvent);
        showResult("Report Updated!");
    }

    //  Clear
    @javafx.fxml.FXML
    public void ClearOA(ActionEvent actionEvent) {

        TXTRoomNumber.clear();
        CmbIssueType.setValue(null);
        CmbSecurityLevel.setValue(null);
        TXTAreaIssuesDescription.clear();
        CBAditionalFlags.setSelected(false);
        RDOStatus.setSelected(false);

        showResult("");
    }

    //  helper
    private void showResult(String msg) {
        if (LVLResult != null) {
            LVLResult.setText(msg);
        } else {
            System.out.println(msg);
        }
    }


    @javafx.fxml.FXML
    public void next(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Goal 3-Lost & Found.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        Button b = (Button) actionEvent.getSource();
        Stage stage = (Stage) b.getScene().getWindow();

        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void back(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Goal 1- Update Cleaning Status.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        Button b = (Button) actionEvent.getSource();
        Stage stage = (Stage) b.getScene().getWindow();

        stage.setScene(scene);
    }
}