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
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import lombok.extern.slf4j.Slf4j;

import java.util.List;


@Slf4j
@Path("/profesor")
@Controller
@RequestScoped
public class PerfilProfesorController {

    @Inject
    private Models models;

    @Inject
    AlumnoService alumnoService;

    @Inject
    ProfesorService profesorService;

    @Inject
    HttpServletRequest request;

    @Path("/")
    @GET
    public String index() {

        // Comprobamos que la sesión esté activa para así recoger los datos del Alumno y mostrarlos
        HttpSession session = request.getSession();
        try {
            if (session.getAttribute("iniciadaP").equals(true)) {
                Long id = Long.parseLong(session.getAttribute("idP").toString());

                Profesor profesor = profesorService.buscarPorId(id);
                List<Alumno> alumnos = profesorService.listadoAlumnos(profesor);

                models.put("profesor", profesor);
                models.put("listadoAlumnos", alumnos);
                return "usuarios/perfil-profesor";
            }
        }catch (NullPointerException e){
            // Si no hay una sesión, se permite el acceso o crear una.
            return "redirect:login";
        }

        return "redirect:login";
    }

    @Path("/cerrar")
    @GET
    public String desconectar(){
        // Destruimos la sesión para permitir usar otras cuentas
        HttpSession session = request.getSession();
        session.invalidate();

        return "redirect:login";
    }

}
