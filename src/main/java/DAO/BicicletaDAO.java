package DAO;

import POJOS.Bicicleta;
import POJOS.Coche;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BicicletaDAO {

    public void insertar(Bicicleta bici) throws SQLException {
        String SQL = "INSERT INTO VEHICULO (tipo, marca, modelo, precio, tipo_bicicleta, tiene_cambio) VALUES (?,?,?,?,?,?)";

        try (Connection con = DBUtils.getConexion();
             PreparedStatement ps = con.prepareStatement(SQL)){

            ps.setString(1, "Bicicleta");
            ps.setString(2, bici.getMarca());
            ps.setString(3, bici.getModelo());
            ps.setFloat(4, bici.getPrecio());
            ps.setString(5, bici.getTipo());
            ps.setBoolean(6, bici.isTieneCambio());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Se ha producido un error en la inserción", e);
        }
    }
}
