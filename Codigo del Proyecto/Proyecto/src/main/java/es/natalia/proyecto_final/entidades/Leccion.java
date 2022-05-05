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

    @Column(name = "titulo_leccion", nullable = false, length = 100)
    private String tituloLeccion;

    @Column(name = "contenido1", nullable = false, length = 500)
    private String contenido1;

    @Column(name = "contenido2", length = 500)
    private String contenido2;

    @Column(name = "imagen_leccion", length = 300)
    private String imagenLeccion;

    // Nivel al que pertence la lección
    @OneToOne(mappedBy = "leccion", optional = false, orphanRemoval = true)
    private Nivel nivel;

}
