package es.natalia.proyecto_final.repositorio;

import es.natalia.proyecto_final.entidades.Recompensa;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository
public interface RecompensaRepository extends EntityRepository<Recompensa, Long> {

}
