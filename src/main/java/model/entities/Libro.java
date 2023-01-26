package model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "planeta", nullable = false)
    private Planeta planeta;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "saga", nullable = false)
    private Sagas saga;

    public Libro() {
    }

    public Libro(String nombre, Planeta planeta, Sagas saga) {
        this.nombre = nombre;
        this.planeta = planeta;
        this.saga = saga;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Planeta getPlaneta() {
        return planeta;
    }

    public void setPlaneta(Planeta planeta) {
        this.planeta = planeta;
    }

    public Sagas getSaga() {
        return saga;
    }

    public void setSaga(Sagas saga) {
        this.saga = saga;
    }

}