package es.natalia.proyecto_final.controladores;

import es.natalia.proyecto_final.entidades.*;
import es.natalia.proyecto_final.servicios.AlumnoService;
import es.natalia.proyecto_final.servicios.NivelService;
import es.natalia.proyecto_final.servicios.ProfesorService;
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
    ProfesorService profesorService;

    @Inject
    NivelService nivelService;


    // Menú de Nivel -> Con su Lección y su Test correspondiente
    @GET
    @Path("{id}")
    public String editar(@PathParam("id") Long id) {
        HttpSession session = request.getSession();
        Nivel nivel = nivelService.buscarPorId(id);
        Test test = nivelService.buscarTest(nivel);
        Leccion leccion = nivelService.buscarLeccion(nivel);

        // Si la sesión de alumno
        try {
            if (session.getAttribute("iniciada").equals(true)) {
                Alumno alumno = alumnoService.buscarPorId(Long.parseLong(session.getAttribute("id").toString()));

                models.put("mundo", nivel.getMundo().getId());
                models.put("nivel", nivel);
                models.put("alumno", alumno);
                models.put("leccion", leccion);
                models.put("test", test);
                return "niveles/nivel-leccion";

            }
        } catch (NullPointerException e) {
            System.out.println(e);
        }

        // Si la sesión es de profesor
        try {
            if(session.getAttribute("iniciadaP").equals(true)) {
                // Obtenemos el profesor
                Profesor profesor = profesorService.buscarProfesorCod(session.getAttribute("codP").toString());

                models.put("mundo", nivel.getMundo().getId());
                models.put("nivel", nivel);
                models.put("profesor", profesor);
                models.put("leccion", leccion);
                models.put("test", test);
                return "niveles/nivel-leccion";
            }

        } catch (NullPointerException e) {
            // Si no hay una sesión, se permite el acceso o crear una.
            return "sesion/login";
        }

        return "sesion/login";
    }

    @GET
    @Path("{idN}/{idT}")
    public String editar(@PathParam("idN") Long idN, @PathParam("idT") Long idT) {
        Nivel nivel = nivelService.buscarPorId(idN);

        // Obtenemos el Test y sus Preguntas y Respuestas asociadas
        Test test = nivelService.buscarPorIdTest(idT);

        // Para saber el test en el que estamos lo guardamos en la sesión, para luego poder terminarlo si se supera el test
        HttpSession session = request.getSession();
        session.setAttribute("testActual", idT);
        List<Pregunta> preguntas = nivelService.buscarPreguntas(test);
        List<Respuesta> respuestas = nivelService.buscarRespuestas();

        // Si la sesión de alumno
        try {
            if (session.getAttribute("iniciada").equals(true)) {
                Alumno alumno = alumnoService.buscarPorId(Long.parseLong(session.getAttribute("id").toString()));

                models.put("nivel", nivel);
                models.put("test", test);
                models.put("alumno", alumno);
                models.put("preguntas", preguntas);
                models.put("totalPreguntas", preguntas.size());
                models.put("respuestas", respuestas);
                return "niveles/nivel-test";

            }
        } catch (NullPointerException e) {
            System.out.println(e);
        }

        // Si la sesión es de profesor
        try {
            if(session.getAttribute("iniciadaP").equals(true)) {
                // Obtenemos el profesor
                Profesor profesor = profesorService.buscarProfesorCod(session.getAttribute("codP").toString());

                models.put("nivel", nivel);
                models.put("test", test);
                models.put("profesor", profesor);
                models.put("preguntas", preguntas);
                models.put("totalPreguntas", preguntas.size());
                models.put("respuestas", respuestas);
                return "niveles/nivel-test";
            }

        } catch (NullPointerException e) {
            // Si no hay una sesión, se permite el acceso o crear una.
            return "sesion/login";
        }

        return "sesion/login";

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
        Test test = nivelService.buscarPorIdTest(Long.parseLong(session.getAttribute("testActual").toString()));
        if(puntos>=5){
            alumnoService.guardarPuntos(puntos, alumno);
            //nivelService.terminarTest(test);
            session.setAttribute("puntosGanados", alumno.getPuntos());
            session.setAttribute("puntosTest", puntos);
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

        models.put("superado", 3);
        models.put("puntosTest", session.getAttribute("puntosTest"));
        models.put("puntos", Integer.parseInt(session.getAttribute("puntosGanados").toString()));
        return "niveles/nivel-final";
    }

}
