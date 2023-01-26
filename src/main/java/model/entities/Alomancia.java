package model.entities;

public class Alomancia extends Magia{
    private String clase;

    public Alomancia( String nombre, String descripcion, String esquirla, String clase) {
        super(nombre, descripcion, esquirla);
        this.clase = clase;
    }
    public void setclase(String clase) {
        this.clase = clase;
    }

    public String getclase() {
        return clase;
    }
}
