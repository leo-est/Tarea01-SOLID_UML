package tarea01_ds;

public class CabinaFamiliar extends Cabina {
    private double recargoEspacio = 180.0;

    public CabinaFamiliar(String idCabina, String numero, double precioBase) {
        super(idCabina, numero, precioBase);
    }

    @Override
    public double calcularTarifa() {
        return precioBase + recargoEspacio;
    }

    @Override
    public String obtenerCondicionesEspecificas() {
        return "Espacio amplio con camas adicionales y cercanía a zonas infantiles.";
    }
}