package model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "especies")
public class Especies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre_especie", nullable = false, length = 50)
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "planeta_origen", nullable = false)
    private Planeta planetaOrigen;

    @Column(name = "fisiologia", nullable = false)
    private Integer fisiologia;

    public Especies() {
    }

    public Especies( String nombre, Planeta planetaOrigen, Integer fisiologia) {
        this.nombre = nombre;
        this.planetaOrigen = planetaOrigen;
        this.fisiologia = fisiologia;
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

    public Planeta getPlanetaOrigen() {
        return planetaOrigen;
    }

    public void setPlanetaOrigen(Planeta planetaOrigen) {
        this.planetaOrigen = planetaOrigen;
    }

    public Integer getFisiologia() {
        return fisiologia;
    }

    public void setFisiologia(Integer fisiologia) {
        this.fisiologia = fisiologia;
    }

}