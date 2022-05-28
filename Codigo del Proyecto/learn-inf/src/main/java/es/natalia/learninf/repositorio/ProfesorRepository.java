package es.natalia.learninf.repositorio;

import es.natalia.learninf.entidades.Profesor;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository
public interface ProfesorRepository extends EntityRepository<Profesor, Long> {

    // Encontrar por correo
    Profesor findByCorreo(String correo);

    // Encontrar por código de profesor
    Profesor findByCodigoProfesor(String codigo);
}
