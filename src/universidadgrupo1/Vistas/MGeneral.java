
package universidadgrupo1.vistas;

import universidadgrupo1.AccesoADatos.*;
import universidadgrupo1.controlador.*;
import universidadgrupo1.entidades.*;
public class MGeneral extends javax.swing.JFrame {

    public MGeneral() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dpGeneral = new javax.swing.JDesktopPane();
        mbMenuGeneral = new javax.swing.JMenuBar();
        mAlumno = new javax.swing.JMenu();
        miFormAlumno = new javax.swing.JMenuItem();
        mMateria = new javax.swing.JMenu();
        miFormMateria = new javax.swing.JMenuItem();
        mAdministracion = new javax.swing.JMenu();
        miInscripciones = new javax.swing.JMenuItem();
        miNotas = new javax.swing.JMenuItem();
        mConsultas = new javax.swing.JMenu();
        miConsultaAlumnos = new javax.swing.JMenuItem();
        mSalir = new javax.swing.JMenu();
        miSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout dpGeneralLayout = new javax.swing.GroupLayout(dpGeneral);
        dpGeneral.setLayout(dpGeneralLayout);
        dpGeneralLayout.setHorizontalGroup(
            dpGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 489, Short.MAX_VALUE)
        );
        dpGeneralLayout.setVerticalGroup(
            dpGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 567, Short.MAX_VALUE)
        );

        mAlumno.setText("Alumno");

        miFormAlumno.setText("Formulario de alumno");
        miFormAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miFormAlumnoActionPerformed(evt);
            }
        });
        mAlumno.add(miFormAlumno);

        mbMenuGeneral.add(mAlumno);

        mMateria.setText("Materia");

        miFormMateria.setText("Formulario materia");
        miFormMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miFormMateriaActionPerformed(evt);
            }
        });
        mMateria.add(miFormMateria);

        mbMenuGeneral.add(mMateria);

        mAdministracion.setText("Administracion");

        miInscripciones.setText("Manejo de inscripciones");
        miInscripciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miInscripcionesActionPerformed(evt);
            }
        });
        mAdministracion.add(miInscripciones);

        miNotas.setText("Manipulacion de notas");
        miNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miNotasActionPerformed(evt);
            }
        });
        mAdministracion.add(miNotas);

        mbMenuGeneral.add(mAdministracion);

        mConsultas.setText("Consultas");

        miConsultaAlumnos.setText("Alumnos por materia");
        miConsultaAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miConsultaAlumnosActionPerformed(evt);
            }
        });
        mConsultas.add(miConsultaAlumnos);

        mbMenuGeneral.add(mConsultas);

        mSalir.setText("Salir");

        miSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        miSalir.setText("Salir");
        miSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSalirActionPerformed(evt);
            }
        });
        mSalir.add(miSalir);

        mbMenuGeneral.add(mSalir);

        setJMenuBar(mbMenuGeneral);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dpGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dpGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miFormAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miFormAlumnoActionPerformed
        Alumno a = new Alumno();
        AlumnoData ad = new AlumnoData();
        universidadgrupo1.vistas.infFormAlumno ia =  new universidadgrupo1.vistas.infFormAlumno();
         ctrlCargaAlumnos ca = new ctrlCargaAlumnos(a, ad, ia);
        dpGeneral.removeAll();
        dpGeneral.repaint();
        ia.setVisible(true);
        ia.setLocation(00, 00);
        dpGeneral.add(ia);
        dpGeneral.moveToFront(ia);
        /*
        jdpEscritorio.removeAll();
        jdpEscritorio.repaint();
        AgregarProductos p1 = new AgregarProductos(listaProductos);
        p1.setVisible(true);
        p1.setLocation(00, 00);
        jdpEscritorio.add(p1);
        jdpEscritorio.moveToFront(p1);
        */
        
    }//GEN-LAST:event_miFormAlumnoActionPerformed

    private void miFormMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miFormMateriaActionPerformed
        Materia m = new Materia();
        MateriaData md = new MateriaData();
        universidadgrupo1.vistas.infFormMateria im = new universidadgrupo1.vistas.infFormMateria();
        ctrlMaterias cm = new ctrlMaterias(m, md, im);
        dpGeneral.removeAll();
        dpGeneral.repaint();
        im.setVisible(true);
        im.setLocation(00, 00);
        dpGeneral.add(im);
        dpGeneral.moveToFront(im);
    }//GEN-LAST:event_miFormMateriaActionPerformed

    private void miInscripcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miInscripcionesActionPerformed
        
        Inscripcion i = new Inscripcion();
        InscripcionData id = new InscripcionData();
        FormularioInscripcion fi = new FormularioInscripcion();
        ctrlInscripcion ci = new ctrlInscripcion(i, id, fi);
        dpGeneral.removeAll();
        dpGeneral.repaint();
        fi.setVisible(true);
        fi.setLocation(00, 00);
        dpGeneral.add(fi);
        dpGeneral.moveToFront(fi);
        
        
    }//GEN-LAST:event_miInscripcionesActionPerformed

    private void miNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miNotasActionPerformed
        Alumno a = new Alumno();
        AlumnoData ad = new AlumnoData();
        Inscripcion i = new Inscripcion();
        InscripcionData id = new InscripcionData();
         Materia m = new Materia();
        infCargaNotas icn = new infCargaNotas();
        ctrlCargaNotas cn = new ctrlCargaNotas(a, ad, m, i, id, icn);
        dpGeneral.removeAll();
        dpGeneral.repaint();
        icn.setVisible(true);
        icn.setLocation(00, 00);
        dpGeneral.add(icn);
        dpGeneral.moveToFront(icn);
        
    }//GEN-LAST:event_miNotasActionPerformed

    private void miConsultaAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miConsultaAlumnosActionPerformed
        
        infListadoAlumnos ila = new infListadoAlumnos();
        dpGeneral.removeAll();
        dpGeneral.repaint();
        ila.setVisible(true);
        ila.setLocation(00, 00);
        dpGeneral.add(ila);
        dpGeneral.moveToFront(ila);
        
    }//GEN-LAST:event_miConsultaAlumnosActionPerformed

    private void miSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSalirActionPerformed
      
        dispose();
    }//GEN-LAST:event_miSalirActionPerformed

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MGeneral().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane dpGeneral;
    private javax.swing.JMenu mAdministracion;
    private javax.swing.JMenu mAlumno;
    private javax.swing.JMenu mConsultas;
    private javax.swing.JMenu mMateria;
    private javax.swing.JMenu mSalir;
    private javax.swing.JMenuBar mbMenuGeneral;
    private javax.swing.JMenuItem miConsultaAlumnos;
    private javax.swing.JMenuItem miFormAlumno;
    private javax.swing.JMenuItem miFormMateria;
    private javax.swing.JMenuItem miInscripciones;
    private javax.swing.JMenuItem miNotas;
    private javax.swing.JMenuItem miSalir;
    // End of variables declaration//GEN-END:variables
}
