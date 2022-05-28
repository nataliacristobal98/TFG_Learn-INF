package es.natalia.learninf.repositorio;

import es.natalia.learninf.entidades.Nivel;
import es.natalia.learninf.entidades.Test;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository
public interface TestRepository extends EntityRepository<Test, Long> {

    // Encontrar test en base a su nivel
    Test findByNivel(Nivel nivel);
}
