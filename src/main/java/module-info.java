module com.example.p1_examenvehiculos {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens Principal     to javafx.fxml;
    opens Controladores to javafx.fxml;
    opens POJOS to javafx.base;

    exports Principal to javafx.graphics;
}
