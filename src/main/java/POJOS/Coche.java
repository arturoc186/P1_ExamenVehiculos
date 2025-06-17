package POJOS;

public class Coche extends Vehiculo{

    public int numPuertas;
    public String tipoCombustible;

    public Coche(int id, String marca, String modelo, float precio) {
        super(id, marca, modelo, precio);
    }

    public Coche(int id, String marca, String modelo, float precio, int numPuertas, String tipoCombustible) {
        super(id, marca, modelo, precio);
        this.numPuertas = numPuertas;
        this.tipoCombustible = tipoCombustible;
    }

    public Coche() {
        super();
    }

    public int getNumPuertas() {
        return numPuertas;
    }

    public void setNumPuertas(int numPuertas) {
        this.numPuertas = numPuertas;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    @Override
    public String getDescripcion(){
        return "Se trata de un coche de la marca " +getMarca() + "con " +getNumPuertas() + "puertas.";
    }


}
