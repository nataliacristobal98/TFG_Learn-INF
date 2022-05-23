package es.natalia.proyecto_final.entidades;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlumnoTest {

    @Test
    public void testAlumno(){
        Profesor p = new Profesor();
        Alumno a = new Alumno("a","a","a","a","a",p);
        assertEquals("a", a.getNombre());
    }

    @Test
    void setMundos() {
    }
}