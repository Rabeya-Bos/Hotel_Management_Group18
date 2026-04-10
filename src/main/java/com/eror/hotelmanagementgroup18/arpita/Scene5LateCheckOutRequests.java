package com.eror.hotelmanagementgroup18.arpita;

import com.eror.hotelmanagementgroup18.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;

public class Scene5LateCheckOutRequests
{
    @javafx.fxml.FXML
    private ComboBox <String> CmbDecision;
    @javafx.fxml.FXML
    private TextField TXTBookingName;
    @javafx.fxml.FXML
    private TableColumn <LateCheckout_Scene5,Integer>ColBookingId;
    @javafx.fxml.FXML
    private TextField TXTBookingID;
    @javafx.fxml.FXML
    private TableColumn <LateCheckout_Scene5,String>ColBookingName;
    @javafx.fxml.FXML
    private TableColumn <LateCheckout_Scene5,String> ColCheckOutDate;
    @javafx.fxml.FXML
    private Label LVLResult;
    @javafx.fxml.FXML
    private TableView <LateCheckout_Scene5>TableView1;

    @javafx.fxml.FXML
    public void initialize() {
        ColBookingId.setCellValueFactory(new PropertyValueFactory<>("bookingId"));
        ColBookingName.setCellValueFactory(new PropertyValueFactory<>("bookingName"));
        ColCheckOutDate.setCellValueFactory(new PropertyValueFactory<>("checkOutDate"));

        CmbDecision.getItems().addAll("Approved", "Rejected");

        loadRequests();
    }

    //  Load requests from file
    private void loadRequests() {
        TableView1.getItems().clear();

        try (ObjectInputStream stream =
                     new ObjectInputStream(new FileInputStream("latecheckout.bin"))) {

            while (true) {
                LateCheckout_Scene5 r = (LateCheckout_Scene5) stream.readObject();
                TableView1.getItems().add(r);
            }

        } catch (EOFException e) {
            // end
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @javafx.fxml.FXML
    public void SubmitOA(ActionEvent actionEvent) {
        if (TXTBookingID.getText().isEmpty() ||
                TXTBookingName.getText().isEmpty() ||
                CmbDecision.getValue() == null) {

            LVLResult.setText(" Fill all fields!");
            return;
        }

        int id = Integer.parseInt(TXTBookingID.getText());
        String name = TXTBookingName.getText();
        String decision = CmbDecision.getValue();

        File inputFile = new File("latecheckout.bin");
        File tempFile = new File("temp.bin");

        boolean found = false;

        try (
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(inputFile));
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(tempFile))
        ) {

            while (true) {
                LateCheckout_Scene5 r = (LateCheckout_Scene5) in.readObject();

                if (r.getBookingId() == id &&
                        r.getBookingName().equalsIgnoreCase(name)) {

                    r.setDecision(decision); // ✔ update decision
                    found = true;
                }

                out.writeObject(r);
            }

        } catch (EOFException e) {
            // done
        } catch (Exception e) {
            e.printStackTrace();
        }

        inputFile.delete();
        tempFile.renameTo(inputFile);

        if (found) {
            LVLResult.setText(" Decision Updated!");
        } else {
            LVLResult.setText(" Request not found!");
        }

        loadRequests();

        TXTBookingID.clear();
        TXTBookingName.clear();
        CmbDecision.setValue(null);
    }



    @javafx.fxml.FXML
    public void NextOA(ActionEvent actionEvent) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/eror/hotelmanagementgroup18/arpita/Scene- 6-Seasonal Pricing.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void BackOA(ActionEvent actionEvent) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/eror/hotelmanagementgroup18/arpita/Scene-4-ApproveGuestCheck-In.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }
}
