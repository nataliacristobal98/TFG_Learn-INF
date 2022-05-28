package es.natalia.proyecto_final.repositorio;

import es.natalia.proyecto_final.entidades.Pregunta;
import es.natalia.proyecto_final.entidades.Test;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;
import java.util.List;

@Repository
public interface PreguntaRepository extends EntityRepository<Pregunta, Long> {

    // Encontrar las preguntas asociadas a un test
    List<Pregunta> findByTest(Test test);

}
