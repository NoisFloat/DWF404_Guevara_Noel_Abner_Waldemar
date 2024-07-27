package API;

import App.dao.VentaDAO;
import App.models.Venta;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
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
    /*Uso de peticiones get PARAMETRIZADAS*/
    //localhost:8080/API/ventas/{numeroEntero}
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVentasById(@PathParam("id") int id) throws SQLException {
        VentaDAO fuenteDeDatos = new VentaDAO();
        Venta venta = fuenteDeDatos.findById(id);
        if(venta.getFecha() == null) {
            return Response.status(404).entity("Venta no encontrada").build(); //Devuelve el codigo de 404, en resumen no existe esa categoria
            //Por definicion estaria bien el 404, pero puede ser cualquier codigo serie 200, 400 o 500, facilmente puede ser el error que quieras
            //Y veras un error diferente segun el error indicado aqui
        }
        return Response.status(200).entity(venta).build();//En caso de que categoria sea diferente de nulo, envia la categoria con un estado OK(200)
    }
}
