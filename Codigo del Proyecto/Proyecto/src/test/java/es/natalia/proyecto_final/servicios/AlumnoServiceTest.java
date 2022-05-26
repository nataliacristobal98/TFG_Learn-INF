package es.natalia.proyecto_final.servicios;

import es.natalia.proyecto_final.entidades.Alumno;
import jakarta.annotation.Resource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@ApplicationScoped
class AlumnoServiceTest {

    @Inject
    private AlumnoService alumnoService;

    @Test
    public void iconTest(){
        Alumno alumno = new Alumno();
        alumnoService.cambiarIcon(alumno, "icon1");

        assertEquals("icon1", alumno.getIcono());
    }

}