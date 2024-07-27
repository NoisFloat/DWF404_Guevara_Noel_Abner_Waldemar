package API;


import App.dao.VentaDAO;
import App.dao.VideojuegoDAO;
import App.models.Venta;
import App.models.Videojuego;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;
import java.util.ArrayList;

@Path("/videojuego")
public class VideojuegoAPI {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVideojuego() throws SQLException {
        VideojuegoDAO dao = new VideojuegoDAO();
        ArrayList<Videojuego> videojuego = dao.findAll();
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(videojuego).build();
    }

    /*Uso de peticiones get PARAMETRIZADAS*/
    //localhost:8080/API/videojuego/{numeroEntero}
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVideojuegoById(@PathParam("id") int id) throws SQLException {
        VideojuegoDAO fuenteDeDatos = new VideojuegoDAO();
        Videojuego videojuego = fuenteDeDatos.findById(id);
        if(videojuego.getGenero() == null) {
            return Response.status(404).entity("Videojuego no encontrada").build(); //Devuelve el codigo de 404, en resumen no existe esa categoria
            //Por definicion estaria bien el 404, pero puede ser cualquier codigo serie 200, 400 o 500, facilmente puede ser el error que quieras
            //Y veras un error diferente segun el error indicado aqui
        }
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(videojuego).build();//En caso de que categoria sea diferente de nulo, envia la categoria con un estado OK(200)
    }
}
