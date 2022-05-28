package es.natalia.learninf.entidades;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NivelTest {

    @Test
    public void nivel1(){
        Nivel n= new Nivel();

        n.setId(1L);
        n.setCodigoNivel("N1");
        n.setDificultad(2);
        n.setPuntosDesbloqueo(5);
        n.setPuntuacionMaxima(5);
        n.setPuntuacionMinima(5);

        assertEquals(1L, n.getId());
        assertEquals("N1", n.getCodigoNivel());
        assertEquals(2, n.getDificultad());
        assertEquals(5, n.getPuntosDesbloqueo());
        assertEquals(5, n.getPuntuacionMaxima());
        assertEquals(5, n.getPuntuacionMinima());

        Leccion l = new Leccion();
        n.setLeccion(l);
        Mundo m = new Mundo();
        n.setMundo(m);
        Recompensa r = new Recompensa();
        n.setRecompensa(r);
        assertEquals(l, n.getLeccion());
        assertEquals(m, n.getMundo());
        assertEquals(r, n.getRecompensa());

        es.natalia.learninf.entidades.Test t = new es.natalia.learninf.entidades.Test();
        n.setTest(t);
        assertEquals(t, n.getTest());
    }

}