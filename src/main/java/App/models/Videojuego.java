package App.models;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class Videojuego {
    private int id;
    private String nombre;
    private String genero;
    private double precio;

    // Constructor por defecto
    public Videojuego() {}

    // Constructor con parámetros
    public Videojuego(int id, String nombre, String genero, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.genero = genero;
        this.precio = precio;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Método toString
    @Override
    public String toString() {
        return "Videojuego{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", genero='" + genero + '\'' +
                ", precio=" + precio +
                '}';
    }
}
