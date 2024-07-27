package API;

import app.dao.VentaDAO;
import app.models.Venta;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;
import java.util.ArrayList;

@Path("/venta")
public class VentaAPI {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVenta() throws SQLException {
        VentaDAO ventaDAO = new VentaDAO();
        ArrayList<Venta> ventas = ventaDAO.findAll();
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(ventas).build();
    }
}
