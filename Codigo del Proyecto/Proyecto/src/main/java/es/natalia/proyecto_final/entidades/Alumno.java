package es.natalia.proyecto_final.entidades;

import jakarta.persistence.*;
import lombok.Data;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "alumno")
// La entidad ALUMNO define a los usuarios que usaran la plataforma
public class Alumno {

    // Constructores, uno vacío y otro para crear Alumnos(usuarios)
    public Alumno() {

    }
    public Alumno(String nombre, String correo, String contrasena, String icono, String codigoAlumno, Profesor profesor) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.puntos = 0;
        this.icono = icono;
        this.codigoAlumno = codigoAlumno;
        this.profesor = profesor;
    }
    // Setter para actualizar valores en el perfil del alumno
    public void setMundos(Mundo mundo) {
        this.mundos.add(mundo);
    }
    public void setIcono(String icono) {
        this.icono = icono;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    // Nombre: Nombre elegido por el alumno
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    // Correo: Usado para dar de alta la cuenta, una de las opciones para el login
    @Column(name = "correo", nullable = false, unique = true, length = 100)
    private String correo;

    // Contraseña: Decidida por cada alumno en su login.
    @Column(name = "contrasena", nullable = false, length = 30)
    private String contrasena;

    // Puntuacion: Total de todos los puntos del alumno
    @Column(name = "puntos", length = 4)
    private Integer puntos;

    // Icono: Imagen elegida por el usuario, sería su nombre de archivo (icono1.png)
    @Column(name = "icono", length = 300)
    private String icono;

    // Codigo alumno: Para identificarlos y ordenarlos por profesor, deben tener delante del código la letra de este (A001)
    @Column(name = "codigo_alumno", nullable = false, unique = true, length = 4)
    private String codigoAlumno;


    // Profesor asignado a cada alumno, solo uno por alumno.
    @ManyToOne(optional = false)
    @JoinColumn(name = "profesor_id", nullable = false)
    private Profesor profesor;

    // Mundos desbloqueados por el alumno (1,n)
    @ManyToMany
    @JoinTable(name = "alumno_mundos",
            joinColumns = @JoinColumn(name = "alumno_id"),
            inverseJoinColumns = @JoinColumn(name = "mundos_id"))
    private Set<Mundo> mundos = new LinkedHashSet<>();

}
