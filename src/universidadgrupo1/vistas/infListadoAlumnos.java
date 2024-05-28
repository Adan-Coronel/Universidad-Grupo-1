package universidadgrupo1.vistas;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import universidadgrupo1.AccesoADatos.AlumnoData;
import universidadgrupo1.AccesoADatos.InscripcionData;
import universidadgrupo1.AccesoADatos.MateriaData;
import universidadgrupo1.entidades.*;

public class infListadoAlumnos extends javax.swing.JInternalFrame {

    private ArrayList<Materia> listaMat;
    private MateriaData matData;
    private ArrayList<Alumno> listaAlum;
    private AlumnoData alumData;
    private InscripcionData inscData;

    private DefaultTableModel model;

    public infListadoAlumnos() {
        initComponents();

        model = new DefaultTableModel();
        matData = new MateriaData();
        inscData = new InscripcionData();
        alumData = new AlumnoData();
        listaAlum = (ArrayList<Alumno>) alumData.listarAlumnos();
        listaMat = (ArrayList<Materia>) matData.listarMaterias();
        armarCabecera();
        cargaMaterias();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTituloListado = new javax.swing.JLabel();
        lblSeleccion = new javax.swing.JLabel();
        cbMateria = new javax.swing.JComboBox<>();
        spTabla = new javax.swing.JScrollPane();
        tblInscriptos = new javax.swing.JTable();
        btnSalirListado = new javax.swing.JButton();

        lblTituloListado.setText("Listado de Alumnos por Materia");

        lblSeleccion.setText("Seleccione una materia");

        cbMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMateriaActionPerformed(evt);
            }
        });

        tblInscriptos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Dni", "Apellido", "Nombre"
            }
        ));
        spTabla.setViewportView(tblInscriptos);

        btnSalirListado.setText("Salir");
        btnSalirListado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirListadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblTituloListado)
                                .addGap(105, 105, 105))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(spTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalirListado)
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTituloListado)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSeleccion)
                    .addComponent(cbMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalirListado)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirListadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirListadoActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirListadoActionPerformed

    private void cbMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMateriaActionPerformed
        borrarFilas();
        cargarMateriasPorAlumno();
    }//GEN-LAST:event_cbMateriaActionPerformed

    public void borrarFilas() {
        int i = model.getRowCount();

        for (int j = i-1; j >= 0; j--) {
            model.removeRow(j);
        }

    }

    private void cargaMaterias() {
        for (Materia item : listaMat) {
            cbMateria.addItem(item);
        }
    }

    private void armarCabecera() {
        ArrayList<Object> filaCabecera = new ArrayList<>();
        filaCabecera.add("Id");
        filaCabecera.add("Dni");
        filaCabecera.add("Apellido");
        filaCabecera.add("Nombre");

        for (Object i : filaCabecera) {
            model.addColumn(i);
        }
        tblInscriptos.setModel(model);
    }

    private void cargarMateriasPorAlumno() {

        Materia select = (Materia) cbMateria.getSelectedItem();
        listaAlum = (ArrayList<Alumno>) inscData.listarAlumnosPorMateria(select.getIdMateria());

        for (Alumno a : listaAlum) {
            model.addRow(new Object[]{a.getIdAlumno(), a.getDni(), a.getApellido(), a.getNombre()});
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnSalirListado;
    public javax.swing.JComboBox<Materia> cbMateria;
    private javax.swing.JLabel lblSeleccion;
    private javax.swing.JLabel lblTituloListado;
    private javax.swing.JScrollPane spTabla;
    public javax.swing.JTable tblInscriptos;
    // End of variables declaration//GEN-END:variables
}
