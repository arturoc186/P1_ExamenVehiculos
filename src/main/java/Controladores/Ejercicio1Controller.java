package Controladores;

import DAO.VehiculoDAO;
import POJOS.Vehiculo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class Ejercicio1Controller implements Initializable {

    private ObservableList<Vehiculo> vehiculosObs;

    @FXML private TableView<Vehiculo> tablaVehiculos;
        @FXML private TableColumn<Vehiculo, Integer> colID;
        @FXML private TableColumn<Vehiculo, String> colMarca;
        @FXML private TableColumn<Vehiculo, String> colModelo;
        @FXML private TableColumn<Vehiculo, Float> colPrecio;

    VehiculoDAO DAO = new VehiculoDAO();

    @Override
    public void initialize(URL location, ResourceBundle resources){

        vehiculosObs = FXCollections.observableArrayList(Vehiculo.vehiculos);

        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        colModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));

        try{
            List<Vehiculo> lista = DAO.listarArticulos();
            ObservableList<Vehiculo> obs = FXCollections.observableArrayList(lista);
            tablaVehiculos.setItems(obs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }
}
