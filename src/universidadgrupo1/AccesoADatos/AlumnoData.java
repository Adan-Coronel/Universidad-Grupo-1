
package universidadgrupo1.AccesoADatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Statement;
import universidadgrupo1.entidades.Alumno;


public class AlumnoData {
    //este objeto connection lo van a usar todas las clases data
    private Connection c = null;

    public AlumnoData() {
        c= Conexion.getConexion();
    }
    
    public void guardarAlumno(Alumno alumno){
        String sql = ("INSERT INTO `alumno`(`dni`, `apellido`, `nombre`, "
                    + "`fechaNacimiento`, `estado`) VALUES (?,?,?,?,?)");
        try{
            PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, alumno.getIdAlumno());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));
            ps.setBoolean(5, alumno.isEstado());
            
            ps.executeUpdate();
            ps.close();
            ResultSet rs= ps.getGeneratedKeys();
        
            if(rs.next()){
            
                alumno.setIdAlumno(rs.getInt(1));
                
            }
            
            
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error SQL. No se pudo insertar en tabla alumno"+e);
        
        }
                
    
    
    }
    public void borrarAlumno(int id){
        String sql = "DELETE FROM 'alumno' WHERE id = ?";
        
        try{
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            int validation = ps.executeUpdate();
            
            if (validation == 1) {
                JOptionPane.showMessageDialog(null, "Se elimino ese alumno!");
            }else{
                JOptionPane.showMessageDialog(null, "Ese alumno no existe pa");
            }
            
            ps.close();
            
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null, "Error SQL."+e);
    }
    
//    public void buscarAlumno(){
//        
//    }
//    
//    public void actualizarAlumno(){
//        
//    }
//    public void listarAlumno(){
//        
//    }
    
}
