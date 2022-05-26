package es.natalia.proyecto_final.entidades;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PreguntaTest {

    @Test
    public void pregunta1() {
        Pregunta p = new Pregunta();

        p.setId(1L);
        p.setCodigoPregunta("P1");
        p.setImagenPregunta("imagen");
        p.setTextoPregunta("pregunta");

        assertEquals(1L, p.getId());
        assertEquals("P1", p.getCodigoPregunta());
        assertEquals("imagen", p.getImagenPregunta());
        assertEquals("pregunta", p.getTextoPregunta());

        Respuesta r1 = new Respuesta();
        Respuesta r2 = new Respuesta();
        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(r1);
        respuestas.add(r2);

        p.setRespuestas(respuestas);
        assertTrue(respuestas.contains(r2));
        assertEquals(respuestas, p.getRespuestas());
    }

}