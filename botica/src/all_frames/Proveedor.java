/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package all_frames;

import Clases.Controlador;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ramos
 */
public class Proveedor extends javax.swing.JFrame {
    Controlador contr = new Controlador();
    DefaultTableModel md2 = new DefaultTableModel();
    String idProveedor="";
    public Proveedor() {
        initComponents();
        md2.setColumnIdentifiers(new String[]{"id", "Proveedor", "Representante", "Género", "Dirección", "Tipo documento", "NÚMERO", "Registro Sanitario"});
        buscar();
        jtbprove.setModel(md2);
        actualizarTabla();
    }
public void crear(){
     if(txtrs.getText().trim().length()==0 || txtProve.getText().trim().length()==0 || txtnumero.getText().trim().length()==0||txtdirec.getText().trim().length()==0||
        jcbgen.getSelectedIndex()<0||txtapell.getText().trim().length()==0 ||jcbtipdoc.getSelectedIndex()<0|| txtnomb.getText().trim().length()==0){
         JOptionPane.showMessageDialog(null,"campos vacios , por favor complete todos los datos");
     }
     else{
                // como obtener el mensaje.
         JOptionPane.showMessageDialog(null, contr.DevolverRegistroDto("call Crud_proveedor(1, '" + txtProve.getText() + "', '"
                 + txtrs.getText() + "', '" + jcbtipdoc.getSelectedItem().toString() + "', '" + txtnumero.getText() + "', '" + txtnomb.getText()
                 + "', '" + txtapell.getText() + "', '" + jcbgen.getSelectedItem().toString() + "', '" + txtdirec.getText() + "', 1);", 1));
               buscar(); 
     }
     actualizarTabla();
    }
public void editar(){
         ///limpiar();
         if(jtbprove.getSelectedRow()>=0){
             //llenar();
          if(txtrs.getText().trim().length()==0 || txtProve.getText().trim().length()==0 || txtnumero.getText().trim().length()==0||txtdirec.getText().trim().length()==0||
        jcbgen.getSelectedIndex()<0||txtapell.getText().trim().length()==0 ||jcbtipdoc.getSelectedIndex()<0|| txtnomb.getText().trim().length()==0 ){
         JOptionPane.showMessageDialog(null,"campos vacios , por favor complete todos los datos");}
          else{
               JOptionPane.showMessageDialog(null,contr.DevolverRegistroDto("call Crud_proveedor('"+idProveedor+"', '"+txtProve.getText() + "', '"
                 + txtrs.getText() + "', '" + jcbtipdoc.getSelectedItem().toString() + "', '" + txtnumero.getText() + "', '" + txtnomb.getText()
                 + "', '" + txtapell.getText() + "', '" + jcbgen.getSelectedItem().toString() + "', '" + txtdirec.getText() + "', 2);",1));
               
               Cancelar();
               txtapell.grabFocus();
               
          }
         }
         else{
          JOptionPane.showMessageDialog(null,"Seleccionar primero el elemento");jtbprove.grabFocus();
         }
         actualizarTabla();
       }
public void eliminar(){
      if(jtbprove.getSelectedRow()>-1){
          if(JOptionPane.showConfirmDialog(null,"Esta seguro de Eliminar \n el registro del proveedor: "
           +jtbprove.getValueAt(jtbprove.getSelectedRow(),2).toString(),"Confirmar",0)==0){
              
           if(contr.Verificarconsulta("SELECT * FROM proveedor p "
                   + "where p.idproveedor="+idProveedor+";")){
               
            JOptionPane.showMessageDialog(null,"el Proveedor "+jtbprove.getValueAt(jtbprove.getSelectedRow(),2).toString()
            + " No se debe eliminar  ");
            jtbprove.clearSelection();
           }   
           else{
            JOptionPane.showMessageDialog(null,contr.DevolverRegistroDto("call Crud_proveedor('"+idProveedor+"', '"+txtProve.getText() + "', '"
                 + txtrs.getText() + "', '" + jcbtipdoc.getSelectedItem().toString() + "', '" + txtnumero.getText() + "', '" + txtnomb.getText()
                 + "', '" + txtapell.getText() + "', '" + jcbgen.getSelectedItem().toString() + "', '" + txtdirec.getText()+
                 "', 3);",1));
            
            Cancelar();
            txtapell.grabFocus();
           }
          }
          else{jtbprove.clearSelection();}
         }   
         else{
          JOptionPane.showMessageDialog(null,"Primero Selecciona al Proveedor");
          jtbprove.grabFocus();  
         }
    
    }
    public void Cancelar(){
        txtbusca.setText(null);
        txtProve.grabFocus();idProveedor="";
        txtnomb.setText(null);
        txtapell.setText(null);
        txtnumero.setText(null);
        txtdirec.setText(null);
        jcbgen.setSelectedIndex(-1);
        jcbtipdoc.setSelectedIndex(-1);
        buscar();
    }
     public void buscar(){
     contr.LlenarJTabla(md2,"select p.idproveedor,p.nom_prove PROVEEDOR,concat_ws(' ',i.nom, i.ape) Representante , gen, dir, nomTipDoc,numIden,registrSan\n" +
"from proveedor p inner join identificaciong i on i.identificacion=p.identificacion\n" +
"inner join tipodoc t on t.idtipoDoc=i.idtipoDoc WHERE concat_ws(' ',nom,ape) LIKE '%"+txtbusca.getText()+"%' order by idproveedor ;",8);
    }
     public void actualizarTabla(){
    contr.LlenarJTabla(md2, "select p.idproveedor,p.nom_prove PROVEEDOR,concat_ws(' ',i.nom, i.ape) Representante , gen, dir, nomTipDoc,numIden,registrSan\n"
                + "from proveedor p inner join identificaciong i on i.identificacion=p.identificacion\n"
                + "inner join tipodoc t on t.idtipoDoc=i.idtipoDoc\n"
                + "order by p.idproveedor", 8);
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtapell = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtProve = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtnomb = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtrs = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jcbtipdoc = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtnumero = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtdirec = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jcbgen = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtbusca = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbprove = new javax.swing.JTable();

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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("APELLIDOS:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 40, -1, -1));

        txtapell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtapellActionPerformed(evt);
            }
        });
        jPanel1.add(txtapell, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 40, 198, -1));

        jLabel2.setText("NOMBRE:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, -1, 20));

        txtProve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProveActionPerformed(evt);
            }
        });
        jPanel1.add(txtProve, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 121, -1));

        jLabel3.setText("PROVEEDOR:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));
        jPanel1.add(txtnomb, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 150, -1));

        jLabel4.setText("REGISTRO SANITARIO");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 130, -1, -1));
        jPanel1.add(txtrs, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 130, 121, -1));

        jLabel8.setText("DATOS DEL PROVEEDOR");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 11, -1, -1));

        jLabel5.setText("TIPO DOCUMENTO:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jcbtipdoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DNI", "RUC", "CARNET DE EXTRANJERIA" }));
        jPanel1.add(jcbtipdoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 100, -1));

        jLabel6.setText("NÚMERO:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, -1, -1));
        jPanel1.add(txtnumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 110, -1));

        jLabel7.setText("DIRECCIÓN:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));
        jPanel1.add(txtdirec, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 230, -1));

        jLabel11.setText("GÉNERO:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, -1, -1));

        jcbgen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino" }));
        jPanel1.add(jcbgen, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 120, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 180));

        jButton1.setText("CREAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        jButton2.setText("EDITAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, -1, -1));

        jButton3.setText("ELIMINAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, -1, -1));

        jButton4.setText("CANCELAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 200, -1, -1));

        jButton5.setText("SALIR");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 200, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 153, 153));

        jLabel9.setText("LISTADO DE PROVEEDORES");

        jLabel10.setText("BUSCAR");

        jtbprove.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "PROVEEDOR", "REPRESENTANTE", "GENERO", "DIRECCIÓN", "TIPO DOCUMENTO", "NÚMERO", "REGISTRO SANITARIO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jtbprove);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 827, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(275, 275, 275)
                        .addComponent(jLabel9)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(txtbusca)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtbusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 245, 847, 280));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtProveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProveActionPerformed

    private void txtapellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtapellActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtapellActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        crear();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        editar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        eliminar();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    Cancelar();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(Proveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Proveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Proveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Proveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Proveedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> jcbgen;
    private javax.swing.JComboBox<String> jcbtipdoc;
    private javax.swing.JTable jtbprove;
    private javax.swing.JTextField txtProve;
    private javax.swing.JTextField txtapell;
    private javax.swing.JTextField txtbusca;
    private javax.swing.JTextField txtdirec;
    private javax.swing.JTextField txtnomb;
    private javax.swing.JTextField txtnumero;
    private javax.swing.JTextField txtrs;
    // End of variables declaration//GEN-END:variables
}
