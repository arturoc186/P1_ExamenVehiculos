package DAO;

import POJOS.Coche;
import POJOS.Moto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MotoDAO {

    public void insertar(Moto moto) throws SQLException {
        String SQL = "INSERT INTO VEHICULO (tipo, marca, modelo, precio, cilindrada, tiene_sidecar) VALUES (?,?,?,?,?,?);";

        try (Connection con = DBUtils.getConexion();
             PreparedStatement ps = con.prepareStatement(SQL)){

            ps.setString(1, "Moto");
            ps.setString(2, moto.getMarca());
            ps.setString(3, moto.getModelo());
            ps.setFloat(4, moto.getPrecio());
            ps.setInt(5, moto.getCilindrada());
            ps.setBoolean(6, moto.isTieneSidecar());

            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException("Se ha producido un error en la inserción", e);
        }
    }
}
