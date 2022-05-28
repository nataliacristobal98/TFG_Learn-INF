package es.natalia.proyecto_final.repositorio;

import es.natalia.proyecto_final.entidades.Nivel;
import es.natalia.proyecto_final.entidades.Test;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository
public interface TestRepository extends EntityRepository<Test, Long> {

    // Encontrar test en base a su nivel
    Test findByNivel(Nivel nivel);
}
