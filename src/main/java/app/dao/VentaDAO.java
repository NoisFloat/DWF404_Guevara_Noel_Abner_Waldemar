package app.dao;

import app.models.Conexion;
import app.models.Venta;
import app.models.Videojuego;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.sql.SQLException;
import java.util.ArrayList;

@Named
@RequestScoped
public class VentaDAO extends Conexion {

    public ArrayList<Venta> findAll() throws SQLException {
        connect();
        stmt = conn.createStatement();
        resultSet = stmt.executeQuery("SELECT * FROM venta as v INNER JOIN videojuego vi\n" +
                "ON v.videojuego_id = vi.id;");
        ArrayList<Venta> Ventas = new ArrayList();

        while (resultSet.next()) {
            Venta tmp = new Venta();
            tmp.setId(resultSet.getInt("id"));
            tmp.setVideojuego(new Videojuego(resultSet.getInt("videojuego_id"),resultSet.getString("nombre"),resultSet.getString("genero"),resultSet.getDouble("precio")));
            tmp.setVideojuego_id(resultSet.getInt("videojuego_id"));
            tmp.setCantidad(resultSet.getInt("cantidad"));
            tmp.setFecha(resultSet.getDate("fecha"));

            Ventas.add(tmp);
        }
        return Ventas;
    }
}
