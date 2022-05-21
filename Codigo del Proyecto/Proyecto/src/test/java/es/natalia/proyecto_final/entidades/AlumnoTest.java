package es.natalia.proyecto_final.entidades;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AlumnoTest {

    @Test
    public void testAlumno() {
        Profesor profesor = new Profesor();
        Alumno alumnoNuevo = new Alumno("Maria", "maria@gmail.com", "123", "icon1", "A001", profesor);

        alumnoNuevo.setIcono("icon2");

        assertEquals("icon2", alumnoNuevo.getIcono());
    }

}
