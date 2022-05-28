package es.natalia.learninf.entidades;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class TestTest {

    @Test
    public void test1(){
        es.natalia.learninf.entidades.Test t = new es.natalia.learninf.entidades.Test();
        t.setId(1L);
        assertEquals(1L, t.getId());
    }

    @Test
    public void test2(){
        // Como Test es una palabra reservada hay que especificar la ruta de la entidad
        es.natalia.learninf.entidades.Test t = new es.natalia.learninf.entidades.Test();

        t.setId(1L);
        t.setTerminado(false);
        t.setCodigo("T1");
        assertEquals(1L, t.getId());
        assertEquals(false, t.getTerminado());
        assertEquals("T1", t.getCodigo());

        t.setTerminadoTrue();
        assertEquals(true, t.getTerminado());

        Nivel n = new Nivel();
        t.setNivel(n);
        assertEquals(n, t.getNivel());

        Pregunta p = new Pregunta();
        Set<Pregunta> preguntas = new HashSet<Pregunta>();
        preguntas.add(p);
        t.setPreguntas(preguntas);
        assertEquals(preguntas, t.getPreguntas());
    }

}