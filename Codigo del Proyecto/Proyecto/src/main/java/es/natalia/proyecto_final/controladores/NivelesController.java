package es.natalia.proyecto_final.controladores;

import es.natalia.proyecto_final.entidades.*;
import es.natalia.proyecto_final.servicios.AlumnoService;
import es.natalia.proyecto_final.servicios.NivelService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Path("/niveles/nivel")
@Controller
@RequestScoped
public class NivelesController {

    @Inject
    HttpServletRequest request;

    @Inject
    private Models models;

    @Inject
    AlumnoService alumnoService;


    @Inject
    NivelService nivelService;


    // Menú de Nivel -> Con su Lección y su Test correspondiente
    @GET
    @Path("{id}")
    public String editar(@PathParam("id") Long id) {

        Nivel nivel = nivelService.buscarPorId(id);

        Test test = nivelService.buscarTest(nivel);
        Leccion leccion = nivelService.buscarLeccion(nivel);

        models.put("mundo", nivel.getMundo().getId());
        models.put("nivel", nivel);
        models.put("leccion", leccion);
        models.put("test", test);
        return "niveles/nivel-menu";
    }

    @GET
    @Path("{idN}/{idT}")
    public String editar(@PathParam("idN") Long idN, @PathParam("idT") Long idT) {

        Nivel nivel = nivelService.buscarPorId(idN);

        // Obtenemos el Test y sus Preguntas y Respuestas asociadas
        Test test = nivelService.buscarPorIdTest(idT);
        List<Pregunta> preguntas = nivelService.buscarPreguntas(test);

        List<Respuesta> respuestas = nivelService.buscarRespuestas();

        models.put("nivel", nivel);
        models.put("test", test);
        models.put("preguntas", preguntas);
        models.put("totalPreguntas", preguntas.size());
        models.put("respuestas", respuestas);
        return "niveles/nivel-test";
    }

    @POST
    @Path("/resultTest")
    public String resultadosTest(@FormParam(value = "respuestas[]") List<String> respuestas) {

        // Obtenemos todas las respuestas mediante AJAX
        System.out.println("Resultados Formulario: " + respuestas.toString());

        // Para incluir los puntos al Alumno en cuestión lo buscamos en la sesión
        HttpSession session = request.getSession();
        Alumno alumno = alumnoService.buscarPorId(Long.parseLong(session.getAttribute("id").toString()));
        Integer puntos = 0;

        // Para saber si se supera el Test, y por tanto obtener los puntos, se comprueba si está superado
        for (String respuestaSelect : respuestas) {
            Respuesta respuesta = nivelService.buscarIdRespuesta(Long.parseLong(respuestaSelect));
            // Añadimos los puntos al Alumno
            if (respuesta.getCorrecta()) {
                puntos++;
            }
        }

        if(puntos>=5){
            alumnoService.guardarPuntos(puntos, alumno);
            session.setAttribute("puntosGanados", alumno.getPuntos());
        }else{
            session.setAttribute("puntosGanados", 0);
        }

        return "redirect:niveles/nivel/testSuperado";
    }

    // Página final del Test
    @GET
    @Path("/testSuperado")
    public String superado() {
        //System.out.println("ok, test superado");
        HttpSession session = request.getSession();

        models.put("superado", 5);
        models.put("puntos", Integer.parseInt(session.getAttribute("puntosGanados").toString()));
        return "niveles/nivel-final";
    }

}
