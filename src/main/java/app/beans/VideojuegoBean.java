package app.beans;

import app.dao.VideojuegoDAO;
import app.models.Videojuego;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class VideojuegoBean {

    private List<Videojuego> videojuegos;
    private VideojuegoDAO videojuegoDAO;
    private Videojuego newVideojuego;
    private Videojuego selectedVideojuego;

    @Inject
    public VideojuegoBean(VideojuegoDAO videojuegoDAO) {
        this.videojuegoDAO = videojuegoDAO;
        this.newVideojuego = new Videojuego();
        this.selectedVideojuego = new Videojuego();
    }

    @PostConstruct
    public void init() {
        videojuegos = new ArrayList<>();
        loadVideojuegos();
    }

    public List<Videojuego> getVideojuegos() {
        return videojuegos;
    }

    public void loadVideojuegos() {
        try {
            videojuegos = videojuegoDAO.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Videojuego getNewVideojuego() {
        return newVideojuego;
    }

    public void setNewVideojuego(Videojuego newVideojuego) {
        this.newVideojuego = newVideojuego;
    }

    public Videojuego getSelectedVideojuego() {
        return selectedVideojuego;
    }

    public void setSelectedVideojuego(Videojuego selectedVideojuego) {
        this.selectedVideojuego = selectedVideojuego;
    }

    public void insertVideojuego() {
        try {
            videojuegoDAO.insertVideojuego(newVideojuego);
            newVideojuego = new Videojuego(); // Reset form
            loadVideojuegos(); // Refresh list
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateVideojuego() {
        try {
            videojuegoDAO.updateVideojuego(selectedVideojuego);
            loadVideojuegos(); // Refresh list
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteVideojuego(int id) {
        try {
            videojuegoDAO.deleteVideojuego(id);
            loadVideojuegos(); // Refresh list
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selectVideojuego(Videojuego videojuego) {
        this.selectedVideojuego = videojuego;
    }
}
