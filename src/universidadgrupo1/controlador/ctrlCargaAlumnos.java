package universidadgrupo1.controlador;

import universidadgrupo1.vistas.infFormAlumno;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import universidadgrupo1.AccesoADatos.*;
import universidadgrupo1.entidades.*;

public class ctrlCargaAlumnos implements ActionListener {

    private Alumno alumno;
    private AlumnoData alumnoData;
    private infFormAlumno alumnoVista;

    public ctrlCargaAlumnos(Alumno alumno, AlumnoData alumnoData, infFormAlumno alumnoVista) {
        this.alumno = alumno;
        this.alumnoData = alumnoData;
        this.alumnoVista = alumnoVista;

        alumnoVista.btnGuardarAlum.addActionListener(this);
        alumnoVista.btnEliminarAlum.addActionListener(this);
        alumnoVista.btnNuevoAlum.addActionListener(this);
        alumnoVista.btnSalirAlum.addActionListener(this);
        alumnoVista.btnBuscarAlum.addActionListener(this);

    }
   
    @Override
    public void actionPerformed(ActionEvent e) {

        //ACCION PARA GUARDAR ALUMNO
        if (e.getSource() == alumnoVista.btnGuardarAlum) {

            if (validarString(alumnoVista.tfNombre.getText())) {
                alumno.setNombre(alumnoVista.tfNombre.getText());
            } else {
                JOptionPane.showMessageDialog(null, "Campo inválido de Nombre");
            }
            if (validarString(alumnoVista.tfApellido.getText())) {
                alumno.setApellido(alumnoVista.tfApellido.getText());
            } else {
                JOptionPane.showMessageDialog(null, "Campo inválido en Apellido");
            }
            if (validarEnteros(alumnoVista.tfDocumento.getText())) {
                alumno.setDni(Integer.parseInt(alumnoVista.tfDocumento.getText()));
            } else {
                JOptionPane.showMessageDialog(null, "El DNI debe ser un entero");
            }
            alumno.setEstado(alumnoVista.rbEstado.isSelected());
            //agregar el date JC
           
            alumno.setFechaNacimiento(alumnoVista.jcFechaNac.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            alumnoData.guardarAlumno(alumno);

        }

        //ACCION PARA ELIMINAR ALUMNO
        if (e.getSource() == alumnoVista.btnEliminarAlum) {

            Integer dniEncontrado = null;

            if (validarEnteros(alumnoVista.tfDocumento.getText())) {
                dniEncontrado = Integer.parseInt(alumnoVista.tfDocumento.getText());

            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar. El DNI debe ser un entero");
            }
            alumno = alumnoData.buscarAlumnoPorDni(dniEncontrado);
            if (alumno != null) {
                alumnoData.borrarAlumno(alumno.getIdAlumno());
            }

        }

        //ACCION PARA LIMPIAR CAMPOS CON NUEVO
        if (e.getSource() == alumnoVista.btnNuevoAlum) {

            limpiar();

        }

        //ACCION PARA BUSCAR ALUMNO
        if (e.getSource() == alumnoVista.btnBuscarAlum) {

            Integer dniABuscar = null;
            if (validarEnteros(alumnoVista.tfDocumento.getText())) {
                dniABuscar = Integer.parseInt(alumnoVista.tfDocumento.getText());
            } else {
                JOptionPane.showMessageDialog(null, "El DNI debe ser un entero");
            }
            if (!dniABuscar.equals(null)) {
                alumno = alumnoData.buscarAlumnoPorDni(dniABuscar);
                if (alumno != null) {
                    alumnoVista.tfApellido.setText(alumno.getApellido());
                    alumnoVista.tfNombre.setText(alumno.getNombre());
                    alumnoVista.rbEstado.setSelected(true);
                    
                    java.util.Date date = java.util.Date.from(alumno.getFechaNacimiento().atStartOfDay(ZoneId.systemDefault()).toInstant()); // no se que mieda hace esta linea del orto
                   alumnoVista.jcFechaNac.setDate(date);
                }
            }

        }
        
        if(e.getSource() == alumnoVista.btnSalirAlum){
            alumnoVista.dispose();
        }

    }

    public void limpiar() {
        alumnoVista.tfApellido.setText("");
        alumnoVista.tfDocumento.setText("");
        alumnoVista.tfNombre.setText("");
        alumnoVista.rbEstado.setSelected(true);
        //agregar date xd new date JC fechaNac.setDate(new Date());
    }

    public boolean validarEnteros(String s) {

        String regExp = "^-?\\d+$";

        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(s);

        return m.matches();
    }

    public boolean validarString(String s) {
        String regExp = "^[a-zA-Z ]+$";

        return s.matches(regExp);
        //estoy perdiendo salud mental con este paquete de control
    }

}
