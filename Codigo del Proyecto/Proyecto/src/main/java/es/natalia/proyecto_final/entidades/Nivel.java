package es.natalia.proyecto_final.entidades;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "nivel")

// La entidad NIVEL recoge las lecciones y tests de los distintos temas de cada mundo.
public class Nivel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    // Codigo: Combina el código del mundo + num (Si el mundo es HTML - H01)
    @Column(name = "codigo_nivel", nullable = false, unique = true, length = 4)
    private String codigoNivel;

    @Column(name = "dificultad", nullable = false)
    private Integer dificultad;

    // Puntuación máx por nivel
    @Column(name = "puntuacion_max", nullable = false)
    private Integer puntuacionMaxima;

    // Puntuación min para desbloquear el nivel
    @Column(name = "puntuacion_min", nullable = false)
    private Integer puntuacionMinima;

    // Puntos necesarios que tiene que tener el usuario para acceder al nivel
    @Column(name = "puntos_desbloqueo", nullable = false)
    private Integer puntosDesbloqueo;


    // Al mundo al que pertenece cada nivel
    @ManyToOne(optional = false)
    @JoinColumn(name = "mundo_id", nullable = false)
    private Mundo mundo;

    // Puede o no tener una recompensa en el nivel, pero estas son únicas
    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "recompensa_id", unique = true, nullable = true)
    private Recompensa recompensa;

    // Lección que corresponde al nivel
    @OneToOne(optional = false, orphanRemoval = true)
    @JoinColumn(name = "leccion_id", nullable = false)
    private Leccion leccion;

    // Test que corresponde al nivel
    @OneToOne(optional = false, orphanRemoval = true)
    @JoinColumn(name = "test_id", nullable = false, unique = true)
    private Test test;


}
