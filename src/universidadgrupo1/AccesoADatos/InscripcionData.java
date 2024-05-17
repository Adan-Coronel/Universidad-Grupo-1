
package universidadgrupo1.AccesoADatos;
import java.sql.*;
import javax.swing.JOptionPane;
import universidadgrupo1.entidades.Inscripcion;

//CREATE TABLE `inscripcion` (
//  `idInscripto` int(11) NOT NULL,
//  `nota` int(11) NOT NULL,
//  `idAlumno` int(11) NOT NULL,
//  `idMateria` int(11) NOT NULL
//)

public class InscripcionData {
    
   private Connection c = null; 

    public InscripcionData() {
        c = Conexion.getConexion();
    }
    
    public void guardarInscipcion(Inscripcion ins){
        
        String sql = "INSERT INTO inscripcion (nota, idAlumno, idMateria) VALUES (?,?,?)";
        
       try {
           PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
           
           ps.setDouble(1, ins.getNota());
           // la clase inscripcion tiene como atributos a un alumno y una materia, por lo tanto para setear el id al ps, tengo que hacer el get de alumno y de ahi hacer el get del id, lo mismo con inscripcion 
           ps.setInt(2, ins.getAlumno().getIdAlumno());
           ps.setInt(3, ins.getMateria().getIdMateria());
           
           ps.executeUpdate();
           ResultSet rs = ps.getGeneratedKeys();
           
           if(rs.next()){
           
               ins.setIdInscripcion(rs.getInt(1));
               JOptionPane.showMessageDialog(null, "inscripcion realizada, a estudiar viejo");
           }
           
           ps.close();
           
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "error, no se pudo acceder a la tabla inscripcion");
       }
        
        
    }
    
    
}
