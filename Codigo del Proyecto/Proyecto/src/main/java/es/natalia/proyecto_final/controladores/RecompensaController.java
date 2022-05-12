package es.natalia.proyecto_final.controladores;

import es.natalia.proyecto_final.entidades.Alumno;
import es.natalia.proyecto_final.repositorio.RecompensaRepository;
import es.natalia.proyecto_final.servicios.AlumnoService;
import es.natalia.proyecto_final.servicios.RecompensaService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Path("/recompensa")
@Controller
@RequestScoped
public class RecompensaController {

    @Inject
    HttpServletRequest request;

    @Inject
    private Models models;

    @Inject
    RecompensaService recompensaService;

    @Inject
    AlumnoService alumnoService;

    @Path("/")
    @GET
    public String index() {
        // Controlamos que haya una sesión activa. Si la hay, no se puede acceder a esta pantalla ya que causará errores.
        HttpSession session = request.getSession();
        try {
            if (session.getAttribute("iniciada").equals(true)) {
                Alumno alumno = alumnoService.buscarPorId(Long.parseLong(session.getAttribute("id").toString()));

                models.put("alumno", alumno);
                models.put("recompensas", recompensaService.findAll());
                return "usuarios/recompensas";
            }
        } catch (NullPointerException e) {
            // Si no hay una sesión, se permite el acceso o crear una.
            return "sesion/login";
        }
        return "sesion/login";
    }
}
