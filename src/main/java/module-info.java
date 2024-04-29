module com.example.jogodogalo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.jogodogalo to javafx.fxml;
    exports com.example.jogodogalo;
}