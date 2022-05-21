package es.natalia.proyecto_final.controladores;

import es.natalia.proyecto_final.entidades.Alumno;
import es.natalia.proyecto_final.entidades.Profesor;
import es.natalia.proyecto_final.servicios.AlumnoService;
import es.natalia.proyecto_final.servicios.ProfesorService;
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
@Path("/portada")
@Controller
@RequestScoped
public class PortadaController {

    @Inject
    HttpServletRequest request;

    @Inject
    private Models models;

    @Inject
    AlumnoService alumnoService;

    @Inject
    ProfesorService profesorService;

    // La portada principal, de momento solo nos sirve de presentación para el enrutado de los demás Controladores
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
                return "portada/portada";

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
                return "portada/portada";
            }

        } catch (NullPointerException e) {
            return "portada/portada";
        }


        return "portada/portada";
    }

}
