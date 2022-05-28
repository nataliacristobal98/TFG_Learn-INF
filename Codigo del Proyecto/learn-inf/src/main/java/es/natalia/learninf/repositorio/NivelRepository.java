package es.natalia.learninf.repositorio;

import es.natalia.learninf.entidades.Mundo;
import es.natalia.learninf.entidades.Nivel;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;
import java.util.List;

@Repository
public interface NivelRepository extends EntityRepository<Nivel, Long> {

    // Encontrar el nivel por el mundo que tenga relacionado
    List<Nivel> findByMundo(Mundo mundo);

}
