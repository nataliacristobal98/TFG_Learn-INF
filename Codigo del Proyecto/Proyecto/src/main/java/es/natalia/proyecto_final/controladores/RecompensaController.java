package es.natalia.proyecto_final.controladores;

import es.natalia.proyecto_final.entidades.Alumno;
import es.natalia.proyecto_final.entidades.Profesor;
import es.natalia.proyecto_final.repositorio.RecompensaRepository;
import es.natalia.proyecto_final.servicios.AlumnoService;
import es.natalia.proyecto_final.servicios.ProfesorService;
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

    @Inject
    ProfesorService profesorService;

    @Path("/")
    @GET
    public String index() {
        // Controlamos que haya una sesión activa. Si la hay, no se puede acceder a esta pantalla ya que causará errores.
        HttpSession session = request.getSession();

        // Si la sesión de alumno
        try {
            if (session.getAttribute("iniciada").equals(true)) {
                Alumno alumno = alumnoService.buscarPorId(Long.parseLong(session.getAttribute("id").toString()));

                models.put("alumno", alumno);
                models.put("recompensas", recompensaService.findAll());
                return "usuarios/recompensas";

            }
        } catch (NullPointerException e) {
            System.out.println(e);
        }

        // Si la sesión es de profesor
        try {
            if(session.getAttribute("iniciadaP").equals(true)) {
                // Obtenemos el profesor
                Profesor profesor = profesorService.buscarProfesorCod(session.getAttribute("codP").toString());

                models.put("profesor", profesor);
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
