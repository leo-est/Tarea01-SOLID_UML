package tarea01_ds;

public class PaqueteBebidas implements IServicioAdicional {
    private double costo = 150.0;

    @Override
    public String obtenerNombre() { return "Paquete de Bebidas All-Inclusive"; }

    @Override
    public double calcularCosto() { return costo; }

    @Override
    public String obtenerDescripcion() { return "Consumo ilimitado de bebidas seleccionadas a bordo."; }
}
