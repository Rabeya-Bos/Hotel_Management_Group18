package com.eror.hotelmanagementgroup18.arpita;

import com.eror.hotelmanagementgroup18.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;

public class Scene4ApproveGuestCheckIn
{
    @javafx.fxml.FXML
    private TableColumn <Booking_Scene1,String>ColGuestName;
    @javafx.fxml.FXML
    private TableColumn <Booking_Scene1,String>ColDate;
    @javafx.fxml.FXML
    private TableColumn <Booking_Scene1,Integer>ColBookingId;
    @javafx.fxml.FXML
    private TextField TXTBookingID;
    @javafx.fxml.FXML
    private TextField TXTGuestName;
    @javafx.fxml.FXML
    private Label LVLResult;
    @javafx.fxml.FXML
    private TableView<Booking_Scene1> TableView1;

    @javafx.fxml.FXML
    public void initialize() {
        ColBookingId.setCellValueFactory(new PropertyValueFactory<>("bookingId"));
        ColGuestName.setCellValueFactory(new PropertyValueFactory<>("guestName"));
        ColDate.setCellValueFactory(new PropertyValueFactory<>("date"));

        loadBookings();
    }

    //  Load bookings from file
    private void loadBookings() {

        TableView1.getItems().clear();

        try (ObjectInputStream stream =
                     new ObjectInputStream(new FileInputStream("booking.bin"))) {

            while (true) {
                Booking_Scene1  b = (Booking_Scene1) stream.readObject();

                // show only pending bookings
                if (b.getStatus().equals("Pending")) {
                    TableView1.getItems().add(b);
                }
            }

        } catch (EOFException e) {
            // end
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @javafx.fxml.FXML
    public void ApproveOA(ActionEvent actionEvent) {
        if (TXTBookingID.getText().isEmpty() || TXTGuestName.getText().isEmpty()) {
            LVLResult.setText(" Fill all fields!");
            return;
        }

        int bookingId = Integer.parseInt(TXTBookingID.getText());
        String guestName = TXTGuestName.getText();

        File inputFile = new File("booking.bin");
        File tempFile = new File("temp.bin");

        boolean found = false;

        try (
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(inputFile));
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(tempFile))
        ) {

            while (true) {
                Booking_Scene1  b = (Booking_Scene1) in.readObject();

                if (b.getBookingId() == bookingId &&
                        b.getGuestName().equalsIgnoreCase(guestName)) {

                    b.setStatus("Approved"); // ✔ approve
                    found = true;
                }

                out.writeObject(b);
            }

        } catch (EOFException e) {
            // done
        } catch (Exception e) {
            e.printStackTrace();
        }

        // ✔ replace file
        inputFile.delete();
        tempFile.renameTo(inputFile);

        if (found) {
            LVLResult.setText(" Check-In Approved!");
        } else {
            LVLResult.setText(" Booking not found!");
        }

        loadBookings(); // refresh table

        TXTBookingID.clear();
        TXTGuestName.clear();
    }

    @javafx.fxml.FXML
    public void next(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Scene- 5- Late Check-Out Requests.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        Button b = (Button) actionEvent.getSource();
        Stage stage = (Stage) b.getScene().getWindow();

        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void back(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Scene-3-Monitor Housekeeping Status.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        Button b = (Button) actionEvent.getSource();
        Stage stage = (Stage) b.getScene().getWindow();

        stage.setScene(scene);
    }
}


