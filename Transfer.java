/*
    PROPÓSITO: independizar el intercambio de datos entre capas
    CONSECUENCIAS: 
        -Ventaja: ayuda a independizar capas
        -Inconveniente: aumenta significativamente el nº de objectos del sistema
*/
public TUsuario implements Serializable {
    protected int id;
    protected String nombre, eMail;
    protected boolean activo;

    public TUsuario(String nombre, String eMail){
        this.id = 0;
        this.nombre = nombre;
        this.eMail = eMail;
        this.activo = true;
    }
    public TUsuario(int id, String nombre, String eMail, boolean activo){
        this.id = id;
        this.nombre = nombre;
        this.eMail = eMail;
        this.activo = activo;
    }
    public int getId(){return this.id;}
    public String getNombre(){return this.nombre;}
    public String getEMail(){return this.eMail;}
    public boolean getActivo(){return this.activo;}
    public void setId(int id){this.id = id;}
    public void setNombre(String nombre){this.nombre = nombre;}
    public void setEMail(String eMail){this.eMail = eMail;}
    public void setActivo(boolean activo){this.activo = activo;}
}

public DAOUsuarioImp implements DAOUsuario {
    public TUsuario read(int id){
        //código de acceso a la BD
        TUsuario usuario = new TUsuario(id, nombre, eMail, activo);
        return usuario;
    }
    //............
}