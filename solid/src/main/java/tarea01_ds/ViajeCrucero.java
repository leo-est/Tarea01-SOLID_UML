package tarea01_ds;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ViajeCrucero {
    private String idViaje;
    private String destino;
    private List<String> ruta;
    private LocalDateTime fechaSalida;
    private int duracionDias;
    private String estado;
    private List<Cabina> cabinas; // Composición con Cabina
    private List<Reserva> reservas;

    public ViajeCrucero(String idViaje, String destino, LocalDateTime fechaSalida, int duracionDias) {
        this.idViaje = idViaje;
        this.destino = destino;
        this.ruta = new ArrayList<>();
        this.fechaSalida = fechaSalida;
        this.duracionDias = duracionDias;
        this.estado = "Programado";
        this.cabinas = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    // Métodos ajustados al diagrama actual de Cabina
    public List<Cabina> buscarCabinasDisponibles(String tipo) {
        List<Cabina> disponibles = new ArrayList<>();
        for (Cabina c : cabinas) {
            // Usa el método verificarDisponibilidad() que sí existe en Cabina
            if (c.verificarDisponibilidad()) {
                disponibles.add(c);
            }
        }
        return disponibles;
    }

    public void cancelarViaje(String motivo) {
        this.estado = "Cancelado";
        System.out.println("Viaje " + idViaje + " cancelado. Motivo: " + motivo);
    }

    public void deshabilitarVentaCabinas() {
        for (Cabina c : cabinas) {
            // Usa el método cambiarEstado() que sí existe en Cabina
            c.cambiarEstado("No disponible");
        }
        System.out.println("Venta de cabinas deshabilitada para el viaje " + idViaje);
    }

    public List<Reserva> obtenerReservasActivas() {
        List<Reserva> reservasActivas = new ArrayList<>();
        for (Reserva reserva : reservas) {
            if (!"Cancelada".equalsIgnoreCase(reserva.getEstado())) {
                reservasActivas.add(reserva);
            }
        }
        return reservasActivas;
    }

    public List<Usuario> obtenerUsuariosAsociados(List<Reserva> reservasAsociadas) {
        Set<Usuario> usuarios = new LinkedHashSet<>();
        for (Reserva reserva : reservasAsociadas) {
            usuarios.add(reserva.getCliente());
        }
        return new ArrayList<>(usuarios);
    }

    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    // Getters y Setters
    public String getIdViaje() { return idViaje; }
    public String getDestino() { return destino; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public List<Cabina> getCabinas() { return cabinas; }
    public void agregarCabina(Cabina cabina) { this.cabinas.add(cabina); }
}