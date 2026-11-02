package tarea01_ds;

public abstract class Cabina {

    protected String idCabina;
    protected String numero;
    protected double precioBase;
    protected String estado; 

    public Cabina(String idCabina, String numero, double precioBase) {
        this.idCabina = idCabina;
        this.numero = numero;
        this.precioBase = precioBase;
        this.estado = "Disponible";
    }

    
    public boolean verificarDisponibilidad() {
        return "Disponible".equalsIgnoreCase(this.estado);
    }

    public boolean bloquearTemporalmente(int minutos) {
        if (verificarDisponibilidad()) {
            this.estado = "Bloqueado";
            System.out.println("Cabina " + numero + " bloqueada temporalmente por " + minutos + " minutos.");
            return true;
        }
        return false;
    }

    public void liberarCabina() {
        this.estado = "Disponible";
        System.out.println("Cabina " + numero + " liberada.");
    }

    public void cambiarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
        System.out.println("Estado de la cabina " + numero + " cambiado a: " + nuevoEstado);
    }

    
    public abstract double calcularTarifa();
    
    public abstract String obtenerCondicionesEspecificas();

    
    public String getIdCabina() { return idCabina; }

    public String getNumero() { return numero; }

    public double getPrecioBase() { return precioBase; }

    public String getEstado() { return estado; }
    
}
    

