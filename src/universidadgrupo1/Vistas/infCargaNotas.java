/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadgrupo1.vistas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import universidadgrupo1.AccesoADatos.*;
import universidadgrupo1.controlador.*;
import universidadgrupo1.entidades.*;


public class infCargaNotas extends javax.swing.JInternalFrame {
    private ArrayList<Inscripcion> listaIns;
    private ArrayList<Alumno> listaAlum;
    
    private Alumno select;
    private Materia materia;
    private Inscripcion inscripcion;
    
    private InscripcionData inscData;
    private MateriaData matData;
    private AlumnoData alumData;
    
    private DefaultTableModel model;
    /**
     * Creates new form CargaNotas
     */
    public infCargaNotas() {
        
        initComponents();
        initComponents();
        
        select = new Alumno();
        alumData = new AlumnoData();
        materia = new Materia();
        matData = new MateriaData();
        inscripcion = new Inscripcion();
        inscData = new InscripcionData();
        model = new DefaultTableModel();
        listaAlum = (ArrayList<Alumno>) alumData.listarAlumnos(); //tambien se puede hacer con List
        listaIns = new ArrayList<Inscripcion>();
        
        cargarAlumnos();//carga el combo box con los alumnos del metodo listar alumnos
        armarCabecera();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    private void cargarAlumnos(){
        for (Alumno item : listaAlum) {
            cbAlumno.addItem(item);
        }
    }
    
    private void armarCabecera() {
        ArrayList<Object> filaCabecera = new ArrayList<>();
        filaCabecera.add("Codigo");
        filaCabecera.add("Nombre");
        filaCabecera.add("Nota");

        for (Object i : filaCabecera) {
            model.addColumn(i);
        }
        tblNotas.setModel(model);
    }

    public void borrarFilas() {
        int i = model.getRowCount();

        for (int j = i-1; j >= 0; j--) {
            model.removeRow(j);
        }
    }
    
    public void cargaDatosInsc(){
        Alumno select = (Alumno) cbAlumno.getSelectedItem();
        listaIns = (ArrayList<Inscripcion>) inscData.obtenerInscripcionesPorAlumno(select.getIdAlumno());
   
        for (Inscripcion ins : listaIns) {
            materia = ins.getMateria();
            model.addRow(new Object[] {ins.getIdInscripcion(), materia.getNombre(), ins.getNota()});                    
        }    
    }
    
    public Inscripcion obtenerInscr(int idIns){
        for(Inscripcion ins : listaIns) {
            if(ins.getIdInscripcion() == idIns){
                inscripcion = ins;
            }
        }
        return inscripcion;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblSelecAlumn = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        cbAlumno = new javax.swing.JComboBox<>();
        spTablaNotas = new javax.swing.JScrollPane();
        tblNotas = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();

        lblTitulo.setText("Carga de notas");

        lblSelecAlumn.setText("Seleccione un alumno");

        btnGuardar.setText("Guardar");

        btnSalir.setText("Salir");

        tblNotas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Nota"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        spTablaNotas.setViewportView(tblNotas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addGap(42, 42, 42))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(btnGuardar)
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblSelecAlumn)
                                .addGap(27, 27, 27)
                                .addComponent(cbAlumno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(spTablaNotas, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(lblTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSelecAlumn)
                    .addComponent(cbAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(spTablaNotas, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnSalir))
                .addGap(38, 38, 38))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(53, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(417, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnGuardar;
    public javax.swing.JButton btnSalir;
    public javax.swing.JComboBox<Alumno> cbAlumno;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblSelecAlumn;
    private javax.swing.JLabel lblTitulo;
    public javax.swing.JScrollPane spTablaNotas;
    public javax.swing.JTable tblNotas;
    // End of variables declaration//GEN-END:variables
    

}
