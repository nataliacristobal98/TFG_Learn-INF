package es.natalia.proyecto_final.repositorio;

import es.natalia.proyecto_final.entidades.Mundo;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository
public interface MundoRepository extends EntityRepository<Mundo, Long> {



}
