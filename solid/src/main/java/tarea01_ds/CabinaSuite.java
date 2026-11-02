package tarea01_ds;

public class CabinaSuite extends Cabina {
    private double recargoLujo = 300.0;

    public CabinaSuite(String idCabina, String numero, double precioBase) {
        super(idCabina, numero, precioBase);
    }

    @Override
    public double calcularTarifa() {
        return precioBase + recargoLujo;
    }

    @Override
    public String obtenerCondicionesEspecificas() {
        return "Incluye servicio de mayordomo 24/7 y acceso exclusivo a terraza VIP.";
    }
}