package tarea01_ds;

public interface IManejadorIncidente {
    void establecerSiguiente(IManejadorIncidente siguiente);
    boolean atenderIncidente(Incidente incidente);
}