package Controladores;

import DAO.VehiculoDAO;
import POJOS.Vehiculo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class Ejercicio1Controller implements Initializable {


    @FXML private Button btnEliminar;

    @FXML private TableView<Vehiculo> tablaVehiculos;
        @FXML private TableColumn<Vehiculo, Integer> colID;
        @FXML private TableColumn<Vehiculo, String> colMarca;
        @FXML private TableColumn<Vehiculo, String> colModelo;
        @FXML private TableColumn<Vehiculo, Float> colPrecio;

    public Ejercicio1Controller() throws SQLException {}

    VehiculoDAO DAO = new VehiculoDAO();
    List<Vehiculo> lista = DAO.listarArticulos();
    ObservableList<Vehiculo> obs = FXCollections.observableArrayList(lista);

    @Override
    public void initialize(URL location, ResourceBundle resources){

        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        colModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));

        tablaVehiculos.setItems(obs);
    }

    @FXML
    void btnEliminarClick(ActionEvent event) {
        Vehiculo seleccionado = tablaVehiculos.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            obs.remove(seleccionado);
            System.out.println("Se ha eliminado de la tabla: " + seleccionado.getMarca());
            tablaVehiculos.setItems(obs);
        } else {
            System.out.println("Se ha dado al botón eliminar sin seleccionar un artículo.");
        }
    }
}
