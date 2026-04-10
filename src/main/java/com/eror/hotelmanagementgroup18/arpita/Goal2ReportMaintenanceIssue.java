package com.eror.hotelmanagementgroup18.arpita;

import com.eror.hotelmanagementgroup18.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class Goal2ReportMaintenanceIssue {

    @javafx.fxml.FXML
    private TextField TXTRoomNumber;
    @javafx.fxml.FXML
    private ComboBox<String> CmbSecurityLevel;
    @javafx.fxml.FXML
    private ComboBox<String> CmbIssueType;
    @javafx.fxml.FXML
    private TextArea TXTAreaIssuesDescription;
    @javafx.fxml.FXML
    private CheckBox CBAditionalFlags;


    @javafx.fxml.FXML
    private RadioButton RBOpen;
    @javafx.fxml.FXML
    private RadioButton RBInProgress;
    @javafx.fxml.FXML
    private Label LVLResult;
    @javafx.fxml.FXML
    private ToggleGroup statusGroup;

    @javafx.fxml.FXML
    public void initialize() {
        CmbIssueType.getItems().addAll("Electrical", "Plumbing", "Furniture", "AC", "Other");
        CmbSecurityLevel.getItems().addAll("Low", "Medium", "High");
    }

    @javafx.fxml.FXML
    public void SubmitReportOA(ActionEvent actionEvent) throws Exception {

        if (TXTRoomNumber.getText().isEmpty() || CmbIssueType.getValue() == null ||
                CmbSecurityLevel.getValue() == null || TXTAreaIssuesDescription.getText().isEmpty()) {
            LVLResult.setText("Error: Fill all required fields!");
            LVLResult.setStyle("-fx-text-fill: red;");
            return;
        }

        int roomNo = Integer.parseInt(TXTRoomNumber.getText());
        String type = CmbIssueType.getValue();
        String severity = CmbSecurityLevel.getValue();
        String description = TXTAreaIssuesDescription.getText();

        String status = "";
        if (RBOpen.isSelected()) status = "Open";
        else if (RBInProgress.isSelected()) status = "In Progress";
        else {
            LVLResult.setText("Error: Select status!");
            LVLResult.setStyle("-fx-text-fill: red;");
            return;
        }

        String flag = CBAditionalFlags.isSelected() ? "Urgent" : "Normal";


        MaintenanceIssue_Goal2 issue = new MaintenanceIssue_Goal2(roomNo, type, severity, description, status, flag);


        File file = new File("maintenance.bin");
        ArrayList<MaintenanceIssue_Goal2> issueList = new ArrayList<>();

        if (file.exists() && file.length() > 0) {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            issueList = (ArrayList<MaintenanceIssue_Goal2>) ois.readObject();
            ois.close();
        }

        issueList.add(issue);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(issueList);
        oos.close();

        LVLResult.setText("Success: Report Submitted!");
        LVLResult.setStyle("-fx-text-fill: green;");
    }

    @javafx.fxml.FXML
    public void ClearOA(ActionEvent actionEvent) {
        TXTRoomNumber.clear();
        CmbIssueType.setValue(null);
        CmbSecurityLevel.setValue(null);
        TXTAreaIssuesDescription.clear();
        CBAditionalFlags.setSelected(false);
        RBOpen.setSelected(false);
        RBInProgress.setSelected(false);
        LVLResult.setText("");
    }

    @javafx.fxml.FXML
    public void UpdateOA(ActionEvent actionEvent) {

        LVLResult.setText("Update function triggered.");
    }

    @javafx.fxml.FXML
    public void NextOA(ActionEvent actionEvent) throws IOException {
        String path = "/com/eror/hotelmanagementgroup18/arpita/Goal3-LostAndFound.fxml";
        loadScene(path, actionEvent);
    }

    @javafx.fxml.FXML
    public void BackOA(ActionEvent actionEvent) throws IOException {
        String path = "/com/eror/hotelmanagementgroup18/arpita/Goal1-UpdateCleaningStatus.fxml";
        loadScene(path, actionEvent);
    }


    private void loadScene(String path, ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
        if (getClass().getResource(path) == null) {
            System.out.println("FXML file not found at: " + path);
            return;
        }
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }
}