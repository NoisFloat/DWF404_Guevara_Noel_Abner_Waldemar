package app.dao;

import app.models.Conexion;
import app.models.Videojuego;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.sql.SQLException;
import java.util.ArrayList;

@Named
@RequestScoped
public class VideojuegoDAO extends Conexion {
    public ArrayList<Videojuego> findAll() throws SQLException {
        connect();
        stmt = conn.createStatement();
        resultSet = stmt.executeQuery("SELECT * FROM videojuego");
        ArrayList<Videojuego> videojuegos = new ArrayList();

        while (resultSet.next()) {
            Videojuego tmp = new Videojuego();
            tmp.setId(resultSet.getInt(1));
            tmp.setNombre(resultSet.getString(2));
            tmp.setGenero(resultSet.getString(3));
            tmp.setPrecio(resultSet.getDouble(4));

            videojuegos.add(tmp);
        }
        return videojuegos;
    }
    public Videojuego findById(int id) throws SQLException {
        connect();
        Videojuego game = new Videojuego();
        stmt = conn.createStatement();
        resultSet = stmt.executeQuery("SELECT * FROM videojuego WHERE id = " + id);
        while (resultSet.next()) {
            game.setId(resultSet.getInt(1));
            game.setNombre(resultSet.getString(2));
            game.setGenero(resultSet.getString(3));
            game.setPrecio(resultSet.getDouble(4));
        }
        return game;
    }
    public String insertVideojuego(Videojuego videojuego) throws SQLException {
        connect();
        String sql = "INSERT INTO videojuego (nombre, genero, precio) VALUES (?, ?, ?)";
        pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, videojuego.getNombre());
        pstmt.setString(2, videojuego.getGenero());
        pstmt.setDouble(3, videojuego.getPrecio());

        int columnasAfectadas = pstmt.executeUpdate();
        pstmt.close();

        return columnasAfectadas > 0 ? "exito" : "error";
    }

    public String updateVideojuego(Videojuego videojuego) throws SQLException {
        connect();
        String sql = "UPDATE videojuego SET nombre = ?, genero = ?, precio = ? WHERE id = ?";
        pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, videojuego.getNombre());
        pstmt.setString(2, videojuego.getGenero());
        pstmt.setDouble(3, videojuego.getPrecio());
        pstmt.setInt(4, videojuego.getId());

        int columnasAfectadas = pstmt.executeUpdate();
        pstmt.close();
        System.out.println(columnasAfectadas);
        return columnasAfectadas > 0 ? "exito" : "error";
    }
    public String deleteVideojuego(int id) throws SQLException {
        connect();
        String sql = "DELETE FROM videojuego WHERE id = ?";
        pstmt = conn.prepareStatement(sql);

        pstmt.setInt(1, id);

        int rowsAffected = pstmt.executeUpdate();
        pstmt.close();

        return rowsAffected > 0 ? "exito" : "error";
    }


}