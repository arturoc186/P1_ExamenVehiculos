package Controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    @FXML private Button btnEjercicio1;
    @FXML private Button btnEjercicio2;

    @FXML
    public void btnEjercicio1Click(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ejercicio1.fxml"));
        Parent root = loader.load();
        Stage modalStage = new Stage();
        modalStage.setTitle("Examen de Vehículos · Ejercicio 1");
        modalStage.initModality(Modality.APPLICATION_MODAL);
        Stage ownerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        modalStage.initOwner(ownerStage);
        modalStage.setScene(new Scene(root));
        modalStage.showAndWait();
    }

    @FXML
    public void btnEjercicio2Click(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ejercicio2.fxml"));
        Parent root = loader.load();
        Stage modalStage = new Stage();
        modalStage.setTitle("Examen de Vehículos · Ejercicio 2");
        modalStage.initModality(Modality.APPLICATION_MODAL);
        Stage ownerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        modalStage.initOwner(ownerStage);
        modalStage.setScene(new Scene(root));
        modalStage.showAndWait();
    }
}