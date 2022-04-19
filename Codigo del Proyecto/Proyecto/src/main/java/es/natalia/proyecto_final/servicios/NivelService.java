package es.natalia.proyecto_final.servicios;

import es.natalia.proyecto_final.entidades.*;
import es.natalia.proyecto_final.repositorio.*;
import jakarta.annotation.Resource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.SystemException;
import jakarta.transaction.UserTransaction;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class NivelService {

    @Resource
    UserTransaction transaction;

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

    // La busqueda del listado de niveles
    public List<Nivel> buscarNiveles(Mundo mundo) {
        return nivelRepository.findByMundo(mundo);
    }
    // Busqueda del nivel
    public Nivel buscarPorId(Long id) {
        return nivelRepository.findBy(id);
    }

    // Encontrar la leccion y el test asociado al nivel
    public Leccion buscarLeccion(Nivel nivel) {return leccionRepository.findByNivel(nivel);}
    public Test buscarTest(Nivel nivel) {return testRepository.findByNivel(nivel);}


    public Test buscarPorIdTest(Long id) {
        return testRepository.findBy(id);
    }

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


    // Métodos para Serivios REST
    public Pregunta guardar(Pregunta pregunta)  throws SystemException {
        System.out.println("Guardando pregunta y sus relaciones asociadas");
        Pregunta preguntaGuardada = null;
        try {
            transaction.begin();
            preguntaGuardada = preguntaRepository.save(pregunta);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Se ha producido una excepción" + e);
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return preguntaGuardada;
    }

    public void borrar(Pregunta pregunta) throws SystemException {
        System.out.println("Borrando pregunta y sus respuestas asociadas");
        try {
            transaction.begin();
            preguntaRepository.attachAndRemove(pregunta);
            //preguntaRepository.remove(pregunta); // da excepción de intento de borrado de una entidad desligada
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Se ha producido una excepción" + e);
            if (transaction != null ) {
                transaction.rollback();
            }
        }
    }

    public Test guardar(Test test)  throws SystemException {
        System.out.println("Guardando pregunta y sus relaciones asociadas");
        Test testGuardada = null;
        try {
            transaction.begin();
            testGuardada = testRepository.save(test);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Se ha producido una excepción" + e);
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return testGuardada;
    }

    public void borrar(Test test) throws SystemException {
        System.out.println("Borrando pregunta y sus respuestas asociadas");
        try {
            transaction.begin();
            testRepository.attachAndRemove(test);
            //preguntaRepository.remove(pregunta); // da excepción de intento de borrado de una entidad desligada
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Se ha producido una excepción" + e);
            if (transaction != null ) {
                transaction.rollback();
            }
        }
    }
}
