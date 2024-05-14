
package universidadgrupo1;

import java.sql.Connection;
import java.sql.SQLException;
import universidadgrupo1.AccesoADatos.Conexion;


public class UniversidadGrupo1 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
       
        Connection con=Conexion.getConexion();
        
    }
    
}
