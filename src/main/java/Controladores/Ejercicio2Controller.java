package Controladores;

import DAO.VehiculoDAO;
import POJOS.Vehiculo;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class Ejercicio2Controller implements Initializable {

    @FXML
    private Button btnBuscar;

    @FXML
    private Button btnCerrar;

    @FXML
    private ComboBox<String> cbMarca;

    @FXML
    private ComboBox<String> cbVehiculo;

    @FXML
    private CheckBox chkMarca;

    @FXML
    private CheckBox chkPrecio;

    @FXML
    private CheckBox chkTipo;

    @FXML
    private TableColumn<?, ?> colID;

    @FXML
    private TableColumn<?, ?> colMarca;

    @FXML
    private TableColumn<?, ?> colModelo;

    @FXML
    private TableColumn<?, ?> colPrecio;

    @FXML
    private TextField fieldMax;

    @FXML
    private TextField fieldMin;

    @FXML
    private TableView<Vehiculo> tablaVehiculos;

    @FXML
    void btnBuscarClick(ActionEvent event) {
        String sql = "SELECT id, marca, modelo, precio FROM VEHICULO WHERE 1=1";

        if(chkTipo.isSelected()){
            String tipo = cbVehiculo.getValue();
            sql += " AND tipo = '" + tipo + "'";
        }

        if(chkPrecio.isSelected()){
            float min = Float.parseFloat(fieldMin.getText());
            float max = Float.parseFloat(fieldMax.getText());
            sql += " AND precio BETWEEN " + min + " AND " + max;
        }

        if(chkMarca.isSelected()){
            String marca = cbMarca.getValue();
            sql += " AND marca = '" + marca + "'";
        }

        List<Vehiculo> resultados = VehiculoDAO.buscarFiltrados(sql);
        ObservableList<Vehiculo> obsResultados = FXCollections.observableArrayList(resultados);

        if (obsResultados.isEmpty()) {
            System.out.println("No se han encontrado artículos con esos criterios.");
        } else {
            tablaVehiculos.setItems(obsResultados);
        }

    }

    @FXML
    void btnCerrarClick(ActionEvent event) {
        ((Stage) btnCerrar.getScene().getWindow()).close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        cbVehiculo.getItems().setAll("Moto", "Coche", "Bicicleta");
        cbMarca.getItems().setAll("Toyota", "Ford", "Tesla", "Honda", "Yamaha", "Ducati", "Specialized", "Trek", "Brompton");

        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        colModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
    }
}
