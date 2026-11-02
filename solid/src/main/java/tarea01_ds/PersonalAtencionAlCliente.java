package tarea01_ds;

public class PersonalAtencionAlCliente implements IManejadorIncidente {
    private String idAgente;
    private String nombreAgente;
    private IManejadorIncidente siguienteNivel;

    public PersonalAtencionAlCliente(String idAgente, String nombreAgente) {
        this.idAgente = idAgente;
        this.nombreAgente = nombreAgente;
    }

    @Override
    public void establecerSiguiente(IManejadorIncidente siguiente) {
        this.siguienteNivel = siguiente;
    }

    @Override
    public boolean atenderIncidente(Incidente incidente) {
        System.out.println("Personal de atención revisando el incidente: " + incidente.getCategoria());
        
        //El personal solo resuelve dudas simples o problemas menores
        if (incidente.getCategoria().equalsIgnoreCase("Duda General") || 
            incidente.getCategoria().equalsIgnoreCase("Servicio a bordo")) {
            
            incidente.registrarResolucion("Resuelto por el agente " + nombreAgente);
            incidente.resolver();
            System.out.println("Incidente resuelto.");
            return true;
            
        } else if (siguienteNivel != null) {
            // Si es un problema grave, va hacia Incidente escalado
            System.out.println("Incidente demasiado grande, llamando a la agencia");
            return siguienteNivel.atenderIncidente(incidente);
        }
        
        return false;
    }
}