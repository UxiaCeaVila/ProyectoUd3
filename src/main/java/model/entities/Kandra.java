package model.entities;

public class Kandra extends Especies{
    private String contrato;
    private String bendicion;

    public Kandra( String nombre, Planeta planetaOrigen, Integer fisiologia, String contrato, String bendicion) {
        super(nombre, planetaOrigen, fisiologia);
        this.contrato = contrato;
        this.bendicion = bendicion;
    }
    public void setcontrato(String contrato) {
        this.contrato = contrato;
    }

    public String getcontrato() {
        return contrato;
    }

    public void setcbendicion(String bendicion) {
        this.bendicion = bendicion;
    }

    public String getbendicion() {
        return bendicion;
    }
}
