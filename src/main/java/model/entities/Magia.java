package model.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "magias")
public class Magia {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 30)
    private String nombre;

    @Lob
    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "esquirla", length = 30)
    private String esquirla;

    @ManyToMany(mappedBy = "magias")
    public List<Personaje> personajes = new ArrayList<>();

    public Magia(String nombre, String descripcion, String esquirla) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.esquirla = esquirla;
    }

    public Magia() {
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEsquirla() {
        return esquirla;
    }

    public void setEsquirla(String esquirla) {
        this.esquirla = esquirla;
    }

}