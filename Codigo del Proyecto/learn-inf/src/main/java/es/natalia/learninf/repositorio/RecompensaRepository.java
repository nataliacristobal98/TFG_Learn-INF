package es.natalia.learninf.repositorio;

import es.natalia.learninf.entidades.Recompensa;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository
public interface RecompensaRepository extends EntityRepository<Recompensa, Long> {

}
