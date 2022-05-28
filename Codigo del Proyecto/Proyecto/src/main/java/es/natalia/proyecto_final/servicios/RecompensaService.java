package es.natalia.proyecto_final.servicios;

import es.natalia.proyecto_final.entidades.Recompensa;
import es.natalia.proyecto_final.repositorio.RecompensaRepository;
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
