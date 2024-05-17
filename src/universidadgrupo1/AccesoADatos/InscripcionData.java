
package universidadgrupo1.AccesoADatos;
import java.sql.*;


public class InscripcionData {
    
   private Connection c = null; 

    public InscripcionData() {
        c = Conexion.getConexion();
    }
    
    
}
