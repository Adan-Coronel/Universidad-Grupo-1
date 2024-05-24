

package universidadgrupo1.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        
        
        
        
    }

    
    
    
    
    
}
