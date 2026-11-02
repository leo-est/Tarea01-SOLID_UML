package tarea01_ds;

public class Cliente extends Usuario{

    private int puntosFidelidad;

    public Cliente(String idUsuario, String nombre, String email, String telefono, int puntosFidelidad){
        super(idUsuario, nombre, email, telefono);
        this.puntosFidelidad= puntosFidelidad;
    }

    public String ObtenerDetalesCliente(){
        return "Cliente: " + nombre + "Puntos de Fidelidad: " + puntosFidelidad;

    }

    public int getPuntosFidelidad(){
        return puntosFidelidad;
    }

    public void setPuntosFidelidad(int puntosFidelidad){
        this.puntosFidelidad= puntosFidelidad;

    }


    
}
