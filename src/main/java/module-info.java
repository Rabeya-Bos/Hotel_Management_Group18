module com.spring26.section2.group18.hotel_management_group18 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.spring26.section2.group18.hotel_management_group18 to javafx.fxml;
    exports com.spring26.section2.group18.hotel_management_group18;
}