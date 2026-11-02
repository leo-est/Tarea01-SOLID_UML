package tarea01_ds;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ServicioNotificaciones notificaciones =
                new ServicioNotificaciones(List.of(new NotificadorEmail()));
        PaymentGatewayAdapter pasarela = new PaymentGatewayAdapter("Demo");

        ViajeCrucero viaje = new ViajeCrucero(
                "VIAJE-001",
                "Caribe",
                LocalDateTime.now().plusDays(30),
                7
        );
        Cabina cabina = new CabinaInterior("CAB-001", "101", 850.0);
        viaje.agregarCabina(cabina);

        Cliente cliente = new Cliente(
                "CLI-001",
                "Ana Pérez",
                "ana@example.com",
                "555-0101",
                0
        );

        GestorReservas gestorReservas = new GestorReservas(pasarela, notificaciones);
        Reserva reserva = gestorReservas.iniciarReserva(cliente, viaje, cabina);

        if (gestorReservas.confirmarPagoReserva(reserva, "datos-de-prueba")) {
            GestorCancelacionViaje gestorCancelacion =
                    new GestorCancelacionViaje(pasarela, notificaciones);
            gestorCancelacion.cancelarViajeYReembolsar(viaje, "Demostración del flujo");
        }
    }
}
