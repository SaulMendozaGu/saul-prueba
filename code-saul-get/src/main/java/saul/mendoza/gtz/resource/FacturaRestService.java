package saul.mendoza.gtz.resource;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import saul.mendoza.gtz.entity.Factura;
import saul.mendoza.gtz.service.Ventas;

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FacturaRestService {
	
	@Inject
	Ventas service;
	
	
	
	 @POST
	 @Produces(MediaType.APPLICATION_JSON)
	 @Consumes(MediaType.APPLICATION_JSON)
	 @Transactional
	 @Path("/storeFactura")
	 public Factura storeFactura(Factura factura) { 	
		 service.storeFactura(factura);
	    return factura;
	 }

	 @GET
	 @Produces(MediaType.APPLICATION_JSON)
	 @Consumes(MediaType.APPLICATION_JSON)
	 @Path("/findFacturasByPersona/{idPersona}")
	 public List<Factura> findFacturasByPersona(@PathParam("idPersona") String idPersona) {
	    return service.findFacturasByPersona(idPersona);
	 }
	    
}
