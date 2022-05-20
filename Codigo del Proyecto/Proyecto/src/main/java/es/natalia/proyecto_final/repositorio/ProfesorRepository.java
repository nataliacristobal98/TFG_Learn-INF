package es.natalia.proyecto_final.repositorio;

import es.natalia.proyecto_final.entidades.Alumno;
import es.natalia.proyecto_final.entidades.Profesor;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository
public interface ProfesorRepository extends EntityRepository<Profesor, Long> {

    // Encontrar por correo
    Profesor findByCorreo(String correo);

    Profesor findByCodigoProfesor(String codigo);

}
