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

    @Override
    public String getDescripcion(){
        return "Se trata de un coche.";
    }


}
