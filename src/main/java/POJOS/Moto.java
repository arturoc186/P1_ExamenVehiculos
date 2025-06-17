package POJOS;

public class Moto extends Vehiculo{

    private int cilindrada;
    private boolean tieneSidecar;

    public int getCilindrada() {return cilindrada;}
    public void setCilindrada(int cilindrada) {this.cilindrada = cilindrada;}
    public boolean isTieneSidecar() {return tieneSidecar;}
    public void setTieneSidecar(boolean tieneSidecar) {this.tieneSidecar = tieneSidecar;}

    public Moto(int id, String marca, String modelo, float precio) {
        super(id, marca, modelo, precio);
    }

    @Override
    public String getDescripcion(){
        return "Se trata de una motocicleta de...";
    }
}
