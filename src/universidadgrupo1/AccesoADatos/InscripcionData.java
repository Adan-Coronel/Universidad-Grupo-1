package universidadgrupo1.AccesoADatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import universidadgrupo1.entidades.Alumno;
import universidadgrupo1.entidades.Inscripcion;
import universidadgrupo1.entidades.Materia;

//CREATE TABLE `inscripcion` (
//  `idInscripto` int(11) NOT NULL,
//  `nota` int(11) NOT NULL,
//  `idAlumno` int(11) NOT NULL,
//  `idMateria` int(11) NOT NULL
//)
public class InscripcionData {

    private Connection c = null;
    private MateriaData md = new MateriaData();
    private AlumnoData ad = new AlumnoData();

    //Tener en cuenta la posibilidad de dar de baja inscripciones cada vez
    //que un alumno se da de baja o cada vez que una materia se da de baja
    
    //  ↑  EL PROFE DIJO QUE NO PORQUE QUEREMOS HISTORIAL DE ALUMNO Y MATERIA
    
    public InscripcionData() {
        c = Conexion.getConexion();
    }

    public void guardarInscipcion(Inscripcion ins) {

        String sql = "INSERT INTO inscripcion (nota, idAlumno, idMateria) VALUES (?,?,?)";

        try {
            PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setDouble(1, ins.getNota());
            // la clase inscripcion tiene como atributos a un alumno y una materia por lo tanto para setear 
            //el id al ps, tengo que hacer el get de alumno y de ahi hacer el get del id, lo mismo con materia 
            
            ps.setInt(2, ins.getAlumno().getIdAlumno());
            ps.setInt(3, ins.getMateria().getIdMateria());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {

                ins.setIdInscripcion(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "inscripcion realizada, a estudiar viejo");
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error, no se pudo acceder a la tabla inscripcion");
        }
    }

    public void actualizarNota(int idAlumno, int idMateria, double nota) {

        String sql = "UPDATE inscripcion SET nota = ? WHERE idAlumno = ? AND idMateria = ?";

        try {
            PreparedStatement ps = c.prepareStatement(sql);

            ps.setDouble(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);

            int validation = ps.executeUpdate();
            if (validation == 1) {
                JOptionPane.showMessageDialog(null, "La nota fue actualizada!");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error, no se pudo acceder a la tabla, no se pudo cambiar la nota");
        }
    }

    public void borrarInscripcionIDAlumnoIDMateria(int idAlumno, int idMateria) {
        try {
            //TAMBIEN SE PUEDE BORRAR LA INSCRIPCION CON EL ID DE LA INSCRIPCION
            //de esta forma tambien se puede hacer ya que un alumno no se puede anotar 2 veces a la misma materia

            String sql = "DELETE FROM inscripcion WHERE idAlumno = ? AND idMateria = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);

            int validation = ps.executeUpdate();

            if (validation == 1) {
                JOptionPane.showMessageDialog(null, "Se borro esa inscipcion!");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error, no se pudo acceder a la tabla, no se pudo borrar la inscripcion");
        }

    }

    public List<Inscripcion> obtenerInscripciones() {

        String sql = "SELECT * FROM inscripcion";
        ArrayList<Inscripcion> inscripciones = new ArrayList<>();

        try {
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Inscripcion ins = new Inscripcion();
                ins.setIdInscripcion(rs.getInt("idInscripto"));
                ins.setNota(rs.getDouble("nota"));
                //guardamos dentro del alumno el id que esta en el resulset
                Alumno al = ad.buscarAlumno(rs.getInt("idAlumno"));
                Materia m = md.buscarMateria(rs.getInt("idMateria"));
                //una vez guardado los objetos de tipo materia y alumno, lo seteamos en la inscripcion
                ins.setAlumno(al);
                ins.setMateria(m);

                inscripciones.add(ins);
            }
            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error, no se pudo acceder a inscripcion." + e);
        }

        return inscripciones;
    }

    public List<Inscripcion> obtenerInscripcionesPorAlumno(int idAlumno) {

        String sql = "SELECT * FROM inscripcion WHERE idAlumno =?";
        ArrayList<Inscripcion> inscripciones = new ArrayList<>();

        try {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Inscripcion ins = new Inscripcion();
                ins.setIdInscripcion(rs.getInt("idInscripto"));
                ins.setNota(rs.getDouble("nota"));
                //guardamos dentro del alumno el id que esta en el resulset
                Alumno al = ad.buscarAlumno(rs.getInt("idAlumno"));
                Materia m = md.buscarMateria(rs.getInt("idMateria"));
                //una vez guardado los objetos de tipo materia y alumno, lo seteamos en la inscripcion
                ins.setAlumno(al);
                ins.setMateria(m);

                inscripciones.add(ins);
            }
            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error, no se pudo acceder a inscripcion." + e);
        }

        return inscripciones;
    }

    public List<Materia> obtenerMateriasCursadas(int idAlumno) {

        String sql = "SELECT m.idMateria, m.nombre, m.año, m.estado"
                + "FROM materia m"
                + "JOIN inscripcion i ON m.idMateria = i.idMateria"
                + "JOIN alumno a ON i.idAlumno = a.idAlumno"
                + "WHERE a.idAlumno = ?;";
        // probar si anda con esta sentencia, 
        //segun mis calculos de super matematico experto en sql con un master en programacion avalado por la universidad de la ulp, 
        //deberia funcionar. de lo contrario si no funciona, 
        //no fui yo el que lo hizo :)
        //       
        // ↑ ↑   hacete cargo tadeo, igual lo hiciste re bien ☻
        ArrayList<Materia> materias = new ArrayList<>();

        try {

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, idAlumno);
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
            JOptionPane.showMessageDialog(null, "Error, no se pudo acceder a inscripcion." + e);
        }

        return materias;
    }

    public List<Materia> obtenerMateriasNoCursadas(int idAlumno) {

        String sql = "SELECT m.idMateria, m.nombre, m.año, m.estado"
                + "FROM materia m"
                + "WHERE m.idMateria NOT IN ("
                + "    SELECT i.idMateria"
                + "    FROM inscripcion i"
                + "    WHERE i.idAlumno = ?"
                + ");";
        // probar si anda con esta sentencia, 
        //segun mis calculos de super matematico experto en sql con un master en programacion avalado por la universidad de la ulp, 
        //deberia funcionar. de lo contrario si no funciona, 
        //no fui yo el que lo hizo :)
        //       
        // ↑ ↑   hacete cargo tadeo, igual lo hiciste re bien ☻
        ArrayList<Materia> materias = new ArrayList<>();

        try {

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, idAlumno);
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
            JOptionPane.showMessageDialog(null, "Error, no se pudo acceder a inscripcion." + e);
        }

        return materias;
    }

    public List<Alumno> listarAlumnosPorMateria(int idMateria) {

        String sql = "SELECT a.idAlumno, a.dni, a.apellido, a.nombre, a.fechaNacimiento "
                + "FROM alumno a "
                + "JOIN inscripcion i ON a.idAlumno = i.idAlumno "
                + "WHERE i.idMateria = ?;";
        ArrayList<Alumno> alumnos = new ArrayList<>();

        try {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, idMateria);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Alumno alumno = new Alumno();
                alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                //alumno.setEstado(rs.getBoolean("estado"));
                alumnos.add(alumno);
            }
            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "INSCRIPCION DATA  Error SQL." + e);
        }

        return alumnos;
    }

}


    
    
    
    

