package es.natalia.proyecto_final.entidades;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "leccion")

// La entidad LECCION define el contenido que se enseña por lección
public class Leccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    // Código lección:
    @Column(name = "codigo_lec", nullable = false, unique = true, length = 4)
    private String codigoLeccion;

    @Column(name = "contenido", nullable = false, length = 300)
    private String contenido;


    // Nivel al que pertence la lección
    @OneToOne(mappedBy = "leccion", optional = false, orphanRemoval = true)
    private Nivel nivel;

}
