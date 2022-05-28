package es.natalia.learninf.entidades;

import jakarta.persistence.*;
import lombok.Data;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "test")
// La entidad TEST recoge las preguntas y respuesta que hay por nivel
public class Test {

    // Constructores, uno vacío y otro para cambiar el estado del Test
    public Test() {

    }
    public Boolean getTerminado() {
        return terminado;
    }
    public void setTerminadoTrue() {
        this.terminado = true;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    // Codigo: Para identificar el test de manera única
    @Column(name = "codigo", nullable = false, unique = true, length = 4)
    private String codigo;

    // Para indicar si el test está terminado
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
