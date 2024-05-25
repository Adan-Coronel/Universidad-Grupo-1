/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadgrupo1.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import universidadgrupo1.AccesoADatos.*;
import universidadgrupo1.Vistas.infCargaNotas;
import universidadgrupo1.entidades.*;


public class ctrlCargaNotas implements ActionListener {
    private Alumno alum;
    private AlumnoData alumData;
    private Materia materia;
    private Inscripcion inscripcion;
    private InscripcionData inscrData;
    private infCargaNotas cargaNotas;

    public ctrlCargaNotas(Alumno alum, AlumnoData alumData, Materia materia, Inscripcion inscripcion, InscripcionData inscrData, infCargaNotas cargaNotas) {
        this.alum = alum;
        this.alumData = alumData;
        this.materia = materia;
        this.inscripcion = inscripcion;
        this.inscrData = inscrData;
        this.cargaNotas = cargaNotas;
        
        cargaNotas.cbAlumno.addActionListener(this);
        cargaNotas.btnGuardar.addActionListener(this);
        cargaNotas.btnSalir.addActionListener(this);
        //falta como cambiar las notas
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //si se seleccionó un alumno en cbAlumno
        if(e.getSource() == cargaNotas.cbAlumno){
            cargaNotas.borrarFilas();
            alum = (Alumno) cargaNotas.cbAlumno.getSelectedItem();
            cargaNotas.cargaDatosInsc();
        }
        //si se presionó el botón guardar
        if(e.getSource() == cargaNotas.btnGuardar){
            int filaSelect = cargaNotas.tblNotas.getSelectedRow();
            
            if (filaSelect != -1) {
                //
                int idAlumno = alum.getIdAlumno();
                materia = inscripcion.getMateria();
                int idMat = materia.getIdMateria();
                double nota = (double) cargaNotas.tblNotas.getValueAt(filaSelect, 2);
                inscrData.actualizarNota(idAlumno, idMat, nota);
            }
        }
        //si se presionó el botón salir
        if(e.getSource()== cargaNotas.btnSalir){
            
        }
    }  
    
    
    
    
    
    
    
}
