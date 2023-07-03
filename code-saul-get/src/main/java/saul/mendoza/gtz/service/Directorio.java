package saul.mendoza.gtz.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import saul.mendoza.gtz.entity.Persona;
import saul.mendoza.gtz.repository.PersonaRespository;

@ApplicationScoped
public class Directorio {
	
	@Inject
	PersonaRespository repository;

	public List<Persona> findPersonas() {
    	return repository.findAll().list();
    }
	
	public Persona findPersonaByIdentificacion(String identificacion) {
		Map<String,Object > pasrametros = new HashMap<>();   	
    	pasrametros.put("identificacion",identificacion);  	
    	PanacheQuery<Persona> testPersona = repository.find("identificacion=:identificacion", pasrametros);
    	Persona resultado = testPersona.firstResult();
    	return resultado;
    }
	
	public Persona storePersona(Persona personadto) {
    	repository.persist(personadto);
    	return personadto;
    }
	
	public String deletePersonaByIdentificacion(String  identificacion) {
		Persona encontrado = findPersonaByIdentificacion( identificacion);
		
		if(encontrado == null) {
			return "No encontrado";
		}
    	repository.delete(encontrado);
    	return "Eliminado";
    }
}
