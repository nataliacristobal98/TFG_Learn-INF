package es.natalia.learninf.repositorio;

import es.natalia.learninf.entidades.Pregunta;
import es.natalia.learninf.entidades.Test;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;
import java.util.List;

@Repository
public interface PreguntaRepository extends EntityRepository<Pregunta, Long> {

    // Encontrar las preguntas asociadas a un test
    List<Pregunta> findByTest(Test test);

}
