
package universidadgrupo1.AccesoADatos;

import java.sql.*;
import javax.swing.JOptionPane;
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
    
    
    }
    
    public Alumno buscarAlumno(int id){
        
        Alumno alumno = null;
        
        String sql = "SELECT * FROM alumno WHERE id = ? AND estado = true";
        
        try{
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                alumno = new Alumno();
                alumno.setIdAlumno(id);
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(true);
            }else{
                JOptionPane.showMessageDialog(null, "No existe ese alumno :(");
            }
            ps.close();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error SQL."+e);
        }
        
        return alumno;
        //un saludo para el profe que mira los comentarios ;)
    }
    
        public Alumno buscarAlumnoPorDni(int dni){
        
        String sql = "SELECT idAlumno, dni, apellido, nombre, fechaNacimiento FROM alumno WHERE dni = ? AND estado = true";
        Alumno alumno = null;

        try{
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(true);
            }else{
                JOptionPane.showMessageDialog(null, "No existe ese alumno :(");
            }
            ps.close();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error SQL."+e);
        }
        
        return alumno;
    }
    
    public void actualizarAlumno(Alumno alumno){
    
        String sql = "UPDATE alumno SET apellido = ? nombre = ? fechaNacimiento = ? estado = ? ";
        
            try{
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(2, alumno.getNombre());
            ps.setString(3, alumno.getApellido());
            ps.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));
            ps.close();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error SQL."+e);
        }
        
    }
    
}
