/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadgrupo1.Vistas;

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
        jMenuBar1 = new javax.swing.JMenuBar();
        mAlumno = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        mMateria = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        mAdministracion = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        mConsultas = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        mSalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout dpGeneralLayout = new javax.swing.GroupLayout(dpGeneral);
        dpGeneral.setLayout(dpGeneralLayout);
        dpGeneralLayout.setHorizontalGroup(
            dpGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 505, Short.MAX_VALUE)
        );
        dpGeneralLayout.setVerticalGroup(
            dpGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 392, Short.MAX_VALUE)
        );

        mAlumno.setText("Alumno");

        jMenuItem1.setText("Formulario de alumno");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        mAlumno.add(jMenuItem1);

        jMenuBar1.add(mAlumno);

        mMateria.setText("Materia");

        jMenuItem2.setText("Formulario materia");
        mMateria.add(jMenuItem2);

        jMenuBar1.add(mMateria);

        mAdministracion.setText("Administracion");

        jMenuItem3.setText("Manejo de inscripciones");
        mAdministracion.add(jMenuItem3);

        jMenuItem4.setText("Manipulacion de notas");
        mAdministracion.add(jMenuItem4);

        jMenuBar1.add(mAdministracion);

        mConsultas.setText("Consultas");

        jMenuItem5.setText("Alumnos por materia");
        mConsultas.add(jMenuItem5);

        jMenuBar1.add(mConsultas);

        mSalir.setText("Salir");
        jMenuBar1.add(mSalir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dpGeneral, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dpGeneral)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenu mAdministracion;
    private javax.swing.JMenu mAlumno;
    private javax.swing.JMenu mConsultas;
    private javax.swing.JMenu mMateria;
    private javax.swing.JMenu mSalir;
    // End of variables declaration//GEN-END:variables
}
