import es.natalia.proyecto_final.entidades.Alumno;
import es.natalia.proyecto_final.repositorio.AlumnoRepository;
import es.natalia.proyecto_final.servicios.AlumnoService;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

public class TestAlumno {

    @Inject
    AlumnoService alumnoService;

    /*@Test
    public void buscarAlumno() {
        Long id = 1L;
        Alumno alumnoBuscado = alumnoService.buscarPorId(id);
        Alumno alumnoEsperado = new Alumno(1, )
        assertEquals(resultadoEsperado, resultadoReal, 0.01);
    }*/
}
