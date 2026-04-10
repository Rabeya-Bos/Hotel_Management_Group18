package com.eror.hotelmanagementgroup18.arpita;

import com.eror.hotelmanagementgroup18.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class Goal3LostFound {

    @javafx.fxml.FXML private CheckBox CBAditionalInfo;
    @javafx.fxml.FXML private TextField TXTFoundLocation;
    @javafx.fxml.FXML private TextArea TextArea;
    @javafx.fxml.FXML private TextField TXTItemName;
    @javafx.fxml.FXML private RadioButton RBStatus;
    @javafx.fxml.FXML private DatePicker DateFound;
    @javafx.fxml.FXML private ComboBox<String> CmbItemCategory;

    @javafx.fxml.FXML private TableView<LostFound_Goal3> TableView1;
    @javafx.fxml.FXML private TableColumn<LostFound_Goal3, Integer> ColItemid;
    @javafx.fxml.FXML private TableColumn<LostFound_Goal3, String> ColName, ColCategory, ColLocation, ColDate, ColStatus, ColValuable;

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

        CmbItemCategory.getItems().addAll("Electronics", "Clothing", "Documents", "Accessories", "Other");

        loadData();
    }


    private void loadData() {
        TableView1.getItems().clear();
        File file = new File("lostfound.bin");

        if (file.exists() && file.length() > 0) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
                ArrayList<LostFound_Goal3> list = (ArrayList<LostFound_Goal3>) in.readObject();
                TableView1.getItems().addAll(list);


                for (LostFound_Goal3 item : list) {
                    if (item.getItemId() >= idCounter) idCounter = item.getItemId() + 1;
                }
            } catch (Exception e) {
                System.err.println("Load Error: " + e.getMessage());
            }
        }
    }

    @javafx.fxml.FXML
    public void SaveItemOA(ActionEvent actionEvent) {
        if (TXTItemName.getText().isEmpty() || TXTFoundLocation.getText().isEmpty() ||
                DateFound.getValue() == null || CmbItemCategory.getValue() == null) return;

        LostFound_Goal3 newItem = new LostFound_Goal3(
                idCounter++,
                TXTItemName.getText(),
                CmbItemCategory.getValue(),
                TXTFoundLocation.getText(),
                DateFound.getValue().toString(),
                RBStatus.isSelected() ? "Found" : "Claimed",
                CBAditionalInfo.isSelected() ? "Yes" : "No"
        );


        File file = new File("lostfound.bin");
        ArrayList<LostFound_Goal3> list = new ArrayList<>();

        try {
            if (file.exists() && file.length() > 0) {
                try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
                    list = (ArrayList<LostFound_Goal3>) in.readObject();
                }
            }
            list.add(newItem);
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
                out.writeObject(list);
            }
            loadData();
            ClearOA(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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



    private void rewriteFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("lostfound.bin"))) {
            ArrayList<LostFound_Goal3> list = new ArrayList<>(TableView1.getItems());
            out.writeObject(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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

    @javafx.fxml.FXML
    public void NextOA(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Goal4-UpdateProfile.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception e) {
            System.err.println("Navigation Error: " + e.getMessage());
        }
    }

    @javafx.fxml.FXML
    public void BackOA(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Goal2-ReportMaintenanceIssue.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception e) {
            System.err.println("Navigation Error: " + e.getMessage());
        }
    }
}