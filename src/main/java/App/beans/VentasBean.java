package App.beans;

import App.dao.VentaDAO;
import App.dao.VideojuegoDAO;
import App.models.Venta;
import App.models.Videojuego;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class VentasBean {
    private List<Venta> ventas;
    private VentaDAO ventasDAO;
    private Venta newVenta;
    private Venta selectedVenta;
    @Inject
    public VentasBean(VentaDAO ventaDAO) {
        this.ventasDAO = ventaDAO;
        this.newVenta = new Venta();
        this.selectedVenta = new Venta();
    }

    @PostConstruct
    public void init() {
        ventas = new ArrayList<>();
        loadVentas();
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void loadVentas() {
        try {
            ventas = ventasDAO.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Venta getNewVenta() {
        return newVenta;
    }

    public void setNewVenta(Venta newVenta) {
        this.newVenta = newVenta;
    }

    public Venta getSelectedVenta() {
        return selectedVenta;
    }

    public void setSelectedVenta(Venta selectedVenta) {
        this.selectedVenta = selectedVenta;
    }

    public void insertVenta() {
        try {
            ventasDAO.insertVenta(newVenta);
            newVenta = new Venta(); // Reset form
            loadVentas(); // Refresh list
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateVenta() {
        try {
            ventasDAO.updateVenta(selectedVenta);
            loadVentas(); // Refresh list
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteVenta(int id) {
        try {
            ventasDAO.deleteVenta(id);
            loadVentas(); // Refresh list
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selectVenta(Venta venta) {
        this.selectedVenta = venta;
    }
}
