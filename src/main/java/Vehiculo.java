public abstract class Vehiculo implements Alquilable {
    protected boolean alquilado = false;

    public boolean estaAlquilado() {
        return alquilado;
    }

    public void alquilar() {
        alquilado = true;
    }

    public void liberar() {
        alquilado = false;
    }
}
