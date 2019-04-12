package Vista;

import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



public class Alumno extends javax.swing.JFrame {
    

    public Alumno() {
        initComponents();
        setLocationRelativeTo(null);
        listarAlumnos();
        btn_Eliminar.setEnabled(false);
        btn_Modificar.setEnabled(false);
        this.initComboGrupo();        
        this.jsEdaAlu.getModel().setValue(18);
    }
    
    public void limpiar() {
        this.txt_NomAlu.setText("");
        this.txt_CveAlu.setText("");
        this.txt_BusCveALu.setText("");
        this.cmb_CveGru.setSelectedIndex(0);
        this.jsEdaAlu.getModel().setValue(18);
    }
    
        public void insertarAlumnos() {
        String cveAlu;
        String nomAlu;
        Integer edaAlu;
        String cveGru;

        cveAlu = txt_CveAlu.getText();
        nomAlu = txt_NomAlu.getText();
        edaAlu = Integer.parseInt(jsEdaAlu.getValue().toString());
        cveGru = (String) cmb_CveGru.getSelectedItem();
        
        modelo.Alumno alu = new modelo.Alumno(cveAlu, nomAlu, edaAlu, cveGru);

        modelo.Operaciones operacion = new modelo.Operaciones();
        operacion.guardarAlumno(alu);
        JOptionPane.showMessageDialog(null, "Alumno Guardado:"+ "' ", "Insercion Exitosa", JOptionPane.INFORMATION_MESSAGE);
        limpiar();
        listarAlumnos();
    }
    
    private void initComboGrupo() {
        ComboBoxModel modelo = new DefaultComboBoxModel();
        cmb_CveGru.setModel(modelo);
        cmb_CveGru.addItem("Seleccione un Grupo");

        modelo.Operaciones operacion = new modelo.Operaciones();
        List datos = operacion.cargarCombo();
        Iterator it = datos.iterator();

        while (it.hasNext()) {
            modelo.Grupo g = (modelo.Grupo) it.next();
            this.cmb_CveGru.addItem(g.getCveGru());
        }
    }
    
    public void listarAlumnos() {
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            tblAlumnos.setModel(modelo);

            modelo.addColumn("Clave");
            modelo.addColumn("Nombre");
            modelo.addColumn("Edad");
            modelo.addColumn("Grupo");

            modelo.Operaciones operacion = new modelo.Operaciones();
            List datos = operacion.ListaAlumno();
            Iterator it = datos.iterator();

            if (datos.size() > 0) {
                while (it.hasNext()) {
                    modelo.Alumno alu = (modelo.Alumno) it.next();

                    Object[] fila = new Object[4];

                    fila[0] = alu.getCveAlu();
                    fila[1] = alu.getNomAlu();
                    fila[2] = alu.getEdaAlu();
                    fila[3] = alu.getCveGru();

                    modelo.addRow(fila);
                }
            } else {
                JOptionPane.showMessageDialog(this, "No existe ningún alumno agregado");
            }
        } catch (Exception e) {
      }
    }

    
    public void modificarAlumnos() {
        String cveAlu;
        Integer edaAlu;
        String cveGru;
        String nomAlu;

        cveAlu = txt_CveAlu.getText();

        nomAlu = txt_NomAlu.getText();
        edaAlu = Integer.parseInt(jsEdaAlu.getValue().toString());
        cveGru = (String) cmb_CveGru.getSelectedItem();

        modelo.Operaciones operacion = new modelo.Operaciones();
        modelo.Alumno alu = null;
        alu = operacion.obtenerAlumno(cveAlu);

        alu.setNomAlu(nomAlu);
        alu.setEdaAlu(edaAlu);
        alu.setCveAlu(cveAlu);
        alu.setCveGru(cveGru);
        operacion.actualizarAlumno(alu);

        JOptionPane.showMessageDialog(null, "Se actualizo a:" + cveAlu + " Con el nombre: " + nomAlu, "Actualizacion Exitosa", JOptionPane.INFORMATION_MESSAGE);

        limpiar();
        listarAlumnos();
        btn_Insertar.setEnabled(true);
        btn_Eliminar.setEnabled(false);
        btn_Modificar.setEnabled(false);
        txt_CveAlu.setEnabled(true);
    }
    
        public void buscarAlumnos() {
        String cveAlu;
        cveAlu = txt_BusCveALu.getText();
        modelo.Operaciones operacion = new modelo.Operaciones();
        modelo.Alumno alu = null;
        alu = operacion.obtenerAlumno(cveAlu);

        txt_BusCveALu.setText(alu.getCveAlu());
        txt_CveAlu.setText(alu.getCveAlu());
        txt_NomAlu.setText(alu.getNomAlu());
        cmb_CveGru.setSelectedItem(alu.getCveGru());
        jsEdaAlu.getModel().setValue(alu.getEdaAlu());
        txt_BusCveALu.setText("");

        btn_Insertar.setEnabled(false);
        btn_Eliminar.setEnabled(true);
        btn_Modificar.setEnabled(true);
        txt_CveAlu.setEnabled(false);
    }
        
       public void eliminarAlumnos() {
        JOptionPane.showMessageDialog(null, "¿Seguro que quiere borrar este Alumnos?", "Advertencia", JOptionPane.WARNING_MESSAGE);
        String cveAlu;
        cveAlu = txt_CveAlu.getText();
        modelo.Operaciones operacion = new modelo.Operaciones();
        modelo.Alumno alu = null;
        alu = operacion.obtenerAlumno(cveAlu);
        operacion.eliminarAlumno(alu);
        JOptionPane.showMessageDialog(null, "Se elimino a: " + cveAlu, "Eliminacion Exitosa", JOptionPane.INFORMATION_MESSAGE);

        limpiar();
        listarAlumnos();
        btn_Insertar.setEnabled(true);
        btn_Eliminar.setEnabled(false);
        btn_Modificar.setEnabled(false);
        txt_CveAlu.setEnabled(true);
    }

    @SuppressWarnings("unchecked")                                         

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmb_CveGru = new javax.swing.JComboBox<>();
        jsEdaAlu = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_BusCveALu = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_NomAlu = new javax.swing.JTextPane();
        btn_Buscar = new javax.swing.JButton();
        btn_Eliminar = new javax.swing.JButton();
        btn_Insertar = new javax.swing.JButton();
        btn_Modificar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblAlumnos = new javax.swing.JTable();
        btn_Salir = new javax.swing.JButton();
        btn_Regresar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txt_CveAlu = new javax.swing.JTextPane();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CLAVE EXISTENTE");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("NOMBRE");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("EDAD");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("GRUPO");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));

        cmb_CveGru.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        cmb_CveGru.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmb_CveGru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_CveGruActionPerformed(evt);
            }
        });
        getContentPane().add(cmb_CveGru, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 250, 30));

        jsEdaAlu.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        getContentPane().add(jsEdaAlu, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 50, 30));

        txt_BusCveALu.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jScrollPane1.setViewportView(txt_BusCveALu);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 210, -1));

        txt_NomAlu.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jScrollPane2.setViewportView(txt_NomAlu);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 250, -1));

        btn_Buscar.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btn_Buscar.setText("BUSCAR");
        btn_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, -1, -1));

        btn_Eliminar.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btn_Eliminar.setText("ELIMINAR");
        btn_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 250, -1, -1));

        btn_Insertar.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btn_Insertar.setText("AGREGAR");
        btn_Insertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_InsertarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Insertar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, -1));

        btn_Modificar.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btn_Modificar.setText("MODIFICAR");
        btn_Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ModificarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 250, -1, -1));

        tblAlumnos.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        tblAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Clave", "Nombre", "Edad", "Grupo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblAlumnos);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 620, 210));

        btn_Salir.setBackground(new java.awt.Color(153, 0, 0));
        btn_Salir.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btn_Salir.setForeground(new java.awt.Color(255, 255, 255));
        btn_Salir.setText("SALIR");
        btn_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SalirActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 520, -1, -1));

        btn_Regresar.setBackground(new java.awt.Color(153, 0, 0));
        btn_Regresar.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btn_Regresar.setForeground(new java.awt.Color(255, 255, 255));
        btn_Regresar.setText("REGRESAR");
        btn_Regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RegresarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 520, -1, -1));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(117, 202, 195));
        jLabel5.setText(" AGREGAR ALUMNO  ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 390, 50));

        txt_CveAlu.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jScrollPane5.setViewportView(txt_CveAlu);

        getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 250, -1));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("CLAVE");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo.jpg")));
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmb_CveGruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_CveGruActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_CveGruActionPerformed

    private void btn_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EliminarActionPerformed
        try {
            boolean banClave = true;

            if (txt_CveAlu.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "La clave no puede quedar vacía");
                banClave = false;
            }
            if (banClave) {
              eliminarAlumnos();

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error" + e.getMessage());
        } 
    }//GEN-LAST:event_btn_EliminarActionPerformed

    private void btn_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SalirActionPerformed
        
        System.exit(0);
    }//GEN-LAST:event_btn_SalirActionPerformed

    private void btn_RegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RegresarActionPerformed
        
        Menu menu=new Menu();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_RegresarActionPerformed

    private void btn_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BuscarActionPerformed
         try {
            boolean banClave = true;

            if (txt_BusCveALu.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Inserta una Clave!");
                banClave = false;
            }
            if (banClave) {
                buscarAlumnos();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error" + e.getMessage());
        }
    }//GEN-LAST:event_btn_BuscarActionPerformed

    private void btn_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ModificarActionPerformed
        try {
            boolean banClave = true;
            boolean banNombre = true;
            boolean banEdad = true;
            Integer cveGru = cmb_CveGru.getSelectedIndex();
            Integer edaAlu;
            edaAlu= Integer.parseInt(jsEdaAlu.getValue().toString());
            

        if (cveGru==0) {
            JOptionPane.showMessageDialog(this, "Debes de Seleccionar un Grupo");
            banClave = false;
        }
        if (txt_CveAlu.getText().length() < 4) {
            JOptionPane.showMessageDialog(this, "La clave del alumno debe tener almenos 4 digitos");
            banClave = false;
        }

        if (!txt_NomAlu.getText().isEmpty()) {
            if (!txt_NomAlu.getText().matches("^[A-Za-z ]*$")) {
                JOptionPane.showMessageDialog(this, "El nombre no debe de tener números");
                banNombre = false;
            }
        } else {
            JOptionPane.showMessageDialog(this, "El nombre no puede quedar vacío");
            banNombre = false;
        }
        if (edaAlu < 17 || edaAlu > 99) {
            JOptionPane.showMessageDialog(this, "Debe ser mayor de 18 años!");
            banEdad = false;
        }
        if (banClave && banNombre && banEdad) {
            modificarAlumnos();
        }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error" + e.getMessage());
        }
    }//GEN-LAST:event_btn_ModificarActionPerformed

    private void btn_InsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_InsertarActionPerformed

        try {
            boolean banClave = true;
            boolean banNombre = true;
            boolean banEdad = true;
            Integer cveGru = cmb_CveGru.getSelectedIndex();
            Integer edaAlu;
            edaAlu= Integer.parseInt(jsEdaAlu.getValue().toString());
            
            if (cveGru==0) {
            JOptionPane.showMessageDialog(this, "Selecciona un Grupo");
            banClave = false;
        }
        if (txt_CveAlu.getText().length() < 4) {
            JOptionPane.showMessageDialog(this, "La clave del alumno debe tener almenos 4 digitos");
            banClave = false;
        }

        if (!txt_NomAlu.getText().isEmpty()) {
            if (!txt_NomAlu.getText().matches("^[A-Za-z ]*$")) {
                JOptionPane.showMessageDialog(this, "El nombre no acepta números");
                banNombre = false;
            }
        } else {
            JOptionPane.showMessageDialog(this, "El nombre no puede quedar vacío");
            banNombre = false;
        }
        if (edaAlu < 17 || edaAlu > 99) {
            JOptionPane.showMessageDialog(this, "La edad debe ser mayor a 18 años");
            banEdad = false;
        }
        if (banClave && banNombre && banEdad) {
            insertarAlumnos();
        }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error" + e.getMessage());
        }
    }//GEN-LAST:event_btn_InsertarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Alumno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Buscar;
    private javax.swing.JButton btn_Eliminar;
    private javax.swing.JButton btn_Insertar;
    private javax.swing.JButton btn_Modificar;
    private javax.swing.JButton btn_Regresar;
    private javax.swing.JButton btn_Salir;
    private javax.swing.JComboBox<String> cmb_CveGru;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JSpinner jsEdaAlu;
    private javax.swing.JTable tblAlumnos;
    private javax.swing.JTextPane txt_BusCveALu;
    private javax.swing.JTextPane txt_CveAlu;
    private javax.swing.JTextPane txt_NomAlu;
    // End of variables declaration//GEN-END:variables
}
