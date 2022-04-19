package es.natalia.proyecto_final.repositorio;

import es.natalia.proyecto_final.entidades.Profesor;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository
public interface ProfesorRepository extends EntityRepository<Profesor, Long> {

}
