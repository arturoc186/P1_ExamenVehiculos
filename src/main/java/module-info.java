module com.example.p1_examenvehiculos {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.p1_examenvehiculos to javafx.fxml;
    exports com.example.p1_examenvehiculos;
    exports Principal;
    opens Principal to javafx.fxml;
    exports Controladores;
    opens Controladores to javafx.fxml;
}