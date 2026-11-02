package tarea01_ds;

public class TratamientoSpa implements IServicioAdicional {
    private double costo = 90.0;

    @Override
    public String obtenerNombre() { return "Sesión de Spa Relajante"; }

    @Override
    public double calcularCosto() { return costo; }

    @Override
    public String obtenerDescripcion() { return "Masaje completo de 1 hora en el spa del crucero."; }
}
