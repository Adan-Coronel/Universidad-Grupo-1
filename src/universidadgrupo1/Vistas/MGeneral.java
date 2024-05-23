/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadgrupo1.Vistas;

import universidadgrupo1.AccesoADatos.AlumnoData;
import universidadgrupo1.controlador.ctrlCargaAlumnos;
import universidadgrupo1.entidades.Alumno;

/**
 *
 * @author amiev
 */
public class MGeneral extends javax.swing.JFrame {

    /**
     * Creates new form MGeneral
     */
    public MGeneral() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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
        mMateria.add(miFormMateria);

        mbMenuGeneral.add(mMateria);

        mAdministracion.setText("Administracion");

        miInscripciones.setText("Manejo de inscripciones");
        mAdministracion.add(miInscripciones);

        miNotas.setText("Manipulacion de notas");
        mAdministracion.add(miNotas);

        mbMenuGeneral.add(mAdministracion);

        mConsultas.setText("Consultas");

        miConsultaAlumnos.setText("Alumnos por materia");
        mConsultas.add(miConsultaAlumnos);

        mbMenuGeneral.add(mConsultas);

        mSalir.setText("Salir");
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

    /**
     * @param args the command line arguments
     */
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
    // End of variables declaration//GEN-END:variables
}
