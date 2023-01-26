package model.entities;

public class Vinculo extends Magia{
    private String orden;

    public Vinculo( String nombre, String descripcion, String esquirla, String orden) {
        super( nombre, descripcion, esquirla);
        this.orden = orden;
    }
    public void setorden(String orden) {
        this.orden = orden;
    }

    public String getorden() {
        return orden;
    }
}
