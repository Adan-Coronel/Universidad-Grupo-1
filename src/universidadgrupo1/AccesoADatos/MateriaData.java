/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package universidadgrupo1.AccesoADatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import universidadgrupo1.entidades.Materia;

/**
 * CREATE TABLE `materia` ( `idMateria` int(11) NOT NULL, `nombre` varchar(100)
 * NOT NULL, `año` int(11) NOT NULL, `estado` tinyint(1) NOT NULL )
 */
public class MateriaData {

    private Connection c = null;

    public MateriaData() {
        c = Conexion.getConexion();
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
    
        public Materia buscarMateria(int id) {

        Materia materia = null;

        String sql = "SELECT * FROM materia WHERE idMateria = ? AND estado = true";

        try {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                materia = new Materia();
                materia.setIdMateria(id);
                materia.setNombre(rs.getString("nombre"));
                materia.setAnio(rs.getInt("año"));
                materia.setEstado(true);
            } else {
                JOptionPane.showMessageDialog(null, "No existe esa materia :/");
            }
            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error SQL." + e);
        }

        return materia;
    }
    
        
        public void actualizarMateria(Materia materia) {

        String sql = "UPDATE materia SET nombre = ?, año = ?  WHERE idMateria = ?";

        //no debe modificar el estado ya que para eso ya esta el borrar materia
        
        try {
            PreparedStatement ps = c.prepareStatement(sql);
            
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnio());
            ps.setInt(3,materia.getIdMateria());
                    
            int validation = ps.executeUpdate();
            
            if(validation == 1){
                JOptionPane.showMessageDialog(null, "Se actualizo la materia!");
            }
            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error SQL." + e);
        }

    }
        
        public void eliminarMateria(Materia materia){
        String sql = "UPDATE materia SET estado = false WHERE idMateria=? AND estado=true";
        
        try{
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, materia.getIdMateria());
            int validation = ps.executeUpdate();
            
            if(validation==1){
                JOptionPane.showMessageDialog(null, "Se elimino esa materia");
            }else{
                JOptionPane.showMessageDialog(null, "No encontramos esa materia actualmente en nuestra grilla curricular");
            }
        }
        
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error SQL. " + e);
        }
        
    }
    
        
        public List<Materia> listarMaterias() {

        String sql = "SELECT idMateria, nombre, año FROM materia WHERE estado = 1";
        ArrayList<Materia> materias = new ArrayList<>();

        try {
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Materia materia = new Materia();
                materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnio(rs.getInt("año"));
     
                materia.setEstado(true);

                materias.add(materia);
            }
            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error SQL." + e);
        }

        return materias;
    }

}
