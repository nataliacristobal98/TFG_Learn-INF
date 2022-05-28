package es.natalia.learninf.servicios;

import es.natalia.learninf.entidades.Recompensa;
import es.natalia.learninf.repositorio.RecompensaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;

@ApplicationScoped
public class RecompensaService {

    @Inject
    RecompensaRepository recompensaRepository;

    // Busqueda de las Recompensas definidas
    public List<Recompensa> findAll() {
        return recompensaRepository.findAll();
    }
}
