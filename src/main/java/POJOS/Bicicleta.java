package POJOS;

public class Bicicleta extends Vehiculo{

    private String tipo;
    private boolean tieneCambio;

    public boolean isTieneCambio() {return tieneCambio;}
    public void setTieneCambio(boolean tieneCambio) {this.tieneCambio = tieneCambio;}
    public String getTipo() {return tipo;}
    public void setTipo(String tipo) {this.tipo = tipo;}

    public Bicicleta(int id, String marca, String modelo, float precio) {
        super(id, marca, modelo, precio);
    }

    public Bicicleta(int id, String marca, String modelo, float precio, String tipo, boolean tieneCambio) {
        super(id, marca, modelo, precio);
        this.tipo = tipo;
        this.tieneCambio = tieneCambio;
    }

    @Override
    public String getDescripcion(){
        return "Se trata de una bicicleta de marca " +getMarca() + "del modelo " +getModelo() + "con un precio de " +getPrecio();
    }
}
