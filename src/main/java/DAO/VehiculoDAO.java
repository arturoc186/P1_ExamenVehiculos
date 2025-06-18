package DAO;

import POJOS.Vehiculo;

import java.sql.*;
import POJOS.Vehiculo;
import java.util.ArrayList;
import java.util.List;

public class VehiculoDAO {

    public List<Vehiculo> listarArticulos() throws SQLException {
        String SQL = "SELECT * FROM VEHICULO";

        List<Vehiculo> vehiculos = new ArrayList<>();
        try (Connection con = DBUtils.getConexion();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {

            while (rs.next()) {
                int id = (rs.getInt("id"));
                String marca = (rs.getString("marca"));
                String modelo = (rs.getString("modelo"));
                float precio = (rs.getFloat("precio"));

                Vehiculo v = new Vehiculo(id, marca, modelo, precio);

                vehiculos.add(v);
        }}
        return vehiculos;
    }

    public static List<Vehiculo> buscarFiltrados(String sql) {

        List<Vehiculo> listaFiltrada = new ArrayList<>();
        try (Connection con = DBUtils.getConexion();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int codigo = (rs.getInt("id"));
                String marca = (rs.getString("marca"));
                String modelo = (rs.getString("modelo"));
                float precio = (rs.getFloat("precio"));

                Vehiculo art = new Vehiculo(codigo, marca, modelo ,precio);

                listaFiltrada.add(art);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaFiltrada;
    }
}

