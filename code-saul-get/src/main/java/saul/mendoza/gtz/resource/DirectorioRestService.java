package saul.mendoza.gtz.resource;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import saul.mendoza.gtz.entity.Persona;
import saul.mendoza.gtz.service.Directorio;

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DirectorioRestService {

	@Inject
	Directorio directorioService;
	
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    @Path("/storePersona")
    public Persona storePersona(Persona personadto) { 	
    	directorioService.storePersona(personadto);
    	return personadto;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/findPersonas")
    public List<Persona> findPersonas() {
    	return directorioService.findPersonas();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/findPersonaByIdentificacion/{identificacion}")
    public Persona findPersonaByIdentificacion(@PathParam("identificacion") String identificacion) {
    	return directorioService.findPersonaByIdentificacion(identificacion);
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    @Path("/deletePersonaByIdentificacion/{identificacion}")
    public String deletePersonaByIdentificacion(@PathParam("identificacion") String identificacion) {
    	return directorioService.deletePersonaByIdentificacion(identificacion);
    }
}
