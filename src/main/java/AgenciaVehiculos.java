import java.util.HashMap;


public class AgenciaVehiculos {
    private final String nombre;
    private final HashMap <String, Alquilable> vehiculosRegistrados;
    private final HashMap<Integer, Cliente> clientes;
    private int idClientes;private double ganancia;
    public AgenciaVehiculos(String nombre) {
        this.nombre=nombre;
        this.vehiculosRegistrados = new HashMap<>() ;
        this.clientes = new HashMap<>();
        this.idClientes=1;this.ganancia=0;
    }
    public String obtenerNombre() {
        return this.nombre;
    }
    public void registrarVehiculo(String patente, Alquilable vehiculo)
    {
        if (vehiculoYaRegistrado(patente)) {
            throw AgenciaVehiculosError.vehiculoYaRegistrado(patente);
        }
        vehiculosRegistrados.put(patente, vehiculo);
    }
    public Boolean vehiculoYaRegistrado(String patente) {
        return vehiculosRegistrados.containsKey(patente);
    }
    public double calcularPrecioVehiculo(String patente, int dias) {
        AgenciaVehiculosError.elAlquilerDebeSerMinimoUnDia(dias);
        Alquilable vehiculo =vehiculosRegistrados.get(patente);
        return vehiculo.calcularPrecioAlquiler(dias);
    }
    public int registrarCliente(Cliente cliente){
        clientes.put(idClientes,cliente);
        return idClientes++;
    }

    public Boolean clienteYaRegistrado(int idCliente){
        return clientes.containsKey(idCliente);
    }
    public void registrarAlquiler(int idCliente, String patente, int dias){
        Cliente cliente = clienteRegistrado(idCliente);
        Alquilable vehiculo = vehiculosRegistrados.get(patente);
       /* if (vehiculo.libre()) {
            cliente.rentarVehiculo(vehiculo);
            this.ganancia += calcularPrecioVehiculo(patente,dias);
        }*/
    }
    private Cliente clienteRegistrado(int idCliente){
        if (!clientes.containsKey(idCliente)) {
            throw AgenciaVehiculosError.clienteNoRegistrado();
        }
        return clientes.get(idCliente);

    }
    private Alquilable vehiculoRegistrado(String patente){
        if (!vehiculosRegistrados.containsKey(patente)) {
            throw AgenciaVehiculosError.vehiculoNoRegistrado(patente);
        }
        return vehiculosRegistrados.get(patente);
    }
}
