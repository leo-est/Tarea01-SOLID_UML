package tarea01_ds;

public class Incidente {
    private String idIncidente;
    private String categoria;
    private String descripcionProblema;
    private EstadoIncidente estado;
    private String resolucion;

    public Incidente(String idIncidente, String categoria, String descripcionProblema) {
        this.idIncidente = idIncidente;
        this.categoria = categoria;
        this.descripcionProblema = descripcionProblema;
        this.estado = EstadoIncidente.ABIERTO; // Por defecto al crearse
        this.resolucion = "";
    }

    public void registrarResolucion(String detalle) {
        this.resolucion = detalle;
    }

    public void resolver() {
        this.estado = EstadoIncidente.RESUELTO;
    }
    // Getters
    public String getCategoria() { return categoria; }
    public EstadoIncidente getEstado() { return estado; }
    public String getResolucion() { return resolucion; }
}