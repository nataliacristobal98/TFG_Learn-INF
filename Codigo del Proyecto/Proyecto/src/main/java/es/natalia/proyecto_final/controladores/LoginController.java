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
        // Controlamos que haya una sesión activa. Si la hay, no se puede acceder a esta pantalla ya que causará errores.
        HttpSession session = request.getSession();
        try {
            if (session.getAttribute("iniciada").equals(true)) {
                // Redirección a la pantalla principal
                return "redirect:portada";
            }
        } catch (NullPointerException e) {
            // Si no hay una sesión, se permite el acceso o crear una.
            return "sesion/login";
        }
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
                    session.setAttribute("iniciada", true);
                    session.setAttribute("idP", profesor.getId());

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
