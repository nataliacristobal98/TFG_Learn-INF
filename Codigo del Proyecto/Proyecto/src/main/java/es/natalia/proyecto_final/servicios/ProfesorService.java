package es.natalia.proyecto_final.servicios;

import es.natalia.proyecto_final.entidades.Profesor;
import es.natalia.proyecto_final.repositorio.ProfesorRepository;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class ProfesorService {

    @Inject
    ProfesorRepository profesorRepository;

    public List<Profesor> findAll() {
        return profesorRepository.findAll();
    }

}
