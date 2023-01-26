package model.entities;

public class Humano extends Especies{
    private String cualidades;


    public Humano( String nombre, Planeta planetaOrigen, Integer fisiologia, String cualidades) {
        super(nombre, planetaOrigen, fisiologia);
        this.cualidades = cualidades;
    }
    public void setCualidades(String cualidades) {
        this.cualidades = cualidades;
    }

    public String getCualidades() {
        return cualidades;
    }


}
