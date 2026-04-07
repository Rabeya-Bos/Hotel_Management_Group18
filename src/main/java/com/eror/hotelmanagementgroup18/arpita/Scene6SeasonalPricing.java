package com.eror.hotelmanagementgroup18.arpita;

import com.eror.hotelmanagementgroup18.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;

public class Scene6SeasonalPricing {

    @javafx.fxml.FXML
    private ComboBox<String> CmbSeason;

    @javafx.fxml.FXML
    private TextField TXTPrice;

    @javafx.fxml.FXML
    private DatePicker DPStartDate;

    @javafx.fxml.FXML
    private DatePicker DPEndDate;

    @javafx.fxml.FXML
    private TableColumn<SeasonalPricing_Scene6, String> ColStartDate;

    @javafx.fxml.FXML
    private TableColumn<SeasonalPricing_Scene6, String> ColEndDate;

    @javafx.fxml.FXML
    private TableColumn<SeasonalPricing_Scene6, Double> ColPrice;

    @javafx.fxml.FXML
    private Label LVLResult;

    @javafx.fxml.FXML
    private TableView<SeasonalPricing_Scene6> TableView1;

    @javafx.fxml.FXML
    public void initialize() {

        ColStartDate.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        ColEndDate.setCellValueFactory(new PropertyValueFactory<>("endDate"));
        ColPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        CmbSeason.getItems().addAll("Summer", "Winter", "Festival", "Off-Season");

        loadData();
    }

    //  Load data
    private void loadData() {

        TableView1.getItems().clear();

        try (ObjectInputStream stream =
                     new ObjectInputStream(new FileInputStream("season.bin"))) {

            while (true) {
                SeasonalPricing_Scene6 s = (SeasonalPricing_Scene6) stream.readObject();
                TableView1.getItems().add(s);
            }

        } catch (EOFException e) {
            // end of file → normal
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //  Save Pricing
    @javafx.fxml.FXML
    public void SaveOA(ActionEvent actionEvent) {

        if (CmbSeason.getValue() == null ||
                DPStartDate.getValue() == null ||
                DPEndDate.getValue() == null ||
                TXTPrice.getText().isEmpty()) {

            LVLResult.setText("Fill all fields!");
            return;
        }

        LocalDate start = DPStartDate.getValue();
        LocalDate end = DPEndDate.getValue();

        if (end.isBefore(start)) {
            LVLResult.setText("End date must be after start date!");
            return;
        }

        double price;

        try {
            price = Double.parseDouble(TXTPrice.getText()); // ✅ safe parsing
        } catch (NumberFormatException e) {
            LVLResult.setText("Invalid price!");
            return;
        }

        SeasonalPricing_Scene6 sp =
                new SeasonalPricing_Scene6(start.toString(), end.toString(), price);

        //  Save (append safely)
        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream("season.bin", true)) {

                         @Override
                         protected void writeStreamHeader() throws IOException {
                             reset();
                         }
                     }) {

            out.writeObject(sp);

        } catch (Exception e) {
            e.printStackTrace();
            LVLResult.setText("Error saving data!");
            return;
        }

        LVLResult.setText("Pricing Saved!");

        loadData();

        //  clear fields
        TXTPrice.clear();
        CmbSeason.setValue(null);
        DPStartDate.setValue(null);
        DPEndDate.setValue(null);
    }


    @javafx.fxml.FXML
    public void next(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Scene-7-Apply Discount.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        Button b = (Button) actionEvent.getSource();
        Stage stage = (Stage) b.getScene().getWindow();

        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void back(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Scene- 5- Late Check-Out Requests.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        Button b = (Button) actionEvent.getSource();
        Stage stage = (Stage) b.getScene().getWindow();

        stage.setScene(scene);
    }
}