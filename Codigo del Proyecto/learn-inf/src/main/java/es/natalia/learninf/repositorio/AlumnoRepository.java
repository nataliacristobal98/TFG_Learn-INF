package es.natalia.learninf.repositorio;

import es.natalia.learninf.entidades.Alumno;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository
public interface AlumnoRepository extends EntityRepository<Alumno, Long> {

    // Encontrar por codigo
    Alumno findByCodigoAlumno(String codigo);

    // Encontrar por correo
    Alumno findByCorreo(String correo);
}