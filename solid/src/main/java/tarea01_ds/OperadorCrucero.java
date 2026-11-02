package tarea01_ds;

public class OperadorCrucero extends Usuario{

    private String idOperador;
    private String rolAdministrativo;

    public OperadorCrucero(String idUsuario, String nombre, String email, String telefono, String idOperador, String rolAdministrativo) {
        super(idUsuario, nombre, email, telefono);
        this.idOperador = idOperador;
        this.rolAdministrativo = rolAdministrativo;
    }

   public void configurarPolitica(ViajeCrucero viaje, PoliticaReserva politica) {
        System.out.println("Configurando política de reserva para el viaje: " + viaje.getIdViaje());
    }

    public void definirCondicionesCabina(Cabina cabina, String condiciones) {
        System.out.println("Definiendo condiciones especiales para la cabina " + cabina.getNumero() + ": " + condiciones);
    }

    public void ejecutarCancelacionViaje(GestorCancelacionViaje gestor, ViajeCrucero viaje) {
        System.out.println("El operador " + nombre + " está ejecutando la cancelación del viaje " + viaje.getIdViaje());
        gestor.cancelarViajeYReembolsar(viaje, "Cancelación administrativa autorizada por operador.");
    }

    // Getters y Setters
    public String getIdOperador() { 
        return idOperador; 
    }
    
    public void setIdOperador(String idOperador) { 
        this.idOperador = idOperador; 
    }

    public String getRolAdministrativo() { 
        return rolAdministrativo; 
    }
    
    public void setRolAdministrativo(String rolAdministrativo) { 
        this.rolAdministrativo = rolAdministrativo; 
    }
}
