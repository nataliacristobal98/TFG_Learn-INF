package es.natalia.learninf.controladores;

import es.natalia.learninf.entidades.*;
import es.natalia.learninf.servicios.AlumnoService;
import es.natalia.learninf.servicios.NivelService;
import es.natalia.learninf.servicios.ProfesorService;
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

        // Buscamos la sesión activa, la lección y el test del nivel correspondiente
        HttpSession session = request.getSession();
        Nivel nivel = nivelService.buscarPorId(id);
        Test test = nivelService.buscarTest(nivel);
        Leccion leccion = nivelService.buscarLeccion(nivel);

        try {
            // Si la sesión es de alumno
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

        try {
            // Si la sesión es de profesor
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
            System.out.println(e);
        }

        // Si no se encuentra una sesión, se redirecciona al login
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
        session.setAttribute("nivelActual", idN);
        session.setAttribute("testActual", idT);
        List<Pregunta> preguntas = nivelService.buscarPreguntas(test);
        List<Respuesta> respuestas = nivelService.buscarRespuestas();

        try {
            // Si la sesión es de alumno
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

        try {
            // Si la sesión es de profesor
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
            System.out.println(e);
        }

        return "sesion/login";
    }


    // Para los siguientes métodos no necesitamos saber que tipo de sesión es, ya que los profesores no tienen
    // acceso a estas funciones
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
        Nivel nivel = nivelService.buscarPorId(Long.parseLong(session.getAttribute("nivelActual").toString()));

        // Si los puntos son igual o mayores a los necesarios para aprobarlo, se finaliza el test con exito
        if(puntos >= nivel.getPuntuacionMinima()){
            // Se suman los puntos a la cuenta del alumno
            alumnoService.guardarPuntos(puntos, alumno);
            //nivelService.terminarTest(test);
            session.setAttribute("puntosGanados", alumno.getPuntos());
            session.setAttribute("puntosTest", puntos);
        }else{
            // Si no se supera el test, no se gana ninguno
            session.setAttribute("puntosGanados", 0);
        }
        return "redirect:niveles/nivel/testSuperado";
    }

    @GET
    @Path("/testSuperado")
    public String superado() {
        HttpSession session = request.getSession();
        Nivel nivel = nivelService.buscarPorId(Long.parseLong(session.getAttribute("nivelActual").toString()));

        // Pantalla final, se indica si el test está superado o no
        models.put("superado", nivel.getPuntuacionMinima());
        models.put("puntosTest", session.getAttribute("puntosTest"));
        models.put("puntos", Integer.parseInt(session.getAttribute("puntosGanados").toString()));
        return "niveles/nivel-final";
    }

}
