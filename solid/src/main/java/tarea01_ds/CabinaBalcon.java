package tarea01_ds;

public class CabinaBalcon extends Cabina {
    private double recargoVista = 120.0;

    public CabinaBalcon(String idCabina, String numero, double precioBase) {
        super(idCabina, numero, precioBase);
    }

    @Override
    public double calcularTarifa() {
        return precioBase + recargoVista;
    }

    @Override
    public String obtenerCondicionesEspecificas() {
        return "Incluye balcón privado amueblado con vista directa al mar.";
    }
}