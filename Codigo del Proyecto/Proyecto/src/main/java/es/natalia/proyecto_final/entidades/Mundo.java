package es.natalia.proyecto_final.entidades;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "mundo")

// La entidad MUNDO define los distintos temas y lenguajes que se van a enseñar y los separa.
public class Mundo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    // Código mundo: La primera o las dos primeras iniciales del Mundo (HTML - H)
    @Column(name = "codigo_mun", nullable = false, unique = true, length = 2)
    private String codigoMundo;

    // Tematica: HTML, CSS, Java...
    @Column(name = "tematica", nullable = false, length = 50)
    private String tematica;

    @Column(name = "dificultad", nullable = false)
    private Integer dificultad;

    // Puntos necesarios que tiene que tener el usuario para acceder al mundo
    @Column(name = "puntos_desbloqueo", nullable = false)
    private Integer puntosDesbloqueo;


    // Conjunto de niveles que componen al mundo
    @OneToMany(mappedBy = "mundo", orphanRemoval = true)
    private Set<Nivel> niveles = new LinkedHashSet<>();

    // Los alumnos que han desbloqueado dicho mundo
    @ManyToMany(mappedBy = "mundos")
    private List<Alumno> alumnos = new ArrayList<>();

}
