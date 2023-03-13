/*
    PROPÓSITO: permite acceder a la capa de datos proporcionando representaciones OO(p.e. objectos transfer) a sus clientes
    CONSECUENCIAS: 
        -Ventajas: 
            -Independiza el tratamiento de los datos de su acceso y estructura
            -Permite independizar la capa de negocio de la de datos
        -Inconvenientes: 
            -Aumenta el número de objetos del sistema
*/

public interface DAOUsuario {
    public int create(TUsuario tUsuario);
    public TUsuario read(int id);
    public Collection<TUsuario> readAll();
    public TUsuario readByName(String nombre);
    public int update(TUsuario tUsuario);
    public int delete(int id);
}

public class DAOUsuarioImp implements DAOUsuario {
    //...
    public int create(TUsuario tUsuario){
        int id = -1;
        // conexión con la BD
        PreparedStatement ps = conexion.prepareStatement("INSERT INTO usuario (nombre, eMail, activo) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, tUsuario.getNombre());
        ps.setString(2, tUsuario.getEMail());
        ps.setBoolean(3, tUsuario.getActivo());
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()){
            id = rs.getInt(1);
        }
        // cerrar conexión y tratar excepciones

        return id;
    }
    //...
}