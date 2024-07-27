package API;


import app.dao.VideojuegoDAO;
import app.models.Videojuego;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
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
}
