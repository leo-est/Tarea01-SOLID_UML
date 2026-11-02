package tarea01_ds;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class PoliticaReserva {
    private String idPolitica;
    private int horasLimiteModificacion;
    private double porcentajeReembolso;

    public PoliticaReserva(String idPolitica, int horasLimiteModificacion, double porcentajeReembolso) {
        this.idPolitica = idPolitica;
        this.horasLimiteModificacion = horasLimiteModificacion;
        this.porcentajeReembolso = porcentajeReembolso;
    }

    public boolean validarTiempoLimite(LocalDateTime fechaZarpe) {
        LocalDateTime ahora = LocalDateTime.now();
        long horasRestantes = ChronoUnit.HOURS.between(ahora, fechaZarpe);
        return horasRestantes >= horasLimiteModificacion;
    }

    public double calcularReembolso(double montoTotal) {
        return montoTotal * (porcentajeReembolso / 100.0);
    }
}
