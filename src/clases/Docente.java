/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package clases;

import conexiones.Conexion;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Docente extends javax.swing.JInternalFrame {

    /**
     * Creates new form NewJInternalFrame
     */
    
    public Docente() {
        initComponents();
        nuevo.setEnabled(true);
        guardar.setEnabled(false);
        editar.setEnabled(false);
        desabilitar();
        vaciarTabla();
        verDatos();
    }
    
    public void desabilitar(){
        telefonoDocente.setEnabled(false);
        nombreDocente.setEnabled(false);
        idDocente.setEnabled(false);
        correoDocente.setEnabled(false);
        direccionDocente.setEnabled(false);
    }
    
    public void habilitar(){
        telefonoDocente.setEnabled(true);
        nombreDocente.setEnabled(true);
        correoDocente.setEnabled(true);
        idDocente.setEnabled(true);
        direccionDocente.setEnabled(true);
    }
    
    public void limpiar(){
        telefonoDocente.setText("");
        nombreDocente.setText("");
        idDocente.setText("");
        correoDocente.setText("");
        direccionDocente.setText("");
    }
    
        
    public void vaciarTabla(){
        DefaultTableModel Modelo = (DefaultTableModel) jTable1.getModel();
        String titulos[] = {"ID","NOMBRE_DOCENTE","CORREO","DIRECCION","TELEFONO"};
        Modelo = new DefaultTableModel(null,titulos);
        jTable1.setModel(Modelo);
    }

    public void verDatos(){
        try {
            Connection con1 = null;
            DefaultTableModel miModelo = (DefaultTableModel) jTable1.getModel();
            Conexion conect1 = new Conexion();
            con1 = conect1.getConnection();
            String dts[] = new String[5];
            String sql = "select * from Docente";
            Statement st = con1.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                dts[0] = rs.getString("no_trabajador");
                dts[1] = rs.getString("nombre");
                dts[2] = rs.getString("correo");
                dts[3] = rs.getString("direccion");
                dts[4] = rs.getString("telefono");
                miModelo.addRow(dts);
            }
            jTable1.setModel(miModelo);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "NO SE PUEDEN VISUALIZAR LOS DATOS DE LA TABLA", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        nombreDocente = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        direccionDocente = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        idDocente = new javax.swing.JTextField();
        correoDocente = new javax.swing.JTextField();
        eliminar = new javax.swing.JButton();
        editar = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        nuevo = new javax.swing.JButton();
        telefonoDocente = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Docentes");
        setToolTipText("");

        jLabel6.setFont(new java.awt.Font("Decker", 1, 12)); // NOI18N
        jLabel6.setText("CORREO");

        nombreDocente.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        nombreDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreDocenteActionPerformed(evt);
            }
        });
        nombreDocente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombreDocenteKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Decker", 1, 12)); // NOI18N
        jLabel7.setText("DIRECCION");

        direccionDocente.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        direccionDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                direccionDocenteActionPerformed(evt);
            }
        });
        direccionDocente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                direccionDocenteKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Decker", 1, 12)); // NOI18N
        jLabel8.setText("TELEFONO");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE_DOCENTE", "CORREO", "DIRECCION", "TELEFONO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel4.setFont(new java.awt.Font("Decker", 1, 12)); // NOI18N
        jLabel4.setText("NOMBRE");

        jLabel5.setFont(new java.awt.Font("Decker", 1, 12)); // NOI18N
        jLabel5.setText("ID DOCENTE");

        idDocente.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        idDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idDocenteActionPerformed(evt);
            }
        });
        idDocente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                idDocenteKeyTyped(evt);
            }
        });

        correoDocente.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        correoDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                correoDocenteActionPerformed(evt);
            }
        });
        correoDocente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                correoDocenteKeyTyped(evt);
            }
        });

        eliminar.setFont(new java.awt.Font("Decker", 1, 12)); // NOI18N
        eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/basura (1).png"))); // NOI18N
        eliminar.setText("ELIMINAR");
        eliminar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        editar.setFont(new java.awt.Font("Decker", 1, 12)); // NOI18N
        editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/editar (1).png"))); // NOI18N
        editar.setText("EDITAR");
        editar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });

        guardar.setFont(new java.awt.Font("Decker", 1, 12)); // NOI18N
        guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/disquete.png"))); // NOI18N
        guardar.setText("GUARDAR");
        guardar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        nuevo.setFont(new java.awt.Font("Decker", 1, 12)); // NOI18N
        nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/archivo-nuevo.png"))); // NOI18N
        nuevo.setText("NUEVO");
        nuevo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });

        telefonoDocente.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        telefonoDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefonoDocenteActionPerformed(evt);
            }
        });
        telefonoDocente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telefonoDocenteKeyTyped(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/profesor.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(correoDocente, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                                    .addComponent(nombreDocente)
                                    .addComponent(idDocente)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7))
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(direccionDocente, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                                    .addComponent(telefonoDocente))))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(guardar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                            .addComponent(editar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nuevo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(38, 38, 38)
                        .addComponent(jLabel1)))
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idDocente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(eliminar))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(nombreDocente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(nuevo)
                                .addGap(2, 2, 2)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(telefonoDocente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(direccionDocente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(correoDocente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(editar)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(guardar))))
                    .addComponent(jLabel1))
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nombreDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreDocenteActionPerformed
        nombreDocente.transferFocus();
    }//GEN-LAST:event_nombreDocenteActionPerformed

    private void nombreDocenteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreDocenteKeyTyped

    }//GEN-LAST:event_nombreDocenteKeyTyped

    private void direccionDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_direccionDocenteActionPerformed
        direccionDocente.transferFocus();
    }//GEN-LAST:event_direccionDocenteActionPerformed

    private void direccionDocenteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_direccionDocenteKeyTyped
 
    }//GEN-LAST:event_direccionDocenteKeyTyped

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        try
        {
            int fila = jTable1.getSelectedRow();
            idDocente.setText(jTable1.getValueAt(fila, 0).toString());
            nombreDocente.setText(jTable1.getValueAt(fila, 1).toString());
            correoDocente.setText(jTable1.getValueAt(fila, 2).toString());
            direccionDocente.setText(jTable1.getValueAt(fila, 3).toString());
            telefonoDocente.setText(jTable1.getValueAt(fila, 4).toString());
            nuevo.setEnabled(false);
            guardar.setEnabled(false);
            editar.setEnabled(true);
            eliminar.setEnabled(true);
            habilitar();
        } catch (Exception ex)
        {
            System.out.println("ERROR AL SELECCIONAR UN DOCENTE : " + ex.getMessage());
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void idDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idDocenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idDocenteActionPerformed

    private void idDocenteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idDocenteKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_idDocenteKeyTyped

    private void correoDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_correoDocenteActionPerformed
        correoDocente.transferFocus();
    }//GEN-LAST:event_correoDocenteActionPerformed

    private void correoDocenteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_correoDocenteKeyTyped
       
    }//GEN-LAST:event_correoDocenteKeyTyped

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        int fila = jTable1.getSelectedRow();
        if (fila == -1)
        {
            JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UN REGISTRO", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            int opc = JOptionPane.showConfirmDialog(this, "¿ESTA SEGURO QUE DESEA ELIMINAR ESTE REGISTRO?", "Pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (opc == JOptionPane.YES_OPTION)
            {
                try
                {
                    Connection con = null;
                    Conexion conect = new Conexion();
                    con = conect.getConnection();
                    Statement st = con.createStatement();
                    String sql = "delete from Docente where no_trabajador= ?";
                    PreparedStatement pst = con.prepareStatement(sql);
                    pst.setInt(1, Integer.parseInt(idDocente.getText()));
                    int n = pst.executeUpdate();
                    if (n > 0)
                    {
                        JOptionPane.showMessageDialog(this, "DATOS ELIMINADOS CORRECTAMENTE");
                        limpiar();
                        vaciarTabla();
                        verDatos();
                        nuevo.setEnabled(true);
                        guardar.setEnabled(false);
                        editar.setEnabled(false);
                        eliminar.setEnabled(false);
                        desabilitar();
                    }
                } catch (SQLException ex)
                {
                    JOptionPane.showMessageDialog(this, "DATOS NO ELIMINADOS CORRECTAMENTE" + ex.getMessage());
                }
            }
        }
    }//GEN-LAST:event_eliminarActionPerformed

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        try
        {
            Connection con = null;
            Conexion conect = new Conexion();
            con = conect.getConnection();
            Statement st = con.createStatement();
            String sql = "update Docente set nombre = ?, correo = ?, direccion = ?, telefono = ? where no_trabajador = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, nombreDocente.getText());
            pst.setString(2, correoDocente.getText());
            pst.setString(3, direccionDocente.getText());
            pst.setString(4, telefonoDocente.getText());
            pst.setInt(5, Integer.parseInt(idDocente.getText()));
            int n = pst.executeUpdate();
            if (n > 0)
            {
                JOptionPane.showMessageDialog(this, "DATOS ACTUALIZADOS CORRECTAMENTE");
                limpiar();
                vaciarTabla();
                verDatos();
                nuevo.setEnabled(true);
                guardar.setEnabled(false);
                editar.setEnabled(false);
                eliminar.setEnabled(false);
                desabilitar();
            }
        } catch (SQLException | HeadlessException e)
        {
            JOptionPane.showMessageDialog(this, "LOS DATOS NO HAN SIDO ACTUALIZADOS CORRECTAMENTE" + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_editarActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        if (nombreDocente.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "FALTA INGRESAR EL NOMBRE", "Advertencia", JOptionPane.WARNING_MESSAGE);
            nombreDocente.requestFocus();
        }
        else if (telefonoDocente.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "FALTA INGRESAR EL TELEFONO ", "Advertencia", JOptionPane.WARNING_MESSAGE);
            telefonoDocente.requestFocus();
        }
        else if (direccionDocente.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "FALTA INGRESAR LA DIRECCION", "Advertencia", JOptionPane.WARNING_MESSAGE);
            direccionDocente.requestFocus();
        }
        else if (correoDocente.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "FALTA INGRESAR EL CORREO", "Advertencia", JOptionPane.WARNING_MESSAGE);
            correoDocente.requestFocus();
        }
        else
        {
            try
            {
                Connection con = null;
                Conexion conect = new Conexion();
                con = conect.getConnection();
                Statement st = con.createStatement();
                String sql = "insert into Docente (nombre,correo,direccion,telefono) values (?,?,?,?)";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, nombreDocente.getText());
                pst.setString(2, correoDocente.getText());
                pst.setString(3, direccionDocente.getText());
                pst.setString(4, telefonoDocente.getText());
                
                int n = pst.executeUpdate();
                if (n > 0)
                {
                    JOptionPane.showMessageDialog(this, "DATOS GUARDADOS CORRECTAMENTE");
                    limpiar();
                    vaciarTabla();
                    verDatos();
                    nuevo.setEnabled(true);
                    guardar.setEnabled(false);
                    editar.setEnabled(false);
                    eliminar.setEnabled(false);
                    desabilitar();
                }
            } catch (SQLException | HeadlessException e)
            {
                JOptionPane.showMessageDialog(this, "LOS DATOS NO HAN SIDO GUARDADOS CORRECTAMENTE", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_guardarActionPerformed

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
        limpiar();
        habilitar();
        nuevo.setEnabled(false);
        guardar.setEnabled(true);
        editar.setEnabled(false);
        eliminar.setEnabled(false);
        vaciarTabla();
        verDatos();
    }//GEN-LAST:event_nuevoActionPerformed

    private void telefonoDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefonoDocenteActionPerformed
        telefonoDocente.transferFocus();
    }//GEN-LAST:event_telefonoDocenteActionPerformed

    private void telefonoDocenteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telefonoDocenteKeyTyped

    }//GEN-LAST:event_telefonoDocenteKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField correoDocente;
    private javax.swing.JTextField direccionDocente;
    private javax.swing.JButton editar;
    private javax.swing.JButton eliminar;
    private javax.swing.JButton guardar;
    private javax.swing.JTextField idDocente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable1;
    private javax.swing.JTextField nombreDocente;
    private javax.swing.JButton nuevo;
    private javax.swing.JTextField telefonoDocente;
    // End of variables declaration//GEN-END:variables
}
