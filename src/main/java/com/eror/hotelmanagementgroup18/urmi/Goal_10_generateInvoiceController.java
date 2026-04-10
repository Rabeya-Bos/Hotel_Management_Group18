package com.eror.hotelmanagementgroup18.urmi;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class Goal_10_generateInvoiceController
{
    @javafx.fxml.FXML
    private TextField guestTF;
    @javafx.fxml.FXML
    private TableColumn<GenerateInvoice,Integer> nightCol;
    @javafx.fxml.FXML
    private TableColumn<GenerateInvoice,Integer> totalCol;
    @javafx.fxml.FXML
    private TextField nightTF;
    @javafx.fxml.FXML
    private TableView<GenerateInvoice> invoiceTV;
    @javafx.fxml.FXML
    private TableColumn<GenerateInvoice,Integer> guestCol;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void addInvoiceButtonOA(ActionEvent actionEvent) {
    }
}