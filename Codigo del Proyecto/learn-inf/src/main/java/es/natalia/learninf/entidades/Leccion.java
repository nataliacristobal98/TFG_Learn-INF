package es.natalia.learninf.entidades;

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

    // Código lección: Para identificar cada lección segñun su temática
    @Column(name = "codigo_lec", nullable = false, unique = true, length = 4)
    private String codigoLeccion;

    // Título: Nombre para la lección
    @Column(name = "titulo_leccion", nullable = false, length = 200)
    private String tituloLeccion;

    // Contenido 1: Parte del texto de la lección
    @Column(name = "contenido1", nullable = false, length = 1000)
    private String contenido1;

    // Contenido 2: Parte del texto de la lección, puede existir o no
    @Column(name = "contenido2", length = 1000)
    private String contenido2;

    // Imagen: Complemento para la lección
    @Column(name = "imagen_leccion", length = 300)
    private String imagenLeccion;

    // Nivel al que pertence la lección
    @OneToOne(mappedBy = "leccion", optional = false, orphanRemoval = true)
    private Nivel nivel;
}
