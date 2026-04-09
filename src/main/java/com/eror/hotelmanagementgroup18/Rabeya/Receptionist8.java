package com.eror.hotelmanagementgroup18.Rabeya;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Receptionist8 {

    @FXML private TableView<BillItem> billTable;
    @FXML private TableColumn<BillItem, String> itemCol;
    @FXML private TableColumn<BillItem, String> descriptionCol;
    @FXML private TableColumn<BillItem, Double> amountCol;

    @FXML private Label subtotalLabel;
    @FXML private Label taxLabel;
    @FXML private Label totalLabel;
    @FXML private Label confirmationMsg;

    @FXML private TextField guestIdField;
    @FXML private ComboBox<String> paymentMethodCombo;
    @FXML private ComboBox<String> giftCombo;
    @FXML private TextArea feedbackArea;
    @FXML private Button requestFeedbackBtn;

    private List<BillItem> billItems = new ArrayList<>();

    // --- BillItem class ---
    public static class BillItem implements Serializable {
        String item;
        String description;
        double amount;

        public BillItem(String item, String description, double amount) {
            this.item = item;
            this.description = description;
            this.amount = amount;
        }

        public String getItem() { return item; }
        public String getDescription() { return description; }
        public double getAmount() { return amount; }
    }

    // --- Payment class ---
    public static class Payment implements Serializable {
        String guestId;
        String paymentMethod;
        String gift;
        List<BillItem> items;
        double subtotal;
        double tax;
        double total;
        String feedback;

        public Payment(String guestId, String paymentMethod, String gift, List<BillItem> items,
                       double subtotal, double tax, double total, String feedback) {
            this.guestId = guestId;
            this.paymentMethod = paymentMethod;
            this.gift = gift;
            this.items = items;
            this.subtotal = subtotal;
            this.tax = tax;
            this.total = total;
            this.feedback = feedback;
        }
    }

    @FXML
    public void initialize() {
        itemCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getItem()));
        descriptionCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getDescription()));
        amountCol.setCellValueFactory(data -> new javafx.beans.property.SimpleDoubleProperty(data.getValue().getAmount()).asObject());

        paymentMethodCombo.getItems().addAll("Cash", "Credit Card", "Debit Card", "Online");
        giftCombo.getItems().addAll("None", "Flowers", "Chocolates", "Voucher");

        // Sample bill items
        billItems.add(new BillItem("Room Charge", "Deluxe Room - 2 nights", 200.0));
        billItems.add(new BillItem("Meal", "Breakfast & Lunch", 50.0));
        billTable.getItems().addAll(billItems);
        updateTotals();
    }

    // --- Load bill (refresh TableView) ---
    @FXML
    void loadBillBtn(ActionEvent event) {
        billTable.getItems().clear();
        billTable.getItems().addAll(billItems);
        updateTotals();
        confirmationMsg.setText("Bill loaded ✅");
    }

    private void updateTotals() {
        double subtotal = billItems.stream().mapToDouble(BillItem::getAmount).sum();
        double tax = subtotal * 0.1; // 10% tax
        double total = subtotal + tax;

        subtotalLabel.setText(String.format("$%.2f", subtotal));
        taxLabel.setText(String.format("$%.2f", tax));
        totalLabel.setText(String.format("$%.2f", total));
    }

    // --- Process payment ---
    @FXML
    void processPaymentBtn(ActionEvent event) {
        if (guestIdField.getText().isEmpty() || paymentMethodCombo.getValue() == null) {
            confirmationMsg.setText("Guest ID and Payment Method are required!");
            return;
        }

        Payment payment = new Payment(
                guestIdField.getText(),
                paymentMethodCombo.getValue(),
                giftCombo.getValue() != null ? giftCombo.getValue() : "None",
                new ArrayList<>(billItems),
                Double.parseDouble(subtotalLabel.getText().replace("$", "")),
                Double.parseDouble(taxLabel.getText().replace("$", "")),
                Double.parseDouble(totalLabel.getText().replace("$", "")),
                feedbackArea.getText()
        );

        // Save payment to binary file
        try {
            File file = new File("payments.bin");
            ObjectOutputStream oos;
            if (file.exists()) {
                oos = new AppendableObjectOutputStream(new FileOutputStream(file,true));
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(file));
            }
            oos.writeObject(payment);
            oos.close();
            confirmationMsg.setText("Payment processed ✅");
        } catch (Exception e) {
            confirmationMsg.setText("Error saving payment!");
            e.printStackTrace();
        }
    }

    // --- Email invoice (dummy) ---
    @FXML
    void emailInvoiceBtn(ActionEvent event) {
        if (guestIdField.getText().isEmpty()) {
            confirmationMsg.setText("Enter Guest ID to email invoice!");
            return;
        }
        confirmationMsg.setText("Invoice emailed to guest ✅");
    }

    // --- Scene switch back to dashboard ---
    @FXML
    void homeBtn(ActionEvent actionEvent) throws IOException {
        Scene scene = ((Button) actionEvent.getSource()).getScene();
        Stage stage = (Stage) scene.getWindow();

        FXMLLoader scene2FxmlLoader = new FXMLLoader(guestDashboard.class.getResource("/com/eror/hotelmanagementgroup18/Rabeya/ReceptionistDashboard.fxml"));
        Scene scene2 = new Scene(scene2FxmlLoader.load());
        stage.setScene(scene2);
    }

    // --- Request feedback ---
    @FXML
    void requestFeedbackBtn(ActionEvent event) {
        if (feedbackArea.getText().isEmpty()) {
            confirmationMsg.setText("Please enter feedback first!");
            return;
        }
        confirmationMsg.setText("Feedback submitted ✅");
    }

    // --- Appendable ObjectOutputStream ---
    static class AppendableObjectOutputStream extends ObjectOutputStream {
        public AppendableObjectOutputStream(OutputStream out) throws IOException { super(out); }
        @Override
        protected void writeStreamHeader() throws IOException { reset(); }
    }
}