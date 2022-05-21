package es.natalia.proyecto_final.servicios;

import es.natalia.proyecto_final.entidades.Alumno;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class AlumnoServiceTest {
    @Inject
    AlumnoService alumnoService;


    @Test
    public void crearAlumno() {
        Alumno alumno = alumnoService.crearAlumno("1", "icono1", "Maria", "m@g.com", "m");
        String nombre = "Maria";

        assertEquals(alumno.getNombre(), nombre);
    }


}
