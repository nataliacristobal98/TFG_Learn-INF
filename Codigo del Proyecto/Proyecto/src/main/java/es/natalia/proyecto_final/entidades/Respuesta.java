package es.natalia.proyecto_final.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "respuesta")

// La entidad RESPUESTA define las respuestas posibles a una pregunta, pueden ser acertadas o no
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    // Código pregunta: El código resultante del nivel + R (_R01)
    @Column(name = "codigo", nullable = false, unique = true, length = 6)
    private String codigo;

    @Column(name = "texto_respuesta", nullable = false, length = 300)
    private String textoRespuesta;

    // Correcta: Si la respuesta en cuestión es correcta o no a su pregunta asociada
    @Column(name = "correcta", nullable = false)
    private Boolean correcta = false;


    // La pregunta a la que pertenece la respuesta
    @ManyToOne(optional = false)
    @JoinColumn(name = "pregunta_id", nullable = false)
    @JsonBackReference
    private Pregunta pregunta;

}
