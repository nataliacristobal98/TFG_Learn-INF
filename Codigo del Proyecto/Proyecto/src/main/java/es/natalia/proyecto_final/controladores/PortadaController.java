package es.natalia.proyecto_final.controladores;

import jakarta.enterprise.context.RequestScoped;
import jakarta.mvc.Controller;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Path("/portada")
@Controller
@RequestScoped
public class PortadaController {

    // La portada principal, de momento solo nos sirve de presentación para el enrutado de los demás Controladores
    @Path("/")
    @GET
    public String index() {
        return "portada/portada";
    }

}
