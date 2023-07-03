package saul.mendoza.gtz.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import saul.mendoza.gtz.entity.Factura;
import saul.mendoza.gtz.entity.Persona;
import saul.mendoza.gtz.repository.FacturaRepository;
import saul.mendoza.gtz.repository.PersonaRespository;

@ApplicationScoped
public class Ventas {

	@Inject 
	FacturaRepository respositoryFactura;
	
	@Inject
	PersonaRespository repositoryPersona;
	
	public Factura storeFactura(Factura factura) {
		respositoryFactura.persist(factura);
    	return factura;
    }
	
	public List<Factura> findFacturasByPersona(String idPersona) {
		
		@SuppressWarnings("deprecation")
		Persona persona= repositoryPersona.findById(new Long(idPersona));
		
		Map<String,Object > pasrametros = new HashMap<>();   	
    	pasrametros.put("persona",persona);  	
    	
	    return respositoryFactura.list("persona=:persona", pasrametros);
	 }
}
