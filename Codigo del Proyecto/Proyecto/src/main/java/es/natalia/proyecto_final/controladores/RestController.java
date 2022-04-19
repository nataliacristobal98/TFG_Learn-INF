package es.natalia.proyecto_final.controladores;

import jakarta.enterprise.context.RequestScoped;
import jakarta.mvc.Controller;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Path("/donacion")
@Controller
@RequestScoped
public class RestController {

    @Path("/")
    @GET
    public String index() {
        return "rest/donaciones";
    }

}
