package tarea01_ds;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ServicioNotificaciones {
    private final List<INotificador> notificadores;

    public ServicioNotificaciones(List<INotificador> notificadores) {
        this.notificadores = new ArrayList<>(Objects.requireNonNull(notificadores, "notificadores"));
    }

    public void notificarCancelacionYReembolso(List<Usuario> usuarios, ViajeCrucero viaje) {
        String asunto = "Cancelación del viaje " + viaje.getIdViaje();
        String contenido = "El viaje a " + viaje.getDestino()
                + " fue cancelado. El reembolso de su reserva fue procesado.";

        for (Usuario usuario : usuarios) {
            for (INotificador notificador : notificadores) {
                notificador.enviarMensaje(usuario, asunto, contenido);
            }
        }
    }
}
