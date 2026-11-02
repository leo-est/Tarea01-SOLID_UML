package tarea01_ds;

public class GerenciaCrucero implements IManejadorIncidente {
    private String idGerencia;
    private String responsable;
    private IManejadorIncidente siguienteNivel;

    public GerenciaCrucero(String idGerencia, String responsable) {
        this.idGerencia = idGerencia;
        this.responsable = responsable;
    }

    @Override
    public void establecerSiguiente(IManejadorIncidente siguiente) {
        this.siguienteNivel = siguiente; // Normalmente la gerencia es el último nivel
    }

    @Override
    public boolean atenderIncidente(Incidente incidente) {
        System.out.println("Gerencia (" + responsable + ") atendiendo el incidente escalado.");
        
        incidente.registrarResolucion("Solución definitiva.");
        incidente.resolver();
        System.out.println("Incidente resuelto.");
        
        return true;
    }
}