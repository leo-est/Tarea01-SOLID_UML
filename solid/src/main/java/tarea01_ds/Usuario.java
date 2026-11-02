package tarea01_ds;

public abstract class Usuario {

    protected String idUsuario;
    protected String nombre;
    protected String email;
    protected String telefono;

    public Usuario(String idUsuario, String nombre, String email, String telefono){
        this.idUsuario= idUsuario;
        this.nombre= nombre;
        this.email= email;
        this.telefono= telefono;
    }

    
    public String getIdUsuario(){
        return idUsuario;
    }
    
    public void setIdUsuario(String idUsuario){
        this.idUsuario= idUsuario;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre= nombre;
    }

    public String ObtenerEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email=email;
    }

    public String ObtenerTelefono(){
        return telefono;
    }

    public void setTelefono(String telefono){
        this.telefono=telefono;

    }
    
}

