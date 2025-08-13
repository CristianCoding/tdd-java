public class Furgoneta implements Alquilable{
    private int plazas; private int precioBasePorDia; private int pesoMaximoEnToneladas;
    private boolean alquilado;

    public Furgoneta(int plazas, int pesoMaximoEnToneladas) {
        this.plazas=plazas;this.precioBasePorDia=500;
        this.pesoMaximoEnToneladas=pesoMaximoEnToneladas;
        this.alquilado=false;
    }
    public double calcularPrecioAlquiler(int dias) {

        return this.precioBasePorDia*dias +(300*this.pesoMaximoEnToneladas);
    }


}
