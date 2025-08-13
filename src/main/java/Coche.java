public class Coche implements Alquilable  {
    private int plazas; private boolean premium;
    private int precioBasePorDia;private boolean alquilado;

    public Coche(int plazas, boolean premium) {

        this.plazas = plazas; this.premium = premium;
        this.precioBasePorDia = 500;this.alquilado=false;
    }

    @Override
    public double calcularPrecioAlquiler(int dias) {
        if (premium) {
            return (this.precioBasePorDia * dias)+(this.plazas*150);
        }
        return (this.precioBasePorDia * dias)+(this.plazas*100);
    }


}
