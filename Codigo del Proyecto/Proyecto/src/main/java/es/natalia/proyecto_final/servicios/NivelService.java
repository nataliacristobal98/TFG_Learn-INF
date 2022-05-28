package es.natalia.proyecto_final.servicios;

import es.natalia.proyecto_final.entidades.*;
import es.natalia.proyecto_final.repositorio.*;
import jakarta.annotation.Resource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.UserTransaction;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class NivelService {

    @Inject
    NivelRepository nivelRepository;

    @Inject
    LeccionRepository leccionRepository;

    @Inject
    TestRepository testRepository;

    @Inject
    PreguntaRepository preguntaRepository;

    @Inject
    RespuestaRepository respuestaRepository;

    // Para la busqueda de Niveles
    public List<Nivel> buscarNiveles(Mundo mundo) {
        return nivelRepository.findByMundo(mundo);
    }
    public Nivel buscarPorId(Long id) {
        return nivelRepository.findBy(id);
    }

    // Encontrar la leccion y el test asociado al nivel
    public Leccion buscarLeccion(Nivel nivel) {return leccionRepository.findByNivel(nivel);}
    public Test buscarTest(Nivel nivel) {return testRepository.findByNivel(nivel);}
    public Test buscarPorIdTest(Long id) {
        return testRepository.findBy(id);
    }

    // Busqueda de preguntas y respuestas asociadas a los tests por nivel
    public List<Pregunta> buscarPreguntas(Test test) {return preguntaRepository.findByTest(test);}
    public Pregunta buscarIdPregunta(Long id){return preguntaRepository.findBy(id);}
    public Optional<Test> buscarPorIdTestOp(Long id) {
        return testRepository.findOptionalBy(id);
    }
    public Optional<Pregunta> buscarPorIdPreguntaOp(Long id) {
        return preguntaRepository.findOptionalBy(id);
    }
    public List<Respuesta> buscarRespuestas() {
        return respuestaRepository.findAll();
    }
    public List<Respuesta> buscarRespuestasPorPregunta(Pregunta pregunta) {return respuestaRepository.findByPregunta(pregunta);}
    public Respuesta buscarIdRespuesta(Long id){return respuestaRepository.findBy(id);}

    //Terminar Test
    public void terminarTest(Test test){
        test.setTerminadoTrue();
        testRepository.save(test);
    }
}
