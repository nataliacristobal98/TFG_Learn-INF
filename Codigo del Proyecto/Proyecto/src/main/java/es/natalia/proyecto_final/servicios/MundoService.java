package es.natalia.proyecto_final.servicios;

import es.natalia.proyecto_final.entidades.*;
import es.natalia.proyecto_final.repositorio.LeccionRepository;
import es.natalia.proyecto_final.repositorio.MundoRepository;
import es.natalia.proyecto_final.repositorio.NivelRepository;
import es.natalia.proyecto_final.repositorio.TestRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class MundoService {

    @Inject
    MundoRepository mundoRepository;

    public List<Mundo> findAll() {
        return mundoRepository.findAll();
    }

    public Optional<Mundo> buscarPorId(Long id) {
        return mundoRepository.findOptionalBy(id);
    }

}
