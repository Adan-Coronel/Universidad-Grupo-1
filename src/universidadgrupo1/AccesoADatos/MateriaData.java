/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package universidadgrupo1.AccesoADatos;
import java.sql.*;
import javax.swing.JOptionPane;
import universidadgrupo1.entidades.Materia;

/**
CREATE TABLE `materia` (
  `idMateria` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `año` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL
) 
 */
public class MateriaData {
    
    private Connection c = null;

    public MateriaData() {
        c= Conexion.getConexion();
    }
    
        public void guardarMateria(Materia materia) {
            
        String sql = ("INSERT INTO `materia`(`nombre`, `año`, `estado`) VALUES (?,?,?)");
        
        try {
            PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnio());
            ps.setBoolean(3, materia.isEstado());

            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                materia.setIdMateria(rs.getInt(1));
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error SQL." + e);

        }

    }
    
    
    
}
