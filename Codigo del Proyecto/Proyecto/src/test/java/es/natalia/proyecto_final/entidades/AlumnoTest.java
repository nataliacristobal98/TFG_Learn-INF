package es.natalia.proyecto_final.entidades;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class AlumnoTest {

    @Test
    public void testAlumno1(){
        Alumno a = new Alumno();
        a.setId(1L);
        assertEquals(1L, a.getId());
    }

    @Test
    public void testAlumno2(){
        Profesor p = new Profesor();
        Alumno a = new Alumno("a","a","a","a","a",p);
        a.setId(1L);

        assertEquals(1L, a.getId());
        assertEquals("a", a.getNombre());
        assertEquals("a", a.getCorreo());
        assertEquals("a", a.getContrasena());
        assertEquals("a", a.getIcono());
        assertEquals("a", a.getCodigoAlumno());
        assertEquals(p, a.getProfesor());

        a.setPuntos(12);
        a.setIcono("b");
        assertEquals(12, a.getPuntos());
        assertEquals("b", a.getIcono());
    }

    @Test
    void setMundos() {
        Profesor p = new Profesor();
        Mundo m = new Mundo();
        Alumno a = new Alumno("a","a","a","a","a",p);
        a.setMundos(m);
        Set<Mundo> mundos = a.getMundos();
        assertTrue(mundos.contains(m));
    }


}