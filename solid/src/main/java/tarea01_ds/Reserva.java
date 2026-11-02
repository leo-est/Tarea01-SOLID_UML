package tarea01_ds;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Reserva {
    private String idReserva;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaExpiracionBloqueo;
    private double montoTotal;
    private String estado;
    
    // Relaciones del diagrama
    private Cliente cliente;
    private ViajeCrucero viajeCrucero;
    private Cabina cabina;
    private List<IServicioAdicional> serviciosAdicionales; // Relación 0..* del diagrama

    public Reserva(String idReserva, Cliente cliente, ViajeCrucero viajeCrucero, Cabina cabina) {
        this.idReserva = idReserva;
        this.fechaCreacion = LocalDateTime.now();
        this.fechaExpiracionBloqueo = LocalDateTime.now().plusHours(24);
        this.cliente = cliente;
        this.viajeCrucero = viajeCrucero;
        this.cabina = cabina;
        this.estado = "Pendiente";
        this.serviciosAdicionales = new ArrayList<>();
        this.montoTotal = calcularMontoTotal();
    }

    // Método exacto según el diagrama
    public void agregarServicioAdicional(IServicioAdicional servicio) {
        this.serviciosAdicionales.add(servicio);
        this.montoTotal = calcularMontoTotal(); // Actualiza el monto al sumar servicios
        System.out.println("Servicio adicional agregado a la reserva: " + servicio.obtenerNombre());
    }

    public double calcularMontoTotal() {
        double total = (cabina != null) ? cabina.calcularTarifa() : 0.0;
        for (IServicioAdicional servicio : serviciosAdicionales) {
            total += servicio.calcularCosto();
        }
        return total;
    }

    public void confirmarReserva() {
        this.estado = "Confirmada";
        System.out.println("Reserva " + idReserva + " confirmada exitosamente.");
    }

    public double aplicarModificacion(Cabina nuevaCabina) {
        this.cabina = nuevaCabina;
        this.montoTotal = calcularMontoTotal();
        return this.montoTotal;
    }

    public void marcarComoCancelada() {
        this.estado = "Cancelada";
        System.out.println("Reserva " + idReserva + " marcada como cancelada.");
    }

    // Getters necesarios
    public String getIdReserva() { return idReserva; }
    public double getMontoTotal() { return montoTotal; }
    public String getEstado() { return estado; }
    public List<IServicioAdicional> getServiciosAdicionales() { return serviciosAdicionales; }
}