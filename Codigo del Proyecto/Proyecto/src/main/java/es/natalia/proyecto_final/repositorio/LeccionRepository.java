package es.natalia.proyecto_final.repositorio;

import es.natalia.proyecto_final.entidades.Leccion;
import es.natalia.proyecto_final.entidades.Nivel;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository
public interface LeccionRepository extends EntityRepository<Leccion, Long> {

    // Encontrar lección por nivel
    Leccion findByNivel(Nivel nivel);

}
