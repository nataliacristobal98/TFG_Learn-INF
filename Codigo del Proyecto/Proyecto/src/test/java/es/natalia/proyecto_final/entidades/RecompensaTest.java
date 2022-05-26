package es.natalia.proyecto_final.entidades;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecompensaTest {

    @Test
    public void recompensa1(){
        Recompensa r = new Recompensa();

        r.setId(1L);
        r.setRutaRecompensa("ruta");
        r.setPuntosDesbloqueo(12);
        r.setTipo("tipo1");

        assertEquals(1L, r.getId());
        assertEquals("ruta", r.getRutaRecompensa());
        assertEquals(12, r.getPuntosDesbloqueo());
        assertEquals("tipo1", r.getTipo());

        Nivel n = new Nivel();
        r.setNivel(n);
        assertEquals(n, r.getNivel());
    }

}