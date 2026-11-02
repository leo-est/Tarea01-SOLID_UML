package tarea01_ds;

public class ExcursionTierra implements IServicioAdicional {
    private String nombre;
    private double costo;

    public ExcursionTierra(String nombre, double costo) {
        this.nombre = nombre;
        this.costo = costo;
    }

    @Override
    public String obtenerNombre() { return nombre; }

    @Override
    public double calcularCosto() { return costo; }

    @Override
    public String obtenerDescripcion() { return "Excursión guiada en puerto de parada."; }
}