package es.natalia.proyecto_final.servicios;

import es.natalia.proyecto_final.entidades.Alumno;
import es.natalia.proyecto_final.entidades.Mundo;
import es.natalia.proyecto_final.entidades.Profesor;
import es.natalia.proyecto_final.repositorio.AlumnoRepository;
import es.natalia.proyecto_final.repositorio.MundoRepository;
import es.natalia.proyecto_final.repositorio.ProfesorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.text.Normalizer;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@ApplicationScoped
public class AlumnoService {

    @Inject
    AlumnoRepository alumnoRepository;

    @Inject
    ProfesorRepository profesorRepository;

    public Alumno buscarPorId(Long id) {
        return alumnoRepository.findBy(id);
    }

    public Alumno crearAlumno(String profesor, String icono, String nombre, String contrasena){
        Profesor profesorEncontrado = profesorRepository.findBy(Long.parseLong(profesor));

        Random random = new Random();
        int x = random.nextInt(900) + 100;
        String codigoAlumnoNuevo = profesorEncontrado.getCodigoProfesor() + x;

        if(icono.equals("icono1")){
            icono = "/proyecto_final/resources/img/icono1.jpg";
        }else if(icono.equals("icono2")){
            icono = "/proyecto_final/resources/img/icono2.jpg";
        } else{
            icono = "/proyecto_final/resources/img/icono3.jpg";
        }

        String cadenaNormalize = Normalizer.normalize(nombre, Normalizer.Form.NFD);
        String cadenaSinAcentos = cadenaNormalize.replaceAll("[^\\p{ASCII}]", "");

        Alumno alumnoNuevo = new Alumno(cadenaSinAcentos, contrasena, icono, codigoAlumnoNuevo, profesorEncontrado);
        this.guardar(alumnoNuevo);

        return alumnoNuevo;
    }

    public void guardarPuntos(Integer puntos, Alumno alumno){
        alumno.setPuntos(alumno.getPuntos()+puntos);
        this.guardar(alumno);
    }

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

    public Alumno buscarAlumno(String codigo){return alumnoRepository.findByCodigoAlumno(codigo);}
}
