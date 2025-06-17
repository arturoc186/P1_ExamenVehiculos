package Controladores;

import DAO.BicicletaDAO;
import DAO.CocheDAO;
import DAO.MotoDAO;
import DAO.VehiculoDAO;
import POJOS.Bicicleta;
import POJOS.Coche;
import POJOS.Moto;
import POJOS.Vehiculo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class Ejercicio1Controller implements Initializable {


    @FXML private Button btnEliminar;
    @FXML private TextField fieldMarca;
    @FXML private TextField fieldModelo;
    @FXML private TextField fieldNumPuertas;
    @FXML private TextField fieldPrecio;
    @FXML private Button btnInsertar;
    @FXML private CheckBox chkCambio;
    @FXML private TextField fieldCilindrada;
    @FXML private ComboBox<String> chkCombustible;
    @FXML private CheckBox chkSidecar;
    @FXML private ComboBox<String> chkTipo;
    @FXML private ComboBox<String> chkTipoBicicleta;

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

        chkTipo.getItems().addAll("Moto", "Bicicleta", "Coche");
        chkTipoBicicleta.getItems().addAll("Montaña", "Carretera", "Paseo");
        chkCombustible.getItems().addAll("Gasolina", "Diésel", "Eléctrico");

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

    @FXML
    void btnInsertarClick(ActionEvent event) throws SQLException {
        if (chkTipo.getValue().equals("Coche")){
            CocheDAO CocheDAO = new CocheDAO();

            Coche coche = new Coche();
                coche.setMarca(fieldMarca.getText());
                coche.setModelo(fieldModelo.getText());
                coche.setPrecio(Float.parseFloat(fieldPrecio.getText()));
                coche.setNumPuertas(Integer.parseInt(fieldNumPuertas.getText()));
                coche.setTipoCombustible(chkCombustible.getValue().toString());

            CocheDAO.insertar(coche);

        } else if (chkTipo.getValue().equals("Moto")) {

            MotoDAO MotoDAO = new MotoDAO();

            Moto moto = new Moto();
            moto.setMarca(fieldMarca.getText());
            moto.setModelo(fieldModelo.getText());
            moto.setPrecio(Float.parseFloat(fieldPrecio.getText()));
            moto.setCilindrada(Integer.parseInt(fieldCilindrada.getText()));
            moto.setTieneSidecar(chkSidecar.isSelected());

            MotoDAO.insertar(moto);

        } else {
            BicicletaDAO BiciDAO = new BicicletaDAO();

            Bicicleta bici = new Bicicleta();
            bici.setMarca(fieldMarca.getText());
            bici.setModelo(fieldModelo.getText());
            bici.setPrecio(Float.parseFloat(fieldPrecio.getText()));
            bici.setTipo(chkTipoBicicleta.getValue().toString());
            bici.setTieneCambio(chkCambio.isSelected());

            BiciDAO.insertar(bici);
        }
    }
}
