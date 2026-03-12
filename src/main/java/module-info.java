module com.example.ventana {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.ventana to javafx.fxml;
    exports com.example.ventana;
    exports com.example.ventana.controller;
    opens com.example.ventana.controller to javafx.fxml;
}