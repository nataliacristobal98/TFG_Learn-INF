package es.natalia.proyecto_final.controladores;

import es.natalia.proyecto_final.entidades.Alumno;
import es.natalia.proyecto_final.entidades.Profesor;
import es.natalia.proyecto_final.servicios.AlumnoService;
import es.natalia.proyecto_final.servicios.ProfesorService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.persistence.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Path("/login")
@Controller
@RequestScoped
public class LoginController {

    @Inject
    HttpServletRequest request;

    @Inject
    AlumnoService alumnoService;

    @Inject
    ProfesorService profesorService;

    @Inject
    private Models models;

    @Path("/")
    @GET
    public String index() {
        // A lo largo de todas las pantallas vamos a controlar si hay una sesión activa, y en caso de estarlo de que tipo es
        HttpSession session = request.getSession();

        try {
            // Comprobamos si la sesión activa es de alumno
            if (session.getAttribute("iniciada").equals(true)) {
                // Redirección a la pantalla principal
                return "redirect:portada";
            }
        } catch (NullPointerException e) {
            System.out.println(e);
        }
        try {
            // Comprobamos si la sesión activa es de PROFESOR
            if (session.getAttribute("iniciadaP").equals(true) ) {
                // Redirección a la pantalla principal
                return "redirect:portada";
            }
        } catch (NullPointerException e) {
            System.out.println(e);
        }

        // En caso de no tener una sesión activa se permitirá el acceso a esta pantalla
        return "sesion/login";
    }

    @POST
    @Path("/login")
    public String index(@FormParam(value = "codigo") String codigo, @FormParam(value = "contrasena") String contrasena) {
        //System.out.println(codigo + "/" + contrasena);
        boolean error = false;
        try {
            // Comprobamos que el alumno existe, para ello obtenemos el código introducido.
            Alumno alumno = alumnoService.buscarAlumno(codigo);

            if (alumno != null) {
                // Si el código existe comprobamos la contraseña
                if (alumno.getContrasena().equals(contrasena)) {

                    // Si ambos parámetros son correctos iniciamos la sesión
                    HttpSession session = request.getSession();
                    session.setAttribute("iniciada", true);
                    session.setAttribute("alumno", alumno.getCodigoAlumno());
                    session.setAttribute("id", alumno.getId());

                    // Redirect porque es otro controller
                    return "redirect:perfil";
                } else {
                    error = true;
                    models.put("mensajeError", error);
                    return "sesion/login";
                }
            }
        } catch (NoResultException e) {
            System.out.println(e);
        }

        try {
            // Comprobamos que el alumno existe, para ello obtenemos el correo introducido.
            Alumno alumno = alumnoService.buscarAlumnoCorreo(codigo);

            if (alumno != null) {
                // Si el código existe comprobamos la contraseña
                if (alumno.getContrasena().equals(contrasena)) {

                    // Si ambos parámetros son correctos iniciamos la sesión
                    HttpSession session = request.getSession();
                    session.setAttribute("iniciada", true);
                    session.setAttribute("alumno", alumno.getCodigoAlumno());
                    session.setAttribute("id", alumno.getId());

                    // Redirect porque es otro controller
                    return "redirect:perfil";
                } else {
                    error = true;
                    models.put("mensajeError", error);
                    return "sesion/login";
                }
            }
        } catch (NoResultException e) {
            System.out.println(e);
        }

        try {
            // Comprobamos que el alumno existe, para ello obtenemos el correo introducido.
            Profesor profesor = profesorService.buscarProfesorCorreo(codigo);

            if (profesor != null) {
                // Si el código existe comprobamos la contraseña
                if (profesor.getContrasena().equals(contrasena)) {

                    // Si ambos parámetros son correctos iniciamos la sesión
                    HttpSession session = request.getSession();
                    session.setAttribute("iniciadaP", true);
                    session.setAttribute("idP", profesor.getId());
                    session.setAttribute("codP", profesor.getCodigoProfesor());

                    // Redirect porque es otro controller
                    return "redirect:profesor";
                }
            }
        } catch (NoResultException e) {
            System.out.println(e);
            return "sesion/login";
        }



        return "sesion/login";
    }


}
