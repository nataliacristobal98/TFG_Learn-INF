package es.natalia.learninf.repositorio;

import es.natalia.learninf.entidades.Leccion;
import es.natalia.learninf.entidades.Nivel;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository
public interface LeccionRepository extends EntityRepository<Leccion, Long> {

    // Encontrar lección por nivel
    Leccion findByNivel(Nivel nivel);

}
