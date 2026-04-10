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

public class Goal3LostFound {

    @javafx.fxml.FXML
    private CheckBox CBAditionalInfo;
    @javafx.fxml.FXML
    private TextField TXTFoundLocation;
    @javafx.fxml.FXML
    private TextArea TextArea;
    @javafx.fxml.FXML
    private TextField TXTItemName;
    @javafx.fxml.FXML
    private RadioButton RBStatus;
    @javafx.fxml.FXML
    private DatePicker DateFound;
    @javafx.fxml.FXML
    private ComboBox<String> CmbItemCategory;

    @javafx.fxml.FXML
    private TableColumn<LostFound_Goal3, Integer> ColItemid;
    @javafx.fxml.FXML
    private TableColumn<LostFound_Goal3, String> ColName;
    @javafx.fxml.FXML
    private TableColumn<LostFound_Goal3, String> ColCategory;
    @javafx.fxml.FXML
    private TableColumn<LostFound_Goal3, String> ColLocation;
    @javafx.fxml.FXML
    private TableColumn<LostFound_Goal3, String> ColDate;
    @javafx.fxml.FXML
    private TableColumn<LostFound_Goal3, String> ColStatus;
    @javafx.fxml.FXML
    private TableColumn<LostFound_Goal3, String> ColValuable;

    @javafx.fxml.FXML
    private TableView<LostFound_Goal3> TableView1;

    private int idCounter = 1;

    @javafx.fxml.FXML
    public void initialize() {

        ColItemid.setCellValueFactory(new PropertyValueFactory<>("itemId"));
        ColName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        ColCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        ColLocation.setCellValueFactory(new PropertyValueFactory<>("location"));
        ColDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        ColStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        ColValuable.setCellValueFactory(new PropertyValueFactory<>("valuable"));

        CmbItemCategory.getItems().addAll(
                "Electronics", "Clothing", "Documents", "Accessories", "Other"
        );

        loadData();
    }

    //  Load from file
    private void loadData() {
        TableView1.getItems().clear();

        try (ObjectInputStream in =
                     new ObjectInputStream(new FileInputStream("lostfound.bin"))) {

            while (true) {
                LostFound_Goal3 item = (LostFound_Goal3) in.readObject();
                TableView1.getItems().add(item);
                idCounter = Math.max(idCounter, item.getItemId() + 1);
            }

        } catch (EOFException e) {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //  Save Item
    @javafx.fxml.FXML
    public void SaveItemOA(ActionEvent actionEvent) {

        if (TXTItemName.getText().isEmpty() ||
                TXTFoundLocation.getText().isEmpty() ||
                DateFound.getValue() == null ||
                CmbItemCategory.getValue() == null) {
            return;
        }

        String status = RBStatus.isSelected() ? "Found" : "Claimed";
        String valuable = CBAditionalInfo.isSelected() ? "Yes" : "No";

        LostFound_Goal3 item = new LostFound_Goal3(
                idCounter++,
                TXTItemName.getText(),
                CmbItemCategory.getValue(),
                TXTFoundLocation.getText(),
                DateFound.getValue().toString(),
                status,
                valuable
        );

        // save
        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream("lostfound.bin", true)) {

                         @Override
                         protected void writeStreamHeader() throws IOException {
                             reset();
                         }
                     }) {
            out.writeObject(item);
        } catch (Exception e) {
            e.printStackTrace();
        }

        loadData();
        ClearOA(null);
    }

    //  Update
    @javafx.fxml.FXML
    public void UpdateOA(ActionEvent actionEvent) {

        LostFound_Goal3 selected = TableView1.getSelectionModel().getSelectedItem();
        if (selected == null) return;

        selected.setItemName(TXTItemName.getText());
        selected.setCategory(CmbItemCategory.getValue());
        selected.setLocation(TXTFoundLocation.getText());
        selected.setDate(DateFound.getValue().toString());
        selected.setStatus(RBStatus.isSelected() ? "Found" : "Claimed");
        selected.setValuable(CBAditionalInfo.isSelected() ? "Yes" : "No");

        rewriteFile();
        loadData();
    }

    //  Delete
    @javafx.fxml.FXML
    public void DeleteOA(ActionEvent actionEvent) {

        LostFound_Goal3 selected = TableView1.getSelectionModel().getSelectedItem();
        if (selected == null) return;

        TableView1.getItems().remove(selected);
        rewriteFile();
    }

    //  Rewrite full file (for update/delete)
    private void rewriteFile() {

        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream("lostfound.bin"))) {

            for (LostFound_Goal3 item : TableView1.getItems()) {
                out.writeObject(item);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //  Clear
    @javafx.fxml.FXML
    public void ClearOA(ActionEvent actionEvent) {

        TXTItemName.clear();
        TXTFoundLocation.clear();
        TextArea.clear();
        DateFound.setValue(null);
        CmbItemCategory.setValue(null);
        RBStatus.setSelected(false);
        CBAditionalInfo.setSelected(false);
    }

    @Deprecated
    public void next(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Goal 4-UpdateProfile.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        Button b = (Button) actionEvent.getSource();
        Stage stage = (Stage) b.getScene().getWindow();

        stage.setScene(scene);
    }

    @Deprecated
    public void back(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Goal 2-ReportMaintenanceIssue.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        Button b = (Button) actionEvent.getSource();
        Stage stage = (Stage) b.getScene().getWindow();

        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void NextOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void BackOA(ActionEvent actionEvent) {
    }
}