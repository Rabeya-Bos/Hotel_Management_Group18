module com.eror.hotelmanagementgroup18 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.eror.hotelmanagementgroup18 to javafx.fxml;
    opens com.eror.hotelmanagementgroup18.Rabeya to javafx.fxml;
    exports com.eror.hotelmanagementgroup18;
//    exports com.eror.hotelmanagementgroup18.arpita;
//    opens com.eror.hotelmanagementgroup18.arpita to javafx.fxml;

    opens com.eror.hotelmanagementgroup18.Sumon to javafx.fxml;
    exports com.eror.hotelmanagementgroup18.Sumon;
}