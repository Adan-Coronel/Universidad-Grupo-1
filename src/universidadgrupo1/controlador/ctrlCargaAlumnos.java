
package universidadgrupo1.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.ZoneId;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import universidadgrupo1.AccesoADatos.*;
import universidadgrupo1.entidades.*;
import universidadgrupo1.vistas.*;


public class ctrlCargaAlumnos implements ActionListener{
    
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

        if (e.getSource() == alumnoVista.btnGuardarAlum) {
            alumno.setNombre(alumnoVista.tfNombre.getText());
            alumno.setApellido(alumnoVista.tfApellido.getText());
            alumno.setDni(Integer.parseInt(alumnoVista.tfDocumento.getText()));
            alumno.setEstado(alumnoVista.rbEstado.isSelected());
            //agregar el date JC
            alumnoData.guardarAlumno(alumno);

        }
        if (e.getSource() == alumnoVista.btnEliminarAlum) {

            int dniEncontrado = (Integer.parseInt(alumnoVista.tfDocumento.getText()));

            alumno = alumnoData.buscarAlumnoPorDni(dniEncontrado);

            alumnoData.borrarAlumno(alumno.getIdAlumno());

        }

        if (e.getSource() == alumnoVista.btnNuevoAlum) {
            
            limpiar();
            
        }
        if (e.getSource() == alumnoVista.btnBuscarAlum) {
            
            int dniABuscar = Integer.parseInt(alumnoVista.tfDocumento.getText());
            
            alumno = alumnoData.buscarAlumnoPorDni(dniABuscar);
            
            if (alumno != null) {
                alumnoVista.tfApellido.setText(alumno.getApellido());
                alumnoVista.tfNombre.setText(alumno.getNombre());
                alumnoVista.rbEstado.setSelected(true);
                //FALTA EL JCALENDAR
                java.util.Date date = java.util.Date.from(alumno.getFechaNacimiento().atStartOfDay(ZoneId.systemDefault()).toInstant()); // no se que mieda hace esta linea del orto
                //jcalendar.setDate(date);
            }
            
        }

    }
    public void limpiar(){
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

