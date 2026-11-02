package tarea01_ds;

import java.util.List;

public class GestorCancelacionViaje {
    private IProcesadorReembolso procesadorReembolso;
    private ServicioNotificaciones servicioNotificaciones;

    public GestorCancelacionViaje(IProcesadorReembolso procesadorReembolso, ServicioNotificaciones servicioNotificaciones) {
        this.procesadorReembolso = procesadorReembolso;
        this.servicioNotificaciones = servicioNotificaciones;
    }

    public boolean cancelarViajeYReembolsar(ViajeCrucero viaje, String motivo) {
        System.out.println("Proceso de cancelación para el viaje: " + viaje.getDestino());
        System.out.println("Motivo registrado: " + motivo);
        
        viaje.cancelarViaje(motivo);
        viaje.deshabilitarVentaCabinas();

        List<Reserva> reservasAfectadas = viaje.obtenerReservasActivas();
        boolean todosReembolsados = true;

        for (Reserva reserva : reservasAfectadas) {
            double montoDevolucion = reserva.calcularMontoTotal();
            String idReserva = reserva.getIdReserva();

            boolean exito = procesadorReembolso.ejecutarReembolso(idReserva, montoDevolucion);
            
            if (!exito) {
                todosReembolsados = false;
                System.out.println("Error al reembolsar la reserva: " + idReserva);
            }
        }

        if (todosReembolsados) {
            System.out.println("Todos los reembolsos se procesaron correctamente.");
            
            List<Usuario> usuariosAfectados = viaje.obtenerUsuariosAsociados();
            servicioNotificaciones.notificarCancelacionYReembolso(usuariosAfectados, viaje);
        }

        return todosReembolsados;
    }
}
