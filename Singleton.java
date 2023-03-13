/*
    PROPÓSITO: ventajas de la clases estáticas y de las abstractas
    CONSECUENCIAS: 
        -Ventajas: 
            -Acceso controlado a la única instancia (o a al número controlado de instancias)
            -Espacio de nombres reducido
            -Permite el refinamiento de operaciones y la representación
            -Permite un número variable de instancias
            -Más flexibles que las operaciones de clases estáticas
        -Inconvenientes: 
*/

public abstract class FactoriaIntegración {
    private static FactoriaIntegración instancia;
    public static FactoriaIntegracion obtenerInstancia(){
         if (instancia == null) {
                instancia = new FactoriaIntegracionImp();
        }
    return instancia;
    }
    public abstract DAOUsuario generaDAOUsuario();
    public abstract DAOLibro generaDAOLibro();
    public abstract DAOEjemplar generaDAOEjemplar();
    public abstract DAOPrestamo generaDAOPrestamo();
}

public class FactoriaIntegracionImp extends FactoriaIntegracion{
    public DAOUsuario generaDAOUsuario(){ return new DAOUsuarioImp(); }
    public DAOLibro generaDAOLibro(){ return new DAOLibroImp(); }
    public DAOEjemplar generaDAOEjemplar(){ return new DAOEjemplarImp(); }
    public DAOPrestamo generaDAOPrestamo(){ return new DAOPrestamoImp(); }
}