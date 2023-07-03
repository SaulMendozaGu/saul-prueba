package saul.mendoza.gtz.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import saul.mendoza.gtz.entity.Persona;

@ApplicationScoped
public class PersonaRespository implements PanacheRepository <Persona>{

}
