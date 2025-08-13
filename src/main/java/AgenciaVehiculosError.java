public class AgenciaVehiculosError extends RuntimeException {
    public AgenciaVehiculosError(String message) {
        super(message);
    }

    public static AgenciaVehiculosError vehiculoYaRegistrado(String patente) {
        return new AgenciaVehiculosError("El vehículo con patente " + patente + " ya está registrado.");
    }

    public static void elAlquilerDebeSerMinimoUnDia(int dias) {
        if (dias < 1){throw new
                AgenciaVehiculosError("El alquiler de un vehiculo debe ser igual o superior a un dia.");}

    }
    public static AgenciaVehiculosError clienteNoRegistrado(){
        return new AgenciaVehiculosError("El cliente no está registrado.");
    }
    public static AgenciaVehiculosError vehiculoNoRegistrado(String patente){
        return new AgenciaVehiculosError("El vehiculo "+patente+ " no está registrado.");
    }
}