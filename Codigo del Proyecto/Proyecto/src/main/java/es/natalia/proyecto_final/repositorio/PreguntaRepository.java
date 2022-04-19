package es.natalia.proyecto_final.repositorio;

import es.natalia.proyecto_final.entidades.Pregunta;
import es.natalia.proyecto_final.entidades.Test;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface PreguntaRepository extends EntityRepository<Pregunta, Long> {

    List<Pregunta> findByTest(Test test);

}
