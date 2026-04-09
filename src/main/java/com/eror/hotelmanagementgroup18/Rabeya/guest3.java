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

public class guest3 {

    // --- FXML Controls ---
    @FXML private TableView<MenuItem> menuTable;
    @FXML private TableColumn<MenuItem, Integer> itemIdCol;
    @FXML private TableColumn<MenuItem, String> itemNameCol;
    @FXML private TableColumn<MenuItem, String> itemDescCol;
    @FXML private TableColumn<MenuItem, String> itemCategoryCol;
    @FXML private TableColumn<MenuItem, Double> itemPriceCol;

    @FXML private ComboBox<String> mealCategoryCombo;
    @FXML private ComboBox<MenuItem> itemSelectCombo;
    @FXML private ComboBox<Integer> quantityCombo;
    @FXML private ComboBox<String> deliveryTimeCombo;
    @FXML private TextArea specialNotesArea;

    @FXML private TableView<CartItem> cartTable;
    @FXML private TableColumn<CartItem, String> cartItemCol;
    @FXML private TableColumn<CartItem, Integer> cartQtyCol;
    @FXML private TableColumn<CartItem, Double> cartPriceCol;
    @FXML private TableColumn<CartItem, Double> cartTotalCol;
    @FXML private Label cartTotalLabel;
    @FXML private Label orderConfirmationMsg;

    private List<CartItem> cart = new ArrayList<>();

    // --- MenuItem class ---
    public static class MenuItem implements Serializable {
        private int id;
        private String name;
        private String description;
        private String category;
        private double price;

        public MenuItem(int id, String name, String description, String category, double price) {
            this.id = id;
            this.name = name;
            this.description = description;
            this.category = category;
            this.price = price;
        }

        public int getId() { return id; }
        public String getName() { return name; }
        public String getDescription() { return description; }
        public String getCategory() { return category; }
        public double getPrice() { return price; }

        @Override
        public String toString() {
            return name + " ($" + price + ")";
        }
    }

    // --- CartItem class ---
    public static class CartItem implements Serializable {
        MenuItem item;
        int quantity;

        public CartItem(MenuItem item, int quantity) {
            this.item = item;
            this.quantity = quantity;
        }

        public String getItemName() { return item.getName(); }
        public int getQuantity() { return quantity; }
        public double getPrice() { return item.getPrice(); }
        public double getTotal() { return item.getPrice() * quantity; }
    }

    // --- Initialize UI ---
    @FXML
    public void initialize() {
        // ComboBoxes
        mealCategoryCombo.getItems().addAll("Breakfast", "Lunch", "Dinner", "Drinks");
        quantityCombo.getItems().addAll(1,2,3,4,5,6,7,8,9,10);
        deliveryTimeCombo.getItems().addAll("Morning", "Afternoon", "Evening");

        // Table columns - menu
        itemIdCol.setCellValueFactory(data -> new javafx.beans.property.SimpleIntegerProperty(data.getValue().getId()).asObject());
        itemNameCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getName()));
        itemDescCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getDescription()));
        itemCategoryCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getCategory()));
        itemPriceCol.setCellValueFactory(data -> new javafx.beans.property.SimpleDoubleProperty(data.getValue().getPrice()).asObject());

        // Table columns - cart
        cartItemCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getItemName()));
        cartQtyCol.setCellValueFactory(data -> new javafx.beans.property.SimpleIntegerProperty(data.getValue().getQuantity()).asObject());
        cartPriceCol.setCellValueFactory(data -> new javafx.beans.property.SimpleDoubleProperty(data.getValue().getPrice()).asObject());
        cartTotalCol.setCellValueFactory(data -> new javafx.beans.property.SimpleDoubleProperty(data.getValue().getTotal()).asObject());

        // Sample menu items
        List<MenuItem> menuItems = List.of(
                new MenuItem(1, "Pancakes", "Fluffy pancakes with syrup", "Breakfast", 8.5),
                new MenuItem(2, "Burger", "Beef burger with fries", "Lunch", 12.0),
                new MenuItem(3, "Steak", "Grilled steak with veggies", "Dinner", 25.0),
                new MenuItem(4, "Orange Juice", "Freshly squeezed", "Drinks", 4.0)
        );
        menuTable.getItems().addAll(menuItems);
        itemSelectCombo.getItems().addAll(menuItems);
    }

    // --- Add item to cart ---
    @FXML
    void addToCartBtn(ActionEvent event) {
        if (itemSelectCombo.getValue() == null || quantityCombo.getValue() == null) {
            orderConfirmationMsg.setText("Select an item and quantity!");
            return;
        }

        CartItem cartItem = new CartItem(itemSelectCombo.getValue(), quantityCombo.getValue());
        cart.add(cartItem);
        cartTable.getItems().add(cartItem);

        updateCartTotal();
        orderConfirmationMsg.setText("Item added to cart ✅");
    }

    private void updateCartTotal() {
        double total = 0;
        for (CartItem c : cart) total += c.getTotal();
        cartTotalLabel.setText("Total: $" + total);
    }

    // --- Place order ---
    @FXML
    void placeOrderBtn(ActionEvent event) {
        if (cart.isEmpty() || deliveryTimeCombo.getValue() == null) {
            orderConfirmationMsg.setText("Cart is empty or delivery time not selected!");
            return;
        }

        // Save order to binary
        try {
            File file = new File("orders.bin");
            ObjectOutputStream oos;
            if (file.exists()) {
                oos = new AppendableObjectOutputStream(new FileOutputStream(file,true));
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(file));
            }
            for (CartItem c : cart) oos.writeObject(c);
            oos.close();

            orderConfirmationMsg.setText("Order placed successfully! Total: " + cartTotalLabel.getText());
            cart.clear();
            cartTable.getItems().clear();
            updateCartTotal();
        } catch (Exception e) {
            orderConfirmationMsg.setText("Error saving order!");
            e.printStackTrace();
        }
    }

    // --- Scene switch back to dashboard ---
    @FXML
    void returnHomeBtn(ActionEvent actionEvent) throws IOException {
        Scene scene = ((Button) actionEvent.getSource()).getScene();
        Stage stage = (Stage) scene.getWindow();

        FXMLLoader scene2FxmlLoader = new FXMLLoader(guestDashboard.class.getResource("/com/eror/hotelmanagementgroup18/Rabeya/guestDashboard.fxml"));
        Scene scene2 = new Scene(scene2FxmlLoader.load());
        stage.setScene(scene2);
    }

    // --- Custom ObjectOutputStream to append objects ---
    static class AppendableObjectOutputStream extends ObjectOutputStream {
        public AppendableObjectOutputStream(OutputStream out) throws IOException { super(out); }
        @Override
        protected void writeStreamHeader() throws IOException { reset(); }
    }
}