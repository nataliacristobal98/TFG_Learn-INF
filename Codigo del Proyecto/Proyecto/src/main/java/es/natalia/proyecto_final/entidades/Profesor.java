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

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    // Código profesor: Identifica a cada profesor con una letra asignada, ayudará a identificar a sus alumnos (A-B-C...)
    @Column(name = "codigo_profesor", nullable = false, unique = true, length = 1)
    private String codigoProfesor;


    // Listado de alumnos que tiene cada profesor asignado
    @OneToMany(mappedBy = "profesor", orphanRemoval = true)
    private List<Alumno> alumnos = new ArrayList<>();

}
