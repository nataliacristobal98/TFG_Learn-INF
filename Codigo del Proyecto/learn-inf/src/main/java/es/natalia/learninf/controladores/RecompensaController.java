package es.natalia.learninf.controladores;

import es.natalia.learninf.entidades.Alumno;
import es.natalia.learninf.entidades.Profesor;
import es.natalia.learninf.servicios.AlumnoService;
import es.natalia.learninf.servicios.ProfesorService;
import es.natalia.learninf.servicios.RecompensaService;
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
        // Comprobamos que haya una sesión iniciada, ya que si no existe ninguna no se podría acceder a esta parte de la web
        HttpSession session = request.getSession();

        try {
            // Si la sesión es de alumno
            if (session.getAttribute("iniciada").equals(true)) {
                Alumno alumno = alumnoService.buscarPorId(Long.parseLong(session.getAttribute("id").toString()));

                models.put("alumno", alumno);
                models.put("recompensas", recompensaService.findAll());
                return "usuarios/recompensas";

            }
        } catch (NullPointerException e) {
            System.out.println(e);
        }

        try {
            // Si la sesión es de profesor
            if(session.getAttribute("iniciadaP").equals(true)) {
                Profesor profesor = profesorService.buscarProfesorCod(session.getAttribute("codP").toString());

                models.put("profesor", profesor);
                models.put("recompensas", recompensaService.findAll());
                return "usuarios/recompensas";
            }

        } catch (NullPointerException e) {
            System.out.println(e);
        }
        // Si no hay una sesión, se permite el acceso o crear una.
        return "sesion/login";
    }
}
