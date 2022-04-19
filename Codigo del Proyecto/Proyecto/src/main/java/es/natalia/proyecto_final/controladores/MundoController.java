package es.natalia.proyecto_final.controladores;

import es.natalia.proyecto_final.entidades.*;
import es.natalia.proyecto_final.servicios.AlumnoService;
import es.natalia.proyecto_final.servicios.MundoService;
import es.natalia.proyecto_final.servicios.NivelService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Path("/mundos/mundo")
@Controller
@RequestScoped
public class MundoController {

    @Inject
    HttpServletRequest request;

    @Inject
    private Models models;

    @Inject
    AlumnoService alumnoService;

    @Inject
    MundoService mundoService;

    @Inject
    NivelService nivelService;

    // Listado de Mundos, en esta pantalla se accese a los niveles
    @GET
    @Path("/")
    public String index() {
        // Comprobamos que haya una sesión iniciada, ya que si no existe ninguna no se podría acceder a esta parte de la web
        HttpSession session = request.getSession();
        try {
            if (session.getAttribute("iniciada").equals(true)) {
                // Obtenemos el alumno que está activo
                Alumno alumno = alumnoService.buscarPorId(Long.parseLong(session.getAttribute("id").toString()));

                // Llamamos al método findAll() para el listado de Mundos disponibles en la BD
                models.put("alumno", alumno);
                models.put("mundos", mundoService.findAll());
                return "mundos/mundos-listado";
            }
        } catch (NullPointerException e) {
            // Si no hay una sesión, se permite el acceso o crear una.
            return "sesion/login";
        }
        return "sesion/login";

    }

    // Listado de Niveles por el Mundo seleccionado. Se pasa el id del Mundo para rescatar los Niveles asociado a este.
    @GET
    @Path("{id}")
    public String detalle(@PathParam("id") @NotNull Long id) {

        HttpSession session = request.getSession();
        Optional<Mundo> mundo = mundoService.buscarPorId(id);

        if (mundo.isPresent()) {
            Alumno alumno = alumnoService.buscarPorId(Long.parseLong(session.getAttribute("id").toString()));
            // Si el Mundo existe, se hará la busqueda de Niveles pertinente, para ello llamamos al método correspondiente
            List<Nivel> niveles = nivelService.buscarNiveles(mundo.get());

            models.put("mundo", mundo.get());
            models.put("alumno", alumno);
            // Mandamos los datos de los Niveles para usarlos en la pantalla
            models.put("niveles", niveles);
            return "mundos/mundo-nivel";
        }
        return "redirect:mundos/mundo-listado";
    }


}
