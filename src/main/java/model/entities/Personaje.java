package model.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "personajes")
public class Personaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "edad", length = 5)
    private String edad;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "especie", nullable = false)
    private Especies especie;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "planeta_origen", nullable = false)
    private Planeta planetaOrigen;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "personaje_magia",
            joinColumns = @JoinColumn(name = "personaje_id"),
            inverseJoinColumns = @JoinColumn(name = "magia_id")
    )
    private List<Magia> magias = new ArrayList<>();

    public Personaje() {
    }

    public Personaje(String nombre, String edad, Especies especie, Planeta planetaOrigen) {
        this.nombre = nombre;
        this.edad = edad;
        this.especie = especie;
        this.planetaOrigen = planetaOrigen;
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

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public Especies getEspecie() {
        return especie;
    }

    public void setEspecie(Especies especie) {
        this.especie = especie;
    }

    public Planeta getPlanetaOrigen() {
        return planetaOrigen;
    }

    public void setPlanetaOrigen(Planeta planetaOrigen) {
        this.planetaOrigen = planetaOrigen;
    }

    public List<Magia> getMagias() {
        return magias;
    }

    public void setMagias(List<Magia> magias) {
        this.magias = magias;
    }
}