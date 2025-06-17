package Principal;

import DAO.DBUtils;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException, SQLException {
        Connection conn = DBUtils.getConexion();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 70);
        stage.setTitle("Examen de Vehículos");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}