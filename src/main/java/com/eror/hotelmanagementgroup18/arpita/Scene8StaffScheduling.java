package com.eror.hotelmanagementgroup18.arpita;

import com.eror.hotelmanagementgroup18.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;

public class Scene8StaffScheduling {

    @javafx.fxml.FXML
    private TextField TxtStaffName;

    @javafx.fxml.FXML
    private ComboBox<String> CMBDepartment;

    @javafx.fxml.FXML
    private ComboBox<String> CMBShift;

    @javafx.fxml.FXML
    private Label LVLResult;

    @javafx.fxml.FXML
    public void initialize() {

        //  Department options
        CMBDepartment.getItems().addAll(
                "Reception",
                "Housekeeping",
                "Security",
                "Management"
        );

        //  Shift options
        CMBShift.getItems().addAll(
                "Morning",
                "Evening",
                "Night"
        );
    }

    //  Save schedule
    @javafx.fxml.FXML
    public void SaveOA(ActionEvent actionEvent) {

        if (TxtStaffName.getText().isEmpty() ||
                CMBDepartment.getValue() == null ||
                CMBShift.getValue() == null) {

            LVLResult.setText(" Fill all fields!");
            return;
        }

        String name = TxtStaffName.getText();
        String dept = CMBDepartment.getValue();
        String shift = CMBShift.getValue();

        StaffSchedule_Scene8 schedule =
                new StaffSchedule_Scene8(name, dept, shift);

        //  Save to file
        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream("staffschedule.bin", true)) {

                         @Override
                         protected void writeStreamHeader() throws IOException {
                             reset(); // avoid header issue
                         }
                     }) {

            out.writeObject(schedule);

        } catch (Exception e) {
            e.printStackTrace();
        }

        LVLResult.setText(" Schedule Saved!");

        ResetOA(null);
    }

    //  Filter (simple display logic)
    @javafx.fxml.FXML
    public void FilterOA(ActionEvent actionEvent) {

        String dept = CMBDepartment.getValue();

        if (dept == null) {
            LVLResult.setText(" Select department to filter!");
            return;
        }

        boolean found = false;

        try (ObjectInputStream in =
                     new ObjectInputStream(new FileInputStream("staffschedule.bin"))) {

            while (true) {
                StaffSchedule_Scene8 s = (StaffSchedule_Scene8) in.readObject();

                if (s.getDepartment().equals(dept)) {
                    System.out.println(s.getStaffName() + " - " + s.getShift());
                    found = true;
                }
            }

        } catch (EOFException e) {
            // end
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (found) {
            LVLResult.setText(" Filter Applied (Check Console)");
        } else {
            LVLResult.setText(" No data found!");
        }
    }

    //  Reset fields
    @javafx.fxml.FXML
    public void ResetOA(ActionEvent actionEvent) {

        TxtStaffName.clear();
        CMBDepartment.setValue(null);
        CMBShift.setValue(null);

        LVLResult.setText("");
    }

    @javafx.fxml.FXML
    public void BackOA(ActionEvent actionEvent)  throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Scene-7-ApplyDiscount.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        Button b = (Button) actionEvent.getSource();
        Stage stage = (Stage) b.getScene().getWindow();

        stage.setScene(scene);
    }
}