public class Microbus implements Alquilable{

    private int plazas;
    private int precioBasePorDia;
    private int precioFijo;
    private boolean alquilado;

    public Microbus(int plazas){

        this.plazas=plazas;this.precioFijo=500;
        this.precioBasePorDia=1500;this.alquilado=false;
    }
    @Override
    public double calcularPrecioAlquiler(int dias) {

        return (this.precioBasePorDia * dias)+this.precioFijo;
    }

}
