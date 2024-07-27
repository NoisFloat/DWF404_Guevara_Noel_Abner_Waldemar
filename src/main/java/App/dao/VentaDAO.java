package App.dao;

import App.models.Conexion;
import App.models.Venta;
import App.models.Videojuego;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import static App.utils.DateUtil.convertStringToDate;

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
            tmp.setFecha(resultSet.getString("fecha"));

            Ventas.add(tmp);
        }
        return Ventas;
    }

    public Venta findById(int id) throws SQLException {
        connect();
        Venta tmp = new Venta();
        stmt = conn.createStatement();
        resultSet = stmt.executeQuery("SELECT * FROM venta AS v INNER JOIN videojuego AS vi ON v.videojuego_id = vi.id WHERE v.id = " +id);

        while (resultSet.next()) {
            tmp.setId(resultSet.getInt("id"));
            tmp.setVideojuego_id(resultSet.getInt("videojuego_id"));
            tmp.setFecha(resultSet.getString("fecha"));
            tmp.setCantidad(resultSet.getInt("cantidad"));
            tmp.setVideojuego(new Videojuego(
                    resultSet.getInt("id"),
                    resultSet.getString("nombre"),
                    resultSet.getString("genero"),
                    resultSet.getDouble("precio")
            ));

        }
        return tmp;
    }

    public String insertVenta(Venta venta) throws SQLException {
        connect();
        String sql = "INSERT INTO venta (videojuego_id, fecha, cantidad) VALUES (?, ?, ?)";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, venta.getVideojuego_id());

        pstmt.setString(2, venta.getFecha());
        pstmt.setInt(3, venta.getCantidad());
        int filasAfectadas = pstmt.executeUpdate();
        pstmt.close();
        return filasAfectadas > 0 ? "exito" : "error";
    }

    public String updateVenta(Venta venta) throws SQLException {
        connect();
        String sql = "UPDATE venta SET videojuego_id = ?, fecha = ?, cantidad = ? WHERE id = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, venta.getFecha());
        pstmt.setInt(2, venta.getVideojuego_id());
        pstmt.setInt(3, venta.getCantidad());
        pstmt.setInt(4, venta.getId());
        int filasAfectadas = pstmt.executeUpdate();
        pstmt.close();
        return filasAfectadas > 0 ? "exito" : "error";
    }

    public String deleteVenta(int videojuegoId) throws SQLException {
        connect();
        String sql = "DELETE FROM venta WHERE id = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, videojuegoId);
        int filasAfectadas = pstmt.executeUpdate();
        pstmt.close();
        return filasAfectadas > 0 ? "exito" : "error";
    }


}
