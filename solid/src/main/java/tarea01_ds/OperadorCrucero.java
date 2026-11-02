package tarea01_ds;

public class OperadorCrucero {
    private String idOperador;
    private String nombreAdministrador;

    public OperadorCrucero(String idOperador, String nombreAdministrador) {
        this.idOperador = idOperador;
        this.nombreAdministrador = nombreAdministrador;
    }

    // Retorna una política configurada para que el resto del sistema la use
    public PoliticaReserva configurarPoliticas(String idPolitica, int horasLimite, double reembolso) {
        System.out.println("Operador " + nombreAdministrador + " estableciendo nuevas políticas.");
        return new PoliticaReserva(idPolitica, horasLimite, reembolso);
    }
    
    // Aquí irían otros métodos
}