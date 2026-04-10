module com.eror.hotelmanagementgroup18 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.eror.hotelmanagementgroup18.arpita to javafx.fxml;
    exports com.eror.hotelmanagementgroup18.arpita;

    opens com.eror.hotelmanagementgroup18 to javafx.fxml;
    exports com.eror.hotelmanagementgroup18;
}