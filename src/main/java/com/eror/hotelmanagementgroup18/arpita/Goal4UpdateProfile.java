package com.eror.hotelmanagementgroup18.arpita;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;

public class Goal4UpdateProfile {


    @javafx.fxml.FXML private TextField TXTUserName, TXTFullName, TXTPassword, TXTPhoneNumber;
    @javafx.fxml.FXML private ComboBox<String> CmbRole;
    @javafx.fxml.FXML private RadioButton RBPreference, RBGender;
    @javafx.fxml.FXML private Label LVLStatus;


    @javafx.fxml.FXML private TableView<UserProfile_Goal4> TableView1;
    @javafx.fxml.FXML private TableColumn<UserProfile_Goal4, Integer> ColUserID;
    @javafx.fxml.FXML private TableColumn<UserProfile_Goal4, String> ColUserName, ColFullName, ColRole, ColPhone, ColStatus;

    private ObservableList<UserProfile_Goal4> userList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {

        if (CmbRole != null) {
            CmbRole.getItems().addAll("Admin", "Manager", "Receptionist", "Staff");
        }


        try {
            if (ColUserID != null) ColUserID.setCellValueFactory(new PropertyValueFactory<>("userId"));
            if (ColUserName != null) ColUserName.setCellValueFactory(new PropertyValueFactory<>("userName"));
            if (ColFullName != null) ColFullName.setCellValueFactory(new PropertyValueFactory<>("fullName"));
            if (ColRole != null) ColRole.setCellValueFactory(new PropertyValueFactory<>("role"));
            if (ColPhone != null) ColPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
            if (ColStatus != null) ColStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

            TableView1.setItems(userList);
        } catch (Exception e) {
            System.out.println("Table Column Connection Error: Make sure FXIDs match in Scene Builder.");
        }
    }

    @javafx.fxml.FXML
    public void UpdateProfileOA(ActionEvent actionEvent) {

        UserProfile_Goal4 newUser = new UserProfile_Goal4(
                userList.size() + 1,
                TXTUserName.getText(),
                TXTFullName.getText(),
                CmbRole.getValue(),
                TXTPhoneNumber.getText(),
                "Active"
        );
        userList.add(newUser);
        if(LVLStatus != null) LVLStatus.setText("Table Updated!");
    }

    @javafx.fxml.FXML
    public void ClearOA(ActionEvent actionEvent) {
        TXTUserName.clear();
        TXTFullName.clear();
        TXTPassword.clear();
        TXTPhoneNumber.clear();
        CmbRole.setValue(null);
        if(LVLStatus != null) LVLStatus.setText("Fields Cleared.");
    }

    @javafx.fxml.FXML
    public void BackOA(ActionEvent actionEvent) throws IOException {
        String path = "/com/eror/hotelmanagementgroup18/arpita/Goal3-LostAndFound.fxml";
        FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void NextOA(ActionEvent actionEvent) {
        if(LVLStatus != null) LVLStatus.setText("No further goals.");
    }
}