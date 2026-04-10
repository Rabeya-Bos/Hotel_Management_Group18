package com.eror.hotelmanagementgroup18.arpita;

import com.eror.hotelmanagementgroup18.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;

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

        //  Room type
        CmbRoomType.getItems().addAll("Single", "Double", "Suite");

        //  Cleaning status
        CmbCleaningStatus.getItems().addAll("Pending", "In Progress", "Cleaned", "Needs Maintenance");

        //  Additional options
        CmbAdtionalOption.getItems().addAll("Deep Cleaning", "Damage Report", "None"
        );
    }

    //  Update Cleaning Status
    @javafx.fxml.FXML
    public void UpdateStatusOA(ActionEvent actionEvent) {

        if (TXTRoomNumber.getText().isEmpty() || CmbRoomType.getValue() == null || CmbCleaningStatus.getValue() == null) {

            LVLResult.setText(" Fill all required fields!");
            return;
        }

        int roomNo = Integer.parseInt(TXTRoomNumber.getText());
        String roomType = CmbRoomType.getValue();
        String status = CmbCleaningStatus.getValue();
        String additional = CmbAdtionalOption.getValue();
        String priority = RDBPriority.isSelected() ? "Urgent" : "Normal";

        CleaningStatus_Scene1 cs =
                new CleaningStatus_Scene1(roomNo, roomType, status, priority, additional);

        //  Save to file
        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream("cleaning.bin", true)) {

                         @Override
                         protected void writeStreamHeader() throws IOException {
                             reset();
                         }
                     }) {

            out.writeObject(cs);

        } catch (Exception e) {
            e.printStackTrace();
        }

        LVLResult.setText(" Status Updated!");

        ClearOA(null);
    }

    //  Clear fields
    @javafx.fxml.FXML
    public void ClearOA(ActionEvent actionEvent) {

        TXTRoomNumber.clear();
        CmbRoomType.setValue(null);
        CmbCleaningStatus.setValue(null);
        CmbAdtionalOption.setValue(null);
        RDBPriority.setSelected(false);

        LVLResult.setText("");
    }

    @Deprecated
    public void next(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Goal 2-ReportMaintenanceIssue.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        Button b = (Button) actionEvent.getSource();
        Stage stage = (Stage) b.getScene().getWindow();

        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void NextOA(ActionEvent actionEvent) {
    }
}