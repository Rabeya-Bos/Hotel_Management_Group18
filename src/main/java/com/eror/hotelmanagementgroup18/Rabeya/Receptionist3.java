package com.eror.hotelmanagementgroup18.Rabeya;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Receptionist3 {

    @FXML private TableView<Butler> butlersTable;
    @FXML private TableColumn<Butler, String> nameCol;
    @FXML private TableColumn<Butler, String> specializationCol;
    @FXML private TableColumn<Butler, String> statusCol;

    @FXML private ComboBox<Butler> butlerSelectCombo;
    @FXML private TextField searchGuestField;
    @FXML private TextArea preferencesArea;
    @FXML private DatePicker startDatePicker;
    @FXML private Label confirmationMsg;
    @FXML private Label vipTierLabel;

    private List<Butler> butlers = new ArrayList<>();
    private List<VIPAssignment> assignments = new ArrayList<>();

    // --- Butler class ---
    public static class Butler implements Serializable {
        String name;
        String specialization;
        String status;

        public Butler(String name, String specialization, String status) {
            this.name = name;
            this.specialization = specialization;
            this.status = status;
        }

        public String getName() { return name; }
        public String getSpecialization() { return specialization; }
        public String getStatus() { return status; }

        @Override
        public String toString() { return name + " (" + specialization + ")"; }
    }

    // --- VIP Assignment class ---
    public static class VIPAssignment implements Serializable {
        String guestName;
        String vipTier;
        Butler butler;
        LocalDate startDate;
        String preferences;

        public VIPAssignment(String guestName, String vipTier, Butler butler,
                             LocalDate startDate, String preferences) {
            this.guestName = guestName;
            this.vipTier = vipTier;
            this.butler = butler;
            this.startDate = startDate;
            this.preferences = preferences;
        }
    }

    @FXML
    public void initialize() {
        // Sample butlers
        butlers.add(new Butler("James", "Luxury Service", "Available"));
        butlers.add(new Butler("Anna", "VIP Events", "Available"));
        butlers.add(new Butler("Robert", "Concierge", "Busy"));

        butlersTable.getItems().addAll(butlers);
        butlerSelectCombo.getItems().addAll(butlers);

        nameCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getName()));
        specializationCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getSpecialization()));
        statusCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getStatus()));
    }

    // --- Search guest ---
    @FXML
    void searchGuestBtn(ActionEvent event) {
        if (searchGuestField.getText().isEmpty()) {
            confirmationMsg.setText("Enter guest name to search!");
            return;
        }

        // Dummy VIP tier & preferences for example
        vipTierLabel.setText("Gold Tier");
        preferencesArea.setText("Prefers early breakfast and luxury car transfer.");
        confirmationMsg.setText("Guest found ✅");
    }

    // --- Assign butler ---
    @FXML
    void assignBtn(ActionEvent event) {
        if (searchGuestField.getText().isEmpty() || butlerSelectCombo.getValue() == null || startDatePicker.getValue() == null) {
            confirmationMsg.setText("Fill guest, butler, and start date!");
            return;
        }

        VIPAssignment assignment = new VIPAssignment(
                searchGuestField.getText(),
                vipTierLabel.getText(),
                butlerSelectCombo.getValue(),
                startDatePicker.getValue(),
                preferencesArea.getText()
        );

        assignments.add(assignment);

        // Save assignment to binary file
        try {
            File file = new File("vipAssignments.bin");
            ObjectOutputStream oos;
            if (file.exists()) {
                oos = new AppendableObjectOutputStream(new FileOutputStream(file,true));
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(file));
            }
            oos.writeObject(assignment);
            oos.close();
            confirmationMsg.setText("Butler assigned successfully ✅");
        } catch (Exception e) {
            confirmationMsg.setText("Error saving assignment!");
            e.printStackTrace();
        }
    }

    // --- Scene switch back ---
    @FXML
    void homeBtn(ActionEvent actionEvent) throws IOException {
        Scene scene = ((Button) actionEvent.getSource()).getScene();
        Stage stage = (Stage) scene.getWindow();

        FXMLLoader scene2FxmlLoader = new FXMLLoader(guestDashboard.class.getResource("/com/eror/hotelmanagementgroup18/Rabeya/ReceptionistDashboard.fxml"));
        Scene scene2 = new Scene(scene2FxmlLoader.load());
        stage.setScene(scene2);
    }

    // --- Custom appendable stream ---
    static class AppendableObjectOutputStream extends ObjectOutputStream {
        public AppendableObjectOutputStream(OutputStream out) throws IOException { super(out); }
        @Override
        protected void writeStreamHeader() throws IOException { reset(); }
    }
}