package es.natalia.learninf.servicios;

import es.natalia.learninf.entidades.Alumno;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@ApplicationScoped
public class SesionService {

    @Inject
    HttpServletRequest request;

    // Para la creación de la sesión
    public HttpSession crearSesionAlumno(Alumno alumnoNuevo){
        HttpSession session = request.getSession();
        session.setAttribute("iniciada", true);
        session.setAttribute("alumno", alumnoNuevo.getCodigoAlumno());
        session.setAttribute("id", alumnoNuevo.getId());

        return session;
    }
}
