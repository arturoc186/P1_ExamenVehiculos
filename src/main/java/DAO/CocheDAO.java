package DAO;

import POJOS.Coche;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CocheDAO {

    public void insertar(Coche coche) throws SQLException {
        String SQL = "INSERT INTO VEHICULO (tipo, marca, modelo, precio, num_puertas, tipo_combustible) VALUES (?,?,?,?,?,?)";

        try (Connection con = DBUtils.getConexion();
             PreparedStatement ps = con.prepareStatement(SQL)){

            ps.setString(1, "Coche");
            ps.setString(2, coche.getMarca());
            ps.setString(3, coche.getModelo());
            ps.setFloat(4, coche.getPrecio());
            ps.setInt(5, coche.getNumPuertas());
            ps.setString(6, coche.getTipoCombustible());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Se ha producido un error en la inserción", e);
        }
    }
}
