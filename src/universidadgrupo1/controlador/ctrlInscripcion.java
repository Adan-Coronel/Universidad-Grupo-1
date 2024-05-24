

package universidadgrupo1.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import universidadgrupo1.AccesoADatos.*;
import universidadgrupo1.Vistas.*;
import universidadgrupo1.entidades.*;




public class ctrlInscripcion implements ActionListener {

    
    private Inscripcion inscripcion;
    private InscripcionData inscripcionData;
    private FormularioInscripcion formInsc;

    public ctrlInscripcion(Inscripcion inscripcion, InscripcionData inscripcionData, FormularioInscripcion formInsc) {
        this.inscripcion = inscripcion;
        this.inscripcionData = inscripcionData;
        this.formInsc = formInsc;
        
        formInsc.btnAnular.addActionListener(this);
        formInsc.btnInscribir.addActionListener(this);
        formInsc.btnSalir.addActionListener(this);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        //boton de inscribir un alumno
        if (e.getSource() == formInsc.btnInscribir) {
            
            int filaSelect = formInsc.tblListadoAlumnos.getSelectedRow();
            
            if (filaSelect != -1) {
                Alumno a = (Alumno) formInsc.cbAlumno.getSelectedItem();
                int idMat = (Integer)formInsc.tblListadoAlumnos.getValueAt(filaSelect, 0);
                String nombreMat = (String) formInsc.tblListadoAlumnos.getValueAt(filaSelect, 1);
                int anioMat = (Integer) formInsc.tblListadoAlumnos.getValueAt(filaSelect, 2);
                
                Materia m = new Materia(idMat,anioMat,nombreMat,true);
                Inscripcion i = new Inscripcion (a,m,0);
                inscripcionData.guardarInscipcion(i);
                formInsc.borrarFilas(); //tuve que hacer publico el metodo
            }else{
            
                JOptionPane.showMessageDialog(null, "");
            }

        }
        
        //boton de anular la inscripcion de un alumno
        
        if (e.getSource() == formInsc.btnAnular) {
            int filaSelect = formInsc.tblListadoAlumnos.getSelectedRow();
            if (filaSelect != -1) {
                Alumno a = (Alumno) formInsc.cbAlumno.getSelectedItem();
                int idMat = (Integer) formInsc.tblListadoAlumnos.getValueAt(filaSelect, 0);
                inscripcionData.borrarInscripcionIDAlumnoIDMateria(a.getIdAlumno(), idMat);
                formInsc.borrarFilas();
            }
            
        }
        
        
    }

    
    
    
    
    
}
