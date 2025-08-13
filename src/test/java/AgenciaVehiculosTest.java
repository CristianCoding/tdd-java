import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AgenciaVehiculosTest {

    private AgenciaVehiculos agencia;
    private String nombre;

    @BeforeEach
    public void setUp() {
        nombre = "VehiculosAlquileres";
        agencia = new AgenciaVehiculos("VehiculosAlquileres");
    }
    @Test
    public void agenciaTieneNombre(){

        assertEquals(nombre, agencia.obtenerNombre());
    }

    @Test
    public void agenciaPuedeRegistrarVehiculo (){
        String idVehiculo = "1";
        Alquilable coche = new Coche(5, true);
        agencia.registrarVehiculo(idVehiculo, coche);

        assert(agencia.vehiculoYaRegistrado(idVehiculo));
    }
    @Test
    public void agenciaNoPuedeRegistrarMismoVehiculo(){

        String patente = "1";
        Alquilable vehiculo=new Coche(5, true);
        agencia.registrarVehiculo(patente, vehiculo);

        assertThrows(AgenciaVehiculosError.class, () -> agencia.registrarVehiculo(patente, vehiculo));
    }

    @Test
    public void agenciaPuedeCalcularPrecioAlquilerDeCoche(){
        String patente = "1";
        Alquilable vehiculo=new Coche(5, true);
        agencia.registrarVehiculo(patente, vehiculo);

        double precio=agencia.calcularPrecioVehiculo(patente, 10);
        double precioEsperado=(500*10)+(5*150);

        assertEquals(precioEsperado, precio);
    }

    @Test
    public void agenciaPuedeCalcularPrecioAlquilerDeMicrobus(){
        String patente = "1";
        Alquilable vehiculo=new Microbus(20);
        agencia.registrarVehiculo(patente, vehiculo);

        double precio=agencia.calcularPrecioVehiculo(patente, 10);
        double precioEsperado=(1500 * 10)+500;

        assertEquals(precioEsperado, precio);
    }

    @Test
    public void agenciaPuedeCalcularPrecioAlquilerDeVehiculoDeCarga(){
    String patente = "1";
    Alquilable vehiculo=new Furgoneta(20, 5);
    agencia.registrarVehiculo(patente, vehiculo);

    double precio=agencia.calcularPrecioVehiculo(patente, 10);
    double precioEsperado=(500 * 10)+(300*5);

    assertEquals(precioEsperado, precio);
}

    @Test
    public void agenciaNoPuedeCalcularPrecioDeUnDiaDeAlquiler(){
    String patente = "1";
    Alquilable vehiculo=new Microbus(20);
    agencia.registrarVehiculo(patente, vehiculo);

    assertThrows(AgenciaVehiculosError.class,
            () -> {agencia.calcularPrecioVehiculo(patente, 0);});
    }

    @Test
    public void agenciaPuedeRegistrarCliente(){

        int idCliente = agencia.registrarCliente(new Cliente("Cristian Alarcon"));
        assert (agencia.clienteYaRegistrado(idCliente));

    }


    /*
     public void agenciaPuedeRentarACliente(){
         int idCliente;String patente;
         agencia.registrarVehiculo("123", new Furgoneta(20, 5));
         agencia.registrarVehiculo("456", new Coche(5, true));
         agencia.registrarVehiculo("789", new Microbus(20));

         idCliente=agencia.registrarCliente(new Cliente("Cristian"));

         agencia.registrarAlquiler(idCliente, "456", 10);

         assert (agencia.vehiculoRentadoACliente(idCliente));

     }
    */

}

