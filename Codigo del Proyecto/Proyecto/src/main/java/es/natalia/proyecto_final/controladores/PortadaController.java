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


    @Path("/")
    @GET
    public String index() {
        // Controlamos que haya una sesión activa. Si la hay, no se puede acceder a esta pantalla ya que causará errores.
        HttpSession session = request.getSession();

        try {
            // Si la sesión es de alumno
            if (session.getAttribute("iniciada").equals(true)) {
                Alumno alumno = alumnoService.buscarPorId(Long.parseLong(session.getAttribute("id").toString()));

                models.put("alumno", alumno);
                return "portada/portada";
            }
        } catch (NullPointerException e) {
            System.out.println(e);
        }

        try {
            // Si la sesión es de profesor
            if(session.getAttribute("iniciadaP").equals(true)) {
                Profesor profesor = profesorService.buscarProfesorCod(session.getAttribute("codP").toString());

                models.put("profesor", profesor);
                return "portada/portada";
            }

        } catch (NullPointerException e) {
            System.out.println(e);
        }

        return "portada/portada";
    }

}
