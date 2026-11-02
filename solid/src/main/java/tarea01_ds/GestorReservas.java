package tarea01_ds;

public class GestorReservas {
    private int tiempoBloqueoMinutos = 10;
    private IProcesadorPago procesadorPago;
    private ServicioNotificaciones servicioNotificaciones;

    public GestorReservas(IProcesadorPago procesadorPago, ServicioNotificaciones servicioNotificaciones) {
        this.procesadorPago = procesadorPago;
        this.servicioNotificaciones = servicioNotificaciones;
    }

    public Reserva iniciarReserva(Usuario usuario, ViajeCrucero viaje, Cabina cabina) {
        System.out.println("Revisando disponibilidad de la cabina.");
        
        if (cabina.verificarDisponibilidad()) {
            cabina.bloquearTemporalmente(tiempoBloqueoMinutos);
            System.out.println("Cabina bloqueada por " + tiempoBloqueoMinutos + " minutos.");
            
            Reserva nuevaReserva = new Reserva();
            return nuevaReserva;
        }
        
        throw new RuntimeException("La cabina seleccionada no se encuentra disponible.");
    }

    public boolean confirmarPagoReserva(Reserva reserva, String datosPago) {
        System.out.println("Calculando el valor total de la reserva.");
        
        double montoTotal = reserva.calcularMontoTotal();
        
        System.out.println("Enviando cobro por $" + montoTotal + " al procesador de pagos");
        
        boolean pagoExitoso = procesadorPago.procesarCobro(montoTotal, datosPago);
        
        if (pagoExitoso) {
            System.out.println("Pago confirmado.");
            reserva.confirmarReserva();
        } else {
            System.out.println("El pago fue rechazado.");
        }
        
        return pagoExitoso;
    }

    public boolean modificarReserva(Reserva reserva, Cabina nuevaCabina, String datosPago) {
        System.out.println("Calculando tarifa para la modificación.");
        
        double diferencia = reserva.aplicarModificacion(nuevaCabina);
        
        if (diferencia > 0) {
            System.out.println("Requiere pago adicional de: $" + diferencia);
            return procesadorPago.procesarCobro(diferencia, datosPago);
        }
        
        return true;
    }

    public void verificarYExpirarBloqueos() {
        System.out.println("Revisando bloqueos de cabinas expirados.");
    }

    public void expirarReserva(Reserva reserva, Cabina cabina) {
        System.out.println("El tiempo de reserva expiró.");
        reserva.marcarComoCancelada(); 
        cabina.liberarCabina(); 
        System.out.println("Cabina liberada. Intente de nuevo.");
    }
}
