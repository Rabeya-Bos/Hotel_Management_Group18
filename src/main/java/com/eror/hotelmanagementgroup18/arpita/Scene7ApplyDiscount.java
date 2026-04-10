package com.eror.hotelmanagementgroup18.arpita;

import com.eror.hotelmanagementgroup18.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;

public class Scene7ApplyDiscount {

    @javafx.fxml.FXML
    private Label LvlResult;
    @javafx.fxml.FXML
    private TextField TxtDisscount;
    @javafx.fxml.FXML
    private TableColumn<BookingDiscount_Scene7, Integer> ColBookingID;
    @javafx.fxml.FXML
    private TableColumn<BookingDiscount_Scene7, String> ColBookingName;
    @javafx.fxml.FXML
    private TableColumn<BookingDiscount_Scene7, Integer> ColRoomNO;
    @javafx.fxml.FXML
    private TableColumn<BookingDiscount_Scene7, Double> ColTotalAmount;
    @javafx.fxml.FXML
    private TableColumn<BookingDiscount_Scene7, String> ColStatus;
    @javafx.fxml.FXML
    private TableView<BookingDiscount_Scene7> TableView1;

    @javafx.fxml.FXML
    public void initialize() {

        ColBookingID.setCellValueFactory(new PropertyValueFactory<>("bookingId"));
        ColBookingName.setCellValueFactory(new PropertyValueFactory<>("bookingName"));
        ColRoomNO.setCellValueFactory(new PropertyValueFactory<>("roomNo"));
        ColTotalAmount.setCellValueFactory(new PropertyValueFactory<>("totalAmount"));
        ColStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        loadData();
    }

    //  Load booking data
    private void loadData() {

        TableView1.getItems().clear();

        try (ObjectInputStream stream =
                     new ObjectInputStream(new FileInputStream("discount.bin"))) {

            while (true) {
                BookingDiscount_Scene7 b = (BookingDiscount_Scene7) stream.readObject();
                TableView1.getItems().add(b);
            }

        } catch (EOFException e) {
            // end
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //  Apply Discount
    @javafx.fxml.FXML
    public void ApplyOA(ActionEvent actionEvent) {

        if (TxtDisscount.getText().isEmpty()) {
            LvlResult.setText(" Enter discount!");
            return;
        }

        BookingDiscount_Scene7 selected = TableView1.getSelectionModel().getSelectedItem();

        if (selected == null) {
            LvlResult.setText(" Select a booking!");
            return;
        }

        double discount = Double.parseDouble(TxtDisscount.getText());

        //  apply discount
        double newAmount = selected.getTotalAmount() - discount;

        if (newAmount < 0) newAmount = 0;

        selected.setTotalAmount(newAmount);

        //  update file
        File inputFile = new File("discount.bin");
        File tempFile = new File("temp.bin");

        try (
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(inputFile));
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(tempFile))
        ) {

            while (true) {
                BookingDiscount_Scene7 b = (BookingDiscount_Scene7) in.readObject();

                if (b.getBookingId() == selected.getBookingId()) {
                    out.writeObject(selected); // updated
                } else {
                    out.writeObject(b);
                }
            }

        } catch (EOFException e) {
            // done
        } catch (Exception e) {
            e.printStackTrace();
        }

        inputFile.delete();
        tempFile.renameTo(inputFile);

        LvlResult.setText(" Discount Applied!");

        loadData();
        TxtDisscount.clear();
    }

    @javafx.fxml.FXML
    public void NextOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/eror/hotelmanagementgroup18/arpita/Scene-8-Staff Scheduling.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void BackOA(ActionEvent actionEvent) throws IOException  {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/eror/hotelmanagementgroup18/arpita/Scene-6-SeasonalPricing.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }
}