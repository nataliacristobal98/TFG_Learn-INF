package es.natalia.proyecto_final.servicios;

import es.natalia.proyecto_final.entidades.Alumno;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@ApplicationScoped
public class SesionService {

    @Inject
    HttpServletRequest request;

    public HttpSession crearSesion(Alumno alumnoNuevo){
        HttpSession session = request.getSession();
        session.setAttribute("iniciada", true);
        session.setAttribute("alumno", alumnoNuevo.getCodigoAlumno());
        session.setAttribute("id", alumnoNuevo.getId());

        return session;
    }
}
