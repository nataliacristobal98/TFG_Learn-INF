package es.natalia.proyecto_final;

import es.natalia.proyecto_final.entidades.Alumno;
import es.natalia.proyecto_final.entidades.Profesor;
import es.natalia.proyecto_final.servicios.AlumnoService;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class TestAlumno {

    @Inject
    AlumnoService alumnoService;

    @Test
    public void crearAlumno() {
        Profesor profesor = new Profesor();
        Alumno alumnoNuevo = new Alumno("Maria", "maria@gmail.com", "123", "icon1", "A001", profesor);

        String correoAlumno = "maria@gmail.com";



        assertEquals(alumnoNuevo.getCorreo(), correoAlumno);
    }
}
