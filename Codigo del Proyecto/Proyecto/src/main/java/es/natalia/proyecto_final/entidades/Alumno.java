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
    public Alumno(String nombre, String contrasena, String icono, String codigoAlumno, Profesor profesor) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.puntos = 0;
        this.icono = icono;
        this.codigoAlumno = codigoAlumno;
        this.profesor = profesor;
    }

    public void setMundos(Mundo mundo) {
        this.mundos.add(mundo);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    // Contraseña: Decidida por cada alumno en su login.
    @Column(name = "contrasena", nullable = false, length = 10)
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
