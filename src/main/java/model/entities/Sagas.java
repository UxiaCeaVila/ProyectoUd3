package model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "sagas")
public class Sagas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "longitud", nullable = false, length = 2)
    private String longitud;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "planeta", nullable = false)
    private Planeta planeta;

    public Sagas() {
    }

    public Sagas(String nombre, String longitud, Planeta planeta) {
        this.nombre = nombre;
        this.longitud = longitud;
        this.planeta = planeta;
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

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public Planeta getPlaneta() {
        return planeta;
    }

    public void setPlaneta(Planeta planeta) {
        this.planeta = planeta;
    }

}