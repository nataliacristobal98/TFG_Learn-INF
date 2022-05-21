package es.natalia.proyecto_final.controladores;

import es.natalia.proyecto_final.entidades.Alumno;
import es.natalia.proyecto_final.entidades.Profesor;
import es.natalia.proyecto_final.servicios.AlumnoService;
import es.natalia.proyecto_final.servicios.ProfesorService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.persistence.NoResultException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import lombok.extern.slf4j.Slf4j;
import java.util.List;

@Slf4j
@Path("/signup")
@Controller
@RequestScoped
public class SignupController {

    @Inject
    AlumnoService alumnoService;

    @Inject
    ProfesorService profesorService;

    // Crear la sesión para el control de datos
    @Inject
    HttpServletRequest request;

    @Inject
    private Models models;

    @Path("/")
    @GET
    public String registro() {
        // Mandamos una lista de los Profesores disponibles para su selección
        List<Profesor> profesores = profesorService.findAll();
        try {
            models.put("profesores", profesores);
        } catch (NoResultException e) {
            System.out.println(e);
            return "sesion/signup";
        }

        // Controlamos que haya una sesión activa. Si la hay, no se puede acceder a esta pantalla ya que causará errores.
        HttpSession session = request.getSession();
        try {
            if (session.getAttribute("iniciada").equals(true) ) {
                // Redirección a la pantalla principal
                return "redirect:portada";
            }
        } catch (NullPointerException e) {
            System.out.println(e);
        }

        try {
            if (session.getAttribute("iniciadaP").equals(true) ) {
                // Redirección a la pantalla principal
                return "redirect:portada";
            }
        } catch (NullPointerException e) {
            System.out.println(e);
        }
        return "sesion/signup";
    }

    @POST
    @Path("/signup")
    public String registroHecho(@FormParam(value = "nombre") String nombre, @FormParam(value = "email") String email,  @FormParam(value = "contrasena") String contrasena, @FormParam(value = "icono") String icono, @FormParam(value = "profesor") String profesor) {
        // Creamos al Alumno nuevo en base a los datos mandados
        boolean error = false;
        List<Alumno> alumnos = alumnoService.findAll();
        for (Alumno a:alumnos) {
            if(a.getCorreo().equals(email)){
                error = true;

                // Hay que volver a mandar los profesores para la cargarlos en el select
                List<Profesor> profesores = profesorService.findAll();
                models.put("profesores", profesores);
                models.put("mensajeError", error);
                return "sesion/signup";
            }
        }

        try {

            if(icono == null){
                icono = "icono1";
            }

            Alumno alumnoNuevo = alumnoService.crearAlumno(profesor, icono, nombre, email, contrasena);

            // Iniciamos la sesión
            HttpSession session = request.getSession();
            session.setAttribute("iniciada", true);
            session.setAttribute("alumno", alumnoNuevo.getCodigoAlumno());
            session.setAttribute("id", alumnoNuevo.getId());
            return "redirect:perfil";

        } catch (NoResultException e) {
            System.out.println(e);
            return "redirect:perfil";
        }

    }

}
