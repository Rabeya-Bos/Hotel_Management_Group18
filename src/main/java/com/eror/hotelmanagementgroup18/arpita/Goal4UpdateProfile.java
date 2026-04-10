package com.eror.hotelmanagementgroup18.arpita;

import com.eror.hotelmanagementgroup18.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;

public class Goal4UpdateProfile {

    @javafx.fxml.FXML
    private RadioButton RBMale, RBFemale, RBPreference;

    @javafx.fxml.FXML
    private ToggleGroup genderGroup;

    @javafx.fxml.FXML
    private TextField TXTFullName, TXTUserName, TXTPassword, TXTEmail, TXTPhoneNumber;

    @javafx.fxml.FXML
    private ComboBox<String> CmbRole;

    @javafx.fxml.FXML
    private TableView<UserProfile_Goal4> TableView1;

    @javafx.fxml.FXML
    private TableColumn<UserProfile_Goal4, Integer> ColUserID;

    @javafx.fxml.FXML
    private TableColumn<UserProfile_Goal4, String> ColName, ColUserName, ColPassword,
            ColEmail, ColPhone, ColRole, ColGender, ColPreference, ColStatus;

    private int idCounter = 1;

    @javafx.fxml.FXML
    public void initialize() {

        ColUserID.setCellValueFactory(new PropertyValueFactory<>("userID"));
        ColName.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        ColUserName.setCellValueFactory(new PropertyValueFactory<>("userName"));
        ColPassword.setCellValueFactory(new PropertyValueFactory<>("password"));
        ColEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        ColPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        ColRole.setCellValueFactory(new PropertyValueFactory<>("role"));
        ColGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        ColPreference.setCellValueFactory(new PropertyValueFactory<>("preference"));
        ColStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        CmbRole.getItems().addAll("Manager", "Receptionist", "Housekeeping", "Security");

        loadData();
    }

    private void loadData() {

        TableView1.getItems().clear();

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("users.bin"))) {

            while (true) {
                UserProfile_Goal4 user = (UserProfile_Goal4) in.readObject();
                TableView1.getItems().add(user);
                idCounter = Math.max(idCounter, user.getUserID() + 1);
            }

        } catch (EOFException e) {
            // normal
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Save / Update
    @javafx.fxml.FXML
    public void UpdateProfileOA(ActionEvent actionEvent) {

        UserProfile_Goal4 selected = TableView1.getSelectionModel().getSelectedItem();

        String gender = RBMale.isSelected() ? "Male" : "Female";
        String preference = RBPreference.isSelected() ? "Yes" : "No";
        String status = "Active";

        if (TXTFullName.getText().isEmpty() || TXTUserName.getText().isEmpty() ||
                TXTPassword.getText().isEmpty() || TXTEmail.getText().isEmpty() ||
                TXTPhoneNumber.getText().isEmpty() || CmbRole.getValue() == null) {
            System.out.println("Fill all fields!");
            return;
        }

        if (selected == null) {

            // New user
            UserProfile_Goal4 user = new UserProfile_Goal4(
                    idCounter++,
                    TXTFullName.getText(),
                    TXTUserName.getText(),
                    TXTPassword.getText(),
                    TXTEmail.getText(),
                    TXTPhoneNumber.getText(),
                    CmbRole.getValue(),
                    gender,
                    preference,
                    status
            );

            try (ObjectOutputStream out =
                         new ObjectOutputStream(new FileOutputStream("users.bin", true)) {
                             protected void writeStreamHeader() throws IOException {
                                 reset();
                             }
                         }) {

                out.writeObject(user);

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {

            // Update
            selected.setFullName(TXTFullName.getText());
            selected.setUserName(TXTUserName.getText());
            selected.setPassword(TXTPassword.getText());
            selected.setEmail(TXTEmail.getText());
            selected.setPhone(TXTPhoneNumber.getText());
            selected.setRole(CmbRole.getValue());
            selected.setGender(gender);
            selected.setPreference(preference);

            rewriteFile();
        }

        loadData();
        ClearOA(null);
    }

    @javafx.fxml.FXML
    public void ClearOA(ActionEvent actionEvent) {

        TXTFullName.clear();
        TXTUserName.clear();
        TXTPassword.clear();
        TXTEmail.clear();
        TXTPhoneNumber.clear();
        CmbRole.setValue(null);
        genderGroup.selectToggle(null);
        RBPreference.setSelected(false);
    }

    private void rewriteFile() {

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("users.bin"))) {

            for (UserProfile_Goal4 user : TableView1.getItems()) {
                out.writeObject(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void next(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Goal 5-EmergencyReport.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }

    public void back(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Goal 3-Lost&Found.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }
}