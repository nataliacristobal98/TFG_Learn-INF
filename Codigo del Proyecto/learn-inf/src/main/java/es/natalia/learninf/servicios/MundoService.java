package es.natalia.learninf.servicios;

import es.natalia.learninf.entidades.*;
import es.natalia.learninf.repositorio.MundoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class MundoService {

    @Inject
    MundoRepository mundoRepository;

    // Para encontrar los Mundos necesarios
    public List<Mundo> findAll() {
        return mundoRepository.findAll();
    }
    public Optional<Mundo> buscarPorId(Long id) {
        return mundoRepository.findOptionalBy(id);
    }

}
