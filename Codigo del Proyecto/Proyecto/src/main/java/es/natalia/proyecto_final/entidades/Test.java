package es.natalia.proyecto_final.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "test")

// La entidad TEST recoge las preguntas y respuesta que hay por nivel
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "codigo", nullable = false, unique = true, length = 4)
    private String codigo;

    @Column(name = "terminado", nullable = false)
    private Boolean terminado = false;

    // Nivel al que pertenece el test
    @OneToOne(mappedBy = "test", optional = false, orphanRemoval = true)
    //@JsonIgnore
    private Nivel nivel;

    // Listado de preguntas que tiene cada test
    @OneToMany(mappedBy = "test", orphanRemoval = true)
    //@JsonIgnore
    //@JsonManagedReference
    private Set<Pregunta> preguntas = new LinkedHashSet<>();


}
