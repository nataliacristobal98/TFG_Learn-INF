package es.natalia.proyecto_final.entidades;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "recompensa")

// La entidad RECOMPENSA define los items que pueden obtener los alumnos al superar los niveles
public class Recompensa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    // Tipo de recompensa: Un icono, un diploma...
    @Column(name = "tipo", nullable = false, length = 50)
    private String tipo;

    // Ruta: Nombre del archivo de recompensa (diploma1.png)
    @Column(name = "ruta_recompensa", nullable = false, length = 300)
    private String rutaRecompensa;

    @Column(name = "desbloqueada", nullable = false)
    private Boolean desbloqueada = false;


    // Nivel al que pertenece la recompensa
    @OneToOne(mappedBy = "recompensa", optional = false, orphanRemoval = true)
    private Nivel nivel;


}
