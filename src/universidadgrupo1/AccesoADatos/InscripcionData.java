
package universidadgrupo1.AccesoADatos;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    public void actualizarNota(int idAlumno, int idMateria, double nota){
    
        String sql = "UPDATE inscripcion SET nota = ? WHERE idAlumno = ? AND idMateria = ?";
        
        try {
           PreparedStatement ps = c.prepareStatement(sql);
           
           ps.setDouble(1, nota);
           ps.setInt(2,idAlumno);
           ps.setInt(3,idMateria);
           
           int validation = ps.executeUpdate();
           if(validation == 1){
                JOptionPane.showMessageDialog(null, "La nota fue actualizada!");
            }
            ps.close();

           
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "error, no se pudo acceder a la tabla, no se pudo cambiar la nota");
       } 
    }
      
    
    
    public void borrarInscripcionIDAlumnoIDMateria(int idAlumno, int idMateria){
       try {
           //TAMBIEN SE PUEDE BORRAR LA INSCRIPCION CON EL ID DE LA INSCRIPCION
           //de esta forma tambien se puede hacer ya que un alumno no se puede anotar 2 veces a la misma materia
           
           String sql = "DELETE FROM inscripcion WHERE idAlumno = ? AND idMateria = ?";
           PreparedStatement ps = c.prepareStatement(sql);
           ps.setInt(1, idAlumno);
           ps.setInt(2, idMateria);
           
           int validation = ps.executeUpdate();
           
           if(validation == 1){
                JOptionPane.showMessageDialog(null, "Se borro esa inscipcion!");
            }
            ps.close();
           
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "error, no se pudo acceder a la tabla, no se pudo borrar la inscripcion");
       }
    
    }
    
}
    
    
    
    

