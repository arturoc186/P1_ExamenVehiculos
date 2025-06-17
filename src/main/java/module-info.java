module com.example.p1_examenvehiculos {
    requires javafx.controls;
    requires javafx.fxml;

    opens Principal     to javafx.fxml;
    opens Controladores to javafx.fxml;

    exports Principal to javafx.graphics;
}
