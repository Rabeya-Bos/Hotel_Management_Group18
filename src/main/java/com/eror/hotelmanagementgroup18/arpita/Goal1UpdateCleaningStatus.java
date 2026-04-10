package com.eror.hotelmanagementgroup18.arpita;

import com.eror.hotelmanagementgroup18.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class Goal1UpdateCleaningStatus {

    @javafx.fxml.FXML
    private ComboBox<String> CmbAdtionalOption;
    @javafx.fxml.FXML
    private ComboBox<String> CmbRoomType;
    @javafx.fxml.FXML
    private ComboBox<String> CmbCleaningStatus;
    @javafx.fxml.FXML
    private TextField TXTRoomNumber;
    @javafx.fxml.FXML
    private Label LVLResult;
    @javafx.fxml.FXML
    private RadioButton RDBPriority;

    @javafx.fxml.FXML
    public void initialize() {

        CmbRoomType.getItems().addAll("Single", "Double", "Suite");
        CmbCleaningStatus.getItems().addAll("Pending", "In Progress", "Cleaned", "Needs Maintenance");
        CmbAdtionalOption.getItems().addAll("Deep Cleaning", "Damage Report", "None");
    }

    @javafx.fxml.FXML
    public void UpdateStatusOA(ActionEvent actionEvent) {

        if (TXTRoomNumber.getText().isEmpty() || CmbRoomType.getValue() == null || CmbCleaningStatus.getValue() == null) {
            LVLResult.setText("Error: Fill all required fields!");
            LVLResult.setStyle("-fx-text-fill: red;");
            return;
        }

        try {

            int roomNo = Integer.parseInt(TXTRoomNumber.getText());
            String roomType = CmbRoomType.getValue();
            String status = CmbCleaningStatus.getValue();
            String additional = (CmbAdtionalOption.getValue() != null) ? CmbAdtionalOption.getValue() : "None";
            String priority = RDBPriority.isSelected() ? "Urgent" : "Normal";


            CleaningStatus_Scene1 newStatus = new CleaningStatus_Scene1(roomNo, roomType, status, priority, additional);


            File file = new File("cleaning.bin");
            ArrayList<CleaningStatus_Scene1> statusList = new ArrayList<>();


            if (file.exists() && file.length() > 0) {
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                    statusList = (ArrayList<CleaningStatus_Scene1>) ois.readObject();
                } catch (Exception e) {
                    System.out.println("New file will be created.");
                }
            }


            statusList.add(newStatus);

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
                oos.writeObject(statusList);
            }


            LVLResult.setText("Success: Status Updated & Saved!");
            LVLResult.setStyle("-fx-text-fill: green;");

        } catch (NumberFormatException e) {
            LVLResult.setText("Error: Room Number must be a number!");
            LVLResult.setStyle("-fx-text-fill: red;");
        } catch (Exception e) {
            LVLResult.setText("Error: Could not save data!");
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void ClearOA(ActionEvent actionEvent) {

        TXTRoomNumber.clear();
        CmbRoomType.setValue(null);
        CmbCleaningStatus.setValue(null);
        CmbAdtionalOption.setValue(null);
        RDBPriority.setSelected(false);
        LVLResult.setText("");
    }

    @javafx.fxml.FXML
    public void NextOA(ActionEvent actionEvent) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/eror/hotelmanagementgroup18/arpita/Goal2-ReportMaintenanceIssue.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);

    }
}