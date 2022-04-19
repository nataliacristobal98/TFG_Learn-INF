package es.natalia.proyecto_final.controladores;

import es.natalia.proyecto_final.entidades.Alumno;
import es.natalia.proyecto_final.servicios.AlumnoService;
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
@Path("/perfil")
@Controller
@RequestScoped
public class PerfilAlumnoController {

    @Inject
    private Models models;

    @Inject
    AlumnoService alumnoService;

    @Inject
    HttpServletRequest request;

    @Path("/")
    @GET
    public String index() {

        // Comprobamos que la sesión esté activa para así recoger los datos del Alumno y mostrarlos
        HttpSession session = request.getSession();
        try {
            if (session.getAttribute("iniciada").equals(true)) {
                Long id = Long.parseLong(session.getAttribute("id").toString());

                Alumno alumno = alumnoService.buscarPorId(id);

                models.put("alumno", alumno);
                return "usuarios/perfil-alumno";
            }
        }catch (NullPointerException e){
            // Si no hay una sesión, se permite el acceso o crear una.
            return "redirect:login";
        }

        return "redirect:login";
    }

    @Path("/desconectar")
    @GET
    public String desconectar(){
        // Destruimos la sesión para permitir usar otras cuentas
        HttpSession session = request.getSession();
        session.invalidate();

        return "redirect:login";
    }

}
