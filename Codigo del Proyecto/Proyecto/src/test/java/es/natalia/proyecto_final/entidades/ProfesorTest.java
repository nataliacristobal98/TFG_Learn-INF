package es.natalia.proyecto_final.entidades;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProfesorTest {

    @Test
    public void nivel1(){
        Profesor p = new Profesor();

        p.setCodigoProfesor("P");
        p.setId(1L);
        p.setContrasena("abc");
        p.setCorreo("correo");
        p.setNombre("nombre");

        assertEquals("P", p.getCodigoProfesor());
        assertEquals(1L, p.getId());
        assertEquals("abc", p.getContrasena());
        assertEquals("correo", p.getCorreo());
        assertEquals("nombre", p.getNombre());

        Alumno a1 = new Alumno();
        Alumno a2 = new Alumno();
        List<Alumno> alumnos = new ArrayList<>();
        alumnos.add(a1);
        alumnos.add(a2);

        p.setAlumnos(alumnos);
        assertTrue(alumnos.contains(a2));
        assertEquals(alumnos, p.getAlumnos());

    }

}