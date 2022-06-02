package es.natalia.learninf.servicios;

import es.natalia.learninf.entidades.Alumno;
import es.natalia.learninf.entidades.Profesor;
import es.natalia.learninf.repositorio.AlumnoRepository;
import es.natalia.learninf.repositorio.ProfesorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.text.Normalizer;
import java.util.List;
import java.util.Random;

@ApplicationScoped
public class AlumnoService {

    @Inject
    AlumnoRepository alumnoRepository;

    @Inject
    ProfesorRepository profesorRepository;

    // Para encontrar a los Alumnos
    public List<Alumno> findAll() {
        return alumnoRepository.findAll();
    }
    public Alumno buscarPorId(Long id) {
        return alumnoRepository.findBy(id);
    }

    // Buscar a los Alumnos para el login
    public Alumno buscarAlumno(String codigo){return alumnoRepository.findByCodigoAlumno(codigo);}
    public Alumno buscarAlumnoCorreo(String correo){return alumnoRepository.findByCorreo(correo);}

    // Creación de un Alumno nuevo
    public Alumno crearAlumno(String profesor, String icono, String nombre, String email, String contrasena){
        Profesor profesorEncontrado = profesorRepository.findBy(Long.parseLong(profesor));

        Random random = new Random();
        int x = random.nextInt(900) + 100;
        String codigoAlumnoNuevo = profesorEncontrado.getCodigoProfesor() + x;

        switch (icono) {
            case "icono1":
                icono = "/learnINF/resources/img/icon1.jpg";
                break;
            case "icono2":
                icono = "/learnINF/resources/img/icon2.jpg";
                break;
            case "icono3":
                icono = "/learnINF/resources/img/icon3.jpg";
                break;
            case "icono4":
                icono = "/learnINF/resources/img/icon4.jpg";
                break;
            case "icono5":
                icono = "/learnINF/resources/img/icon5.jpg";
                break;
            case "icono6":
                icono = "/learnINF/resources/img/icon6.jpg";
                break;
            case "icono7":
                icono = "/learnINF/resources/img/icon7.jpg";
                break;
            case "icono8":
                icono = "/learnINF/resources/img/icon8.jpg";
                break;
            default:
                icono = "/learnINF/resources/img/icon9.jpg";
                break;
        }

        String cadenaNormalize = Normalizer.normalize(nombre, Normalizer.Form.NFD);
        String cadenaSinAcentos = cadenaNormalize.replaceAll("[^\\p{ASCII}]", "");

        Alumno alumnoNuevo = new Alumno(cadenaSinAcentos, email, contrasena, icono, codigoAlumnoNuevo, profesorEncontrado);
        this.guardar(alumnoNuevo);

        return alumnoNuevo;
    }

    // Guardar los puntos ganadaos de un Alumno es el test
    public void guardarPuntos(Integer puntos, Alumno alumno){
        alumno.setPuntos(alumno.getPuntos()+puntos);
        this.guardar(alumno);
    }

    // Cambiar el icon del perfil del Alumno
    public void cambiarIcon(Alumno alumno, String icono){
        alumno.setIcono(icono);
        this.guardar(alumno);
    }

    // Salvar cambios en el la entidad Alumno en la BD
    public void guardar(Alumno alumno){
        // Comprobar puntos y desbloqueos
        /*
        List<Mundo> mundos = mundoRepository.findAll();
        for (int i = 0; i < mundos.size() -1; i++) {
            if(alumno.getPuntos() >= mundos.get(i).getPuntosDesbloqueo()){
                alumno.setMundos(mundos.get(i));
            }
        }
        */
        alumnoRepository.save(alumno);
    }
}
