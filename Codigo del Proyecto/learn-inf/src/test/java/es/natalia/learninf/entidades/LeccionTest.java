package es.natalia.learninf.entidades;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeccionTest {

    @Test
    public void leccion1(){
        Leccion l = new Leccion();

        l.setId(1L);
        l.setCodigoLeccion("L1");
        l.setImagenLeccion("imagen1");
        l.setTituloLeccion("Leccion 1");
        l.setContenido1("Contenido1");
        l.setContenido2("Contenido2");
        assertEquals(1L, l.getId());
        assertEquals("L1", l.getCodigoLeccion());
        assertEquals("imagen1", l.getImagenLeccion());
        assertEquals("Leccion 1", l.getTituloLeccion());
        assertEquals("Contenido1", l.getContenido1());
        assertEquals("Contenido2",l.getContenido2());

        Nivel n = new Nivel();
        l.setNivel(n);
        assertEquals(n,l.getNivel());
    }

}