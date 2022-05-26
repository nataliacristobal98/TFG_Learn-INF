package es.natalia.proyecto_final.repositorio;

import es.natalia.proyecto_final.entidades.Alumno;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
class AlumnoRepositoryTest {

    @Inject
    AlumnoRepository alumnoRepository;

    @Inject
    EntityManagerProducer entityManagerProducer;

    @Test
    void findByCodigoAlumno() {
        Alumno a = new Alumno();
        a.setCodigoAlumno("A1");

        Alumno aBuscado = alumnoRepository.findByCodigoAlumno("A1");
        assertEquals(aBuscado, a);
    }

    @Test
    void findByCorreo() {
    }
}