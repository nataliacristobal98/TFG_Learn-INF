package es.natalia.learninf.repositorio;

import es.natalia.learninf.entidades.Mundo;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository
public interface MundoRepository extends EntityRepository<Mundo, Long> {

}
