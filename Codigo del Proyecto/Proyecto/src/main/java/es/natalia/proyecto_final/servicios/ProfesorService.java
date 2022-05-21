package es.natalia.proyecto_final.servicios;

import es.natalia.proyecto_final.entidades.Alumno;
import es.natalia.proyecto_final.entidades.Profesor;
import es.natalia.proyecto_final.repositorio.AlumnoRepository;
import es.natalia.proyecto_final.repositorio.ProfesorRepository;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ProfesorService {

    @Inject
    ProfesorRepository profesorRepository;

    @Inject
    AlumnoRepository alumnoRepository;

    public List<Profesor> findAll() {
        return profesorRepository.findAll();
    }

    public Profesor buscarPorId(Long id) {
        return profesorRepository.findBy(id);
    }

    public Profesor buscarProfesorCorreo(String correo){return profesorRepository.findByCorreo(correo);}

    public Profesor buscarProfesorCod(String cod){return profesorRepository.findByCodigoProfesor(cod);}

    public List<Alumno> listadoAlumnos(Profesor profesor) {
        Long id = profesor.getId();

        List<Alumno> alumnos = alumnoRepository.findAll();

        List<Alumno> alumnosProfe = new ArrayList<Alumno>();

        for (int i = 0; i < alumnos.size(); i++) {
            Profesor profesorAlumno = alumnos.get(i).getProfesor();
            if(profesorAlumno.getId().equals(id)){
                alumnosProfe.add(alumnos.get(i));
            }
        }

        return alumnosProfe;
    }

}
