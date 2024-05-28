package universidadgrupo1.controlador;

import universidadgrupo1.vistas.infFormMateria;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import universidadgrupo1.AccesoADatos.*;
import universidadgrupo1.entidades.*;

/**
 *
 * @author tDev
 */
public class ctrlMaterias implements ActionListener{

    private Materia materia;
    private MateriaData materiaData;
    private infFormMateria materiaVista;

    public ctrlMaterias(Materia materia, MateriaData materiaData, infFormMateria materiaVista) {
        this.materia = materia;
        this.materiaData = materiaData;
        this.materiaVista = materiaVista;
        
        materiaVista.btnBuscarMat.addActionListener(this);
        materiaVista.btnEliminarMat.addActionListener(this);
        materiaVista.btnGuardarMat.addActionListener(this);
        materiaVista.btnNuevaMat.addActionListener(this);
        materiaVista.btnSalirMat.addActionListener(this);
        
        materiaVista.btnBuscarMat.setEnabled(false);
        materiaVista.tfCodigo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                materiaVista.btnBuscarMat.setEnabled(true);
            }
        });
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        //ACCION PARA GUARDAR mat
        if (e.getSource() == materiaVista.btnGuardarMat) {
            boolean band = true;
            
            if (validarString(materiaVista.tfNombreMat.getText())) {
                materia.setNombre(materiaVista.tfNombreMat.getText());
            } else {
                JOptionPane.showMessageDialog(null, "Campo inválido de Nombre");
                materiaVista.tfNombreMat.setText("");
                materiaVista.tfNombreMat.requestFocus();
                band = false;
            }
            if (validarEnteros(materiaVista.tfAnio.getText())) {
                materia.setAnio(Integer.parseInt(materiaVista.tfAnio.getText()));
            } else {
                JOptionPane.showMessageDialog(null, "Campo inválido en año");
                materiaVista.tfAnio.setText("");
                band = false;
            }
            
//            if (validarEnteros(materiaVista.tfCodigo.getText())) {
//                materia.setIdMateria(Integer.parseInt(materiaVista.tfCodigo.getText()));
//            } else {
//                JOptionPane.showMessageDialog(null, "El codigo debe ser entero");
//                materiaVista.tfCodigo.setText("");
//                band = false;
//            }
            materia.setEstado(materiaVista.rbEstadoMat.isSelected());
           
            if(band){
            materiaData.guardarMateria(materia);
            }
        }
        
         //ACCION PARA ELIMINAR Materia
        if (e.getSource() == materiaVista.btnEliminarMat) {

            Integer idMat = null;

            if (validarEnteros(materiaVista.tfCodigo.getText())) {
                idMat = Integer.parseInt(materiaVista.tfCodigo.getText());
                materiaVista.tfCodigo.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar. El ID debe ser un entero");
            }
            materia = materiaData.buscarMateria(idMat);
            if (materia != null) {
                materiaData.eliminarMateria(materia);
            }

        }
        
         //ACCION PARA LIMPIAR CAMPOS CON NUEVO
        if (e.getSource() == materiaVista.btnNuevaMat) {

            limpiar();

        }
        
                //ACCION PARA BUSCAR materia
        if (e.getSource() == materiaVista.btnBuscarMat) {

            Integer idABuscar = null;
            if (validarEnteros(materiaVista.tfCodigo.getText())) {
                idABuscar = Integer.parseInt(materiaVista.tfCodigo.getText());
            } else {
                JOptionPane.showMessageDialog(null, "El ID debe ser un entero");
            }
            if (!idABuscar.equals(null)) {
                materia = materiaData.buscarMateria(idABuscar);
                if (materia != null) {
                    materiaVista.tfNombreMat.setText(materia.getNombre());
                    materiaVista.tfAnio.setText(materia.getAnio()+"");
                    materiaVista.rbEstadoMat.setSelected(true);
                }
            }

        }
        
        if(e.getSource()==materiaVista.btnSalirMat){
            materiaVista.dispose();
        }
 
        
    }
    

    
    
    public void limpiar() {
        materiaVista.tfNombreMat.setText("");
        materiaVista.tfCodigo.setText("");
        materiaVista.tfAnio.setText("");
        //agregar date xd new date JC fechaNac.setDate(new Date());
    }

    public boolean validarEnteros(String s) {

        String regExp = "^-?\\d+$";

        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(s);

        return m.matches();
    }

    public boolean validarString(String s) {
        String regExp = "^[a-zA-Z0-9áéíóúÁÉÍÓÚüÜñÑ ]+$";

        return s.matches(regExp);
        //estoy perdiendo salud mental con este paquete de control
    }

    
    
}
