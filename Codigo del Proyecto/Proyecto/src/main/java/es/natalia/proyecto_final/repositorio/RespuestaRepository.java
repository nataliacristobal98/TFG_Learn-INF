package es.natalia.proyecto_final.repositorio;

import es.natalia.proyecto_final.entidades.Pregunta;
import es.natalia.proyecto_final.entidades.Respuesta;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import java.util.List;

@Repository
public interface RespuestaRepository extends EntityRepository<Respuesta, Long> {

    List<Respuesta> findByPregunta(Pregunta pregunta);

}
