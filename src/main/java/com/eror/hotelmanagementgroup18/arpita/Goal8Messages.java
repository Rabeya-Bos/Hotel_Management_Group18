package com.eror.hotelmanagementgroup18.arpita;

import com.eror.hotelmanagementgroup18.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;

public class Goal8Messages {

    @javafx.fxml.FXML
    private TextArea TextArea1;
    @javafx.fxml.FXML
    private TextField TXTSubject;
    @javafx.fxml.FXML
    private RadioButton RBPriority;
    @javafx.fxml.FXML
    private CheckBox CBOptions;
    @javafx.fxml.FXML
    private ComboBox<String> CmbSender;
    @javafx.fxml.FXML
    private ComboBox<String> CmbReciver;

    @javafx.fxml.FXML
    public void initialize() {

        CmbSender.getItems().addAll(
                "Manager", "Reception", "Cleaner", "Security"
        );

        CmbReciver.getItems().addAll(
                "Manager", "Reception", "Cleaner", "Security"
        );
    }

    //  SEND MESSAGE
    @javafx.fxml.FXML
    public void SendOA(ActionEvent actionEvent) {

        String sender = CmbSender.getValue();
        String receiver = CmbReciver.getValue();
        String subject = TXTSubject.getText();
        String message = TextArea1.getText();
        boolean priority = RBPriority.isSelected();
        boolean option = CBOptions.isSelected();

        if (sender == null || receiver == null ||
                subject.isEmpty() || message.isEmpty()) {
            showAlert("Please fill all fields!");
            return;
        }

        Message_Goal8 msg = new Message_Goal8(
                sender, receiver, subject, message, priority, option
        );

        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream("messages.bin", true))) {

            oos.writeObject(msg);
            showAlert("Message Sent Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //  CLEAR FORM
    @javafx.fxml.FXML
    public void ClearOA(ActionEvent actionEvent) {

        CmbSender.setValue(null);
        CmbReciver.setValue(null);
        TXTSubject.clear();
        TextArea1.clear();
        RBPriority.setSelected(false);
        CBOptions.setSelected(false);
    }

    //  ALERT HELPER
    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(msg);
        alert.show();
    }



    @Deprecated
    public void back(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Goal 7- Floor Cleaning Progress.fxml.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        Button b = (Button) actionEvent.getSource();
        Stage stage = (Stage) b.getScene().getWindow();

        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void BackOA(ActionEvent actionEvent) {
    }
}