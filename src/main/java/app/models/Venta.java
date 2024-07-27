package app.models;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.util.Date;
@Named
@RequestScoped
public class Venta {
    private int id;
    private int videojuego_id;
    private Date fecha;
    private int cantidad;
    private Videojuego videojuego;

    public Venta() {}

    public Venta(int id, int videojuego_id, Date fecha, int cantidad, Videojuego videojuego) {
        this.id = id;
        this.videojuego_id = videojuego_id;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.videojuego = videojuego;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVideojuego_id() {
        return videojuego_id;
    }

    public void setVideojuego_id(int videojuego_id) {
        this.videojuego_id = videojuego_id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Videojuego getVideojuego() {
        return videojuego;
    }

    public void setVideojuego(Videojuego videojuego) {
        this.videojuego = videojuego;
    }
}
