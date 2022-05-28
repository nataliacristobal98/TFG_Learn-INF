package es.natalia.learninf.repositorio;

import es.natalia.learninf.entidades.Pregunta;
import es.natalia.learninf.entidades.Respuesta;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;
import java.util.List;

@Repository
public interface RespuestaRepository extends EntityRepository<Respuesta, Long> {

    // Encontrar las respuestas asociadas a una pregunta
    List<Respuesta> findByPregunta(Pregunta pregunta);
}
