package es.natalia.proyecto_final.servicios;

import es.natalia.proyecto_final.entidades.Alumno;
import es.natalia.proyecto_final.entidades.Profesor;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlumnoServiceTest {

    @Inject
    AlumnoService alumnoService;

    @Test
    void buscarPorId() {
        Profesor p = new Profesor();
        Alumno a = new Alumno("a","a","a","a","a",p);

        a.setId(1L);
        Alumno buscado = alumnoService.buscarPorId(1L);
        assertEquals(buscado, a);
    }
}