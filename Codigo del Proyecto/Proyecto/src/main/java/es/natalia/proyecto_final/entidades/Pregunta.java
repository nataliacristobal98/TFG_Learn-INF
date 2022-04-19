package es.natalia.proyecto_final.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "pregunta")

// La entidad PREGUNTA define las preguntas que hay por nivel y sus características.
public class Pregunta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    // Código pregunta: El código resultante del nivel + PR (_PR01)
    @Column(name = "codigo_pregunta", nullable = false, unique = true, length = 6)
    private String codigoPregunta;

    @Column(name = "texto_pregunta", nullable = false, length = 300)
    private String textoPregunta;

    // Imagen: Puede que haya preguntas con imagenes complementarias
    @Column(name = "imagen_pregunta")
    private String imagenPregunta;



    // Test al que pertenece la pregunta
    //@JsonBackReference
    @JsonIgnore
    @ManyToOne(optional = false)
    @JoinColumn(name = "test_id", nullable = false)
    private Test test;

    // Listado de respuestas que tiene la pregunta, serían un conjuto de 4 de las cuales solo una sería correcta
    //@JsonIgnore
    @OneToMany(mappedBy = "pregunta", orphanRemoval = true)
    @JsonManagedReference
    private List<Respuesta> respuestas = new ArrayList<>();


}
