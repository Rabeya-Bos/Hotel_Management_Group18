package com.eror.hotelmanagementgroup18.arpita;

import com.eror.hotelmanagementgroup18.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;

public class Goal6ShiftChangeRequest {

    @javafx.fxml.FXML
    private ComboBox<String> CmbStaffName;

    @javafx.fxml.FXML
    private TextArea TextArea1;

    @javafx.fxml.FXML
    private RadioButton RBRequestStatus;

    @javafx.fxml.FXML
    private DatePicker Date2;

    @javafx.fxml.FXML
    private CheckBox CBAditionalOptiona;

    @javafx.fxml.FXML
    private ComboBox<String> CmbRequestedShift;

    @javafx.fxml.FXML
    private DatePicker Date1;

    @javafx.fxml.FXML
    private ComboBox<String> CmbCurrentShift;

    @javafx.fxml.FXML
    public void initialize() {

        CmbStaffName.getItems().addAll("John", "Alice", "Rahim", "Karim");

        CmbCurrentShift.getItems().addAll("Morning", "Evening", "Night");
        CmbRequestedShift.getItems().addAll("Morning", "Evening", "Night");
    }

    //  SUBMIT
    @javafx.fxml.FXML
    public void SubmitRequestOA(ActionEvent actionEvent) {

        String staff = CmbStaffName.getValue();
        String current = CmbCurrentShift.getValue();
        String requested = CmbRequestedShift.getValue();
        LocalDate from = Date1.getValue();
        LocalDate to = Date2.getValue();
        String reason = TextArea1.getText();
        boolean status = RBRequestStatus.isSelected();
        boolean extra = CBAditionalOptiona.isSelected();

        // Validation
        if (staff == null || current == null || requested == null ||
                from == null || to == null || reason.isEmpty()) {
            showAlert("Please fill all fields!");
            return;
        }

        if (from.isAfter(to)) {
            showAlert("From date cannot be after To date!");
            return;
        }

        ShiftChangeRequest_Goal6 req = new ShiftChangeRequest_Goal6(
                staff, current, requested, from, to, reason, status, extra
        );

        //  FIXED file writing (append safely)
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream("shift.bin", true)) {

                         @Override
                         protected void writeStreamHeader() throws IOException {
                             reset();
                         }
                     }) {

            oos.writeObject(req);
            showAlert("Request Submitted Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Error saving request!");
        }
    }

    //  CLEAR
    @javafx.fxml.FXML
    public void ClearOA(ActionEvent actionEvent) {

        CmbStaffName.setValue(null);
        CmbCurrentShift.setValue(null);
        CmbRequestedShift.setValue(null);
        Date1.setValue(null);
        Date2.setValue(null);
        TextArea1.clear();
        RBRequestStatus.setSelected(false);
        CBAditionalOptiona.setSelected(false);
    }

    //  UPDATE (simple version)
    @javafx.fxml.FXML
    public void UpdateOA(ActionEvent actionEvent) {

        SubmitRequestOA(actionEvent);
        showAlert("Updated (New Request Added)");
    }

    //  CANCEL
    @javafx.fxml.FXML
    public void CancelOA(ActionEvent actionEvent) {

        ClearOA(actionEvent);
        showAlert("Request Cancelled");
    }

    //  Alert helper
    private void showAlert(String message) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Shift Change Request");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    @javafx.fxml.FXML
    public void NextOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Goal 7- Floor Cleaning Progress.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        Button b = (Button) actionEvent.getSource();
        Stage stage = (Stage) b.getScene().getWindow();

        stage.setScene(scene);

    }

    @javafx.fxml.FXML
    public void BackOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Goal 7- Floor Cleaning Progress.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        Button b = (Button) actionEvent.getSource();
        Stage stage = (Stage) b.getScene().getWindow();

        stage.setScene(scene);
    }

}