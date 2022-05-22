package es.natalia.proyecto_final.entidades;

import jakarta.persistence.*;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "profesor")
// La entidad PROFESOR define al tutor de cada alumno
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    // Nombre: Nombre que identifica al profeor
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    // Correo: Clave de acceso para el profesor
    @Column(name = "correo", nullable = false, length = 100, unique = true)
    private String correo;

    // Contraseña: Para acceder a la cuenta
    @Column(name = "contrasena", nullable = false, length = 30)
    private String contrasena;

    // Código profesor: Identifica a cada profesor con una letra asignada, ayudará a identificar a sus alumnos (A-B-C...)
    @Column(name = "codigo_profesor", nullable = false, unique = true, length = 1)
    private String codigoProfesor;

    // Listado de alumnos que tiene cada profesor asignado
    @OneToMany(mappedBy = "profesor", orphanRemoval = true)
    private List<Alumno> alumnos = new ArrayList<>();
}
