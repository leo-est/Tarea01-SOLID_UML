package tarea01_ds;

public class CabinaInterior extends Cabina {
    public CabinaInterior(String idCabina, String numero, double precioBase) {
        super(idCabina, numero, precioBase);
    }

    @Override
    public double calcularTarifa() {
        return precioBase; // Sin recargos adicionales
    }

    @Override
    public String obtenerCondicionesEspecificas() {
        return "Cabina interior estándar sin ventana, ideal para descanso económico.";
    }
}