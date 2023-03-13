/*
    PROPÓSITO: centralizar la lógica del negocio
    CONSECUENCIAS: 
        -Ventajas: 
            -Centraliza la lógica del negocio
            -Mejora la reusabilidad del cógico
            -Evita la duplicación de código
            -Simplifica la implementación de fachadas
        -Inconvenientes: 
            -Introduce un nivel más de indirección
*/

public interface SAUsuario {
    public int create(TUsuario tUsuario);
    public TUsuario read(int id);
    public Collection<TUsuario> readAll();
    public int update(TUsuario TUsuario);
    public int delete(int id);
}

public class SAUsuarioImp implements SAUsuario {
    public int create(TUsuario tUsuario){
        int id = -1;
        DAOUsuario daoUsuario;
        if (tUsuario != null){
            // acceso a la implementación del DAO
            TUsuario leido = daoUsuario.readByName(tUsuario.getNombre());
            if (leido == null){
                id = daoUsuario.create(tUsuario);
            }
        }
        return id;
    }
    //...
}