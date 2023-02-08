package model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "planetas")
public class Planeta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "sistema", nullable = false, length = 40)
    private String sistema;

    @Column(name = "esquirla", length = 30)
    private String esquirla;

    public Planeta() {
    }

    public Planeta(String nombre, String sistema, String esquirla) {
        this.nombre = nombre;
        this.sistema = sistema;
        this.esquirla = esquirla;
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

    public String getSistema() {
        return sistema;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }

    public String getEsquirla() {
        return esquirla;
    }

    public void setEsquirla(String esquirla) {
        this.esquirla = esquirla;
    }

}