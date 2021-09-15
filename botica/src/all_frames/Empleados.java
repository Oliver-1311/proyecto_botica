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
public class Empleados extends javax.swing.JFrame {

    Controlador contr = new Controlador();
    DefaultTableModel md2 = new DefaultTableModel();
    String idEmpleado="";
    public Empleados() {
        initComponents();
        md2.setColumnIdentifiers(new String[]{"id", "Empleado", "Género", "Dirección", "Tipo documento", "NÚMERO", "TIPO EMPLEADO", "USUARIO", "CONTRASEÑA", "FECHA"});
//        buscar();
        jtemple.setModel(md2);
        contr.LlenarJTabla(md2, "select idempleado,concat_ws(' ', i.nom, i.ape) EMPLEADO,gen, dir,nomTipDoc, numIden, tipo, nom_user, psw, fech_contrato\n"
                + "from empleado e inner join identificaciong i on i.identificacion=e.identificacion\n"
                + "inner join tipempleado t on t.idtipEmpleado=e.idtipEmpleado\n"
                + "inner join tipodoc d on d.idtipoDoc=i.idtipoDoc\n"
                + "order by e.idempleado;", 10);
    }
    public void crear(){
     if(txtnombres.getText().trim().length()==0 || txtapell.getText().trim().length()==0 || txtnum.getText().trim().length()==0||txtdir.getText().trim().length()==0||
        jcbgen.getSelectedIndex()<0||txtuser.getText().trim().length()==0 ||jcbtipodoc.getSelectedIndex()<0||jcbtipo.getSelectedIndex()<0 ||txtpsw.getText().trim().length()==0||
        txtfecha.getText().trim().length()==0){
         JOptionPane.showMessageDialog(null,"campos vacios , por favor complete todos los datos");
     }
     else{
                // como obtener el mensaje.
         JOptionPane.showMessageDialog(null, contr.DevolverRegistroDto("call Crud_empleado(1, '" + txtuser.getText() + "', '"
                 + txtpsw.getText() + "', '" +txtfecha.getText() + "', '"+ jcbtipo.getSelectedItem().toString() + "', '" + jcbtipodoc.getSelectedItem().toString() + "', '" + txtnum.getText()
                 + "', '" +txtnombres.getText() + "', '"+ txtapell.getText() + "', '" + jcbgen.getSelectedItem().toString() + "', '" + txtdir.getText() + "', 1);", 1));
               buscar(); 
     }
    }
public void editar(){
         ///limpiar();
         if(jtemple.getSelectedRow()>=0){
             //llenar();
          if(txtnombres.getText().trim().length()==0 || txtapell.getText().trim().length()==0 || txtnum.getText().trim().length()==0||txtdir.getText().trim().length()==0||
        jcbgen.getSelectedIndex()<0||txtuser.getText().trim().length()==0 ||jcbtipodoc.getSelectedIndex()<0||jcbtipo.getSelectedIndex()<0 ||txtpsw.getText().trim().length()==0||
        txtfecha.getText().trim().length()==0 ){
         JOptionPane.showMessageDialog(null,"campos vacios , por favor complete todos los datos");}
          else{
               JOptionPane.showMessageDialog(null,contr.DevolverRegistroDto("call Crud_empleado('"+idEmpleado+"', '"+txtuser.getText() + "', '"
                 +txtpsw.getText() + "', '" +txtfecha.getText() + "', '"+ jcbtipo.getSelectedItem().toString() + "', '" + jcbtipodoc.getSelectedItem().toString() + "', '" + txtnum.getText()
                 + "', '" +txtnombres.getText() + "', '"+ txtapell.getText() + "', '" + jcbgen.getSelectedItem().toString() + "', '" + txtdir.getText() + "', 2);",1));
               
               Cancelar();
               txtnombres.grabFocus();
               
          }
         }
         else{
          JOptionPane.showMessageDialog(null,"Seleccionar primero el elemento");jtemple.grabFocus();
         }
       }
public void eliminar(){
      if(jtemple.getSelectedRow()>-1){
          if(JOptionPane.showConfirmDialog(null,"Esta seguro de Eliminar \n el registro del Empleado: "
           +jtemple.getValueAt(jtemple.getSelectedRow(),2).toString(),"Confirmar",0)==0){
              
           if(contr.Verificarconsulta("SELECT * FROM empleados e "
                   + "where e.idempleador="+idEmpleado+";")){
               
            JOptionPane.showMessageDialog(null,"el Proveedor "+jtemple.getValueAt(jtemple.getSelectedRow(),2).toString()
            + " No se debe eliminar  ");
            jtemple.clearSelection();
           }   
           else{
            JOptionPane.showMessageDialog(null,contr.DevolverRegistroDto("call Crud_empleado('"+idEmpleado+"', '"+txtuser.getText() + "', '"
                 +txtpsw.getText() + "', '" +txtfecha.getText() + "', '"+ jcbtipo.getSelectedItem().toString() + "', '" + jcbtipodoc.getSelectedItem().toString() + "', '" + txtnum.getText()
                 + "', '" +txtnombres.getText() + "', '"+ txtapell.getText() + "', '" + jcbgen.getSelectedItem().toString() + "', '" + txtdir.getText()+
                 "', 3);",1));
            
            Cancelar();
            txtnombres.grabFocus();
           }
          }
          else{jtemple.clearSelection();}
         }   
         else{
          JOptionPane.showMessageDialog(null,"Primero Selecciona al Empleado");
          jtemple.grabFocus();  
         }
     }
public void Cancelar(){
        txtbusca.setText(null);
        txtnombres.grabFocus();idEmpleado="";
        txtapell.setText(null);
        txtuser.setText(null);
        txtpsw.setText(null);
        txtdir.setText(null);
        txtnum.setText(null);
        txtfecha.setText(null);
        jcbgen.setSelectedIndex(-1);
        jcbtipodoc.setSelectedIndex(-1);
        jcbtipo.setSelectedIndex(-1);
        buscar();
    }
public void buscar(){
     contr.LlenarJTabla(md2,"select idempleado,concat_ws(' ', i.nom, i.ape) EMPLEADO,gen, dir,nomTipDoc, numIden, tipo, nom_user, psw, fech_contrato\n" +
"from empleado e inner join identificaciong i on i.identificacion=e.identificacion\n" +
"inner join tipempleado t on t.idtipEmpleado=e.idtipEmpleado\n" +
"inner join tipodoc d on d.idtipoDoc=i.idtipoDoc WHERE concat_ws(' ',nom,ape) LIKE '%"+txtbusca.getText()+"%' order by e.idempleado ;",10);
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtnombres = new javax.swing.JTextField();
        txtapell = new javax.swing.JTextField();
        jcbgen = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jcbtipodoc = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtnum = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtdir = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jcbtipo = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtuser = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtpsw = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtfecha = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtbusca = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtemple = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));

        jLabel1.setText("DATOS DE LOS EMPLEADOS");

        jLabel2.setText("NOMBRES");

        jLabel3.setText("APELLIDOS");

        jLabel4.setText("GÉNERO");

        jcbgen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino" }));
        jcbgen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbgenActionPerformed(evt);
            }
        });

        jLabel5.setText("TIPO DOCUMENTO");

        jcbtipodoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DNI", "CARNET DE EXTRANJERÍA", "RUC" }));
        jcbtipodoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbtipodocActionPerformed(evt);
            }
        });

        jLabel6.setText("NÚMERO");

        jLabel7.setText("DIRECCIÓN");

        jLabel8.setText("TIPO DE EMPLEADO");

        jcbtipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Vendedor" }));

        jLabel9.setText("USUARIO");

        jLabel10.setText("PASSWORD");

        jLabel11.setText("FECHA DE CREACION");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(350, 350, 350))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(txtuser, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(txtpsw, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 41, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtdir)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtnombres)
                            .addComponent(jcbtipodoc, 0, 155, Short.MAX_VALUE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtapell)
                            .addComponent(txtnum, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jcbtipo, 0, 118, Short.MAX_VALUE)
                            .addComponent(jcbgen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(47, 47, 47))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(txtnombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtapell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jcbgen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jcbtipodoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtnum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbtipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtdir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtuser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtpsw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setText("CREAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("EDITAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("ELIMINAR");

        jButton4.setText("CANCELAR");

        jButton5.setText("SALIR");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 153, 153));

        jLabel12.setText("LISTADO DE EMPLEADOS");

        jLabel13.setText("BUSCAR:");

        txtbusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscaActionPerformed(evt);
            }
        });

        jtemple.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "TIPO DE DOCUMENTO", "NUMERO", "NOMBRES Y APELLIDOS", "GÉNERO", "DIRECCIÓN", "FFECHA CONTRATO", "TIPO EMPLEADO", "USUARIO", "CONTRASEÑA"
            }
        ));
        jScrollPane1.setViewportView(jtemple);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(305, 305, 305)
                        .addComponent(jLabel12)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtbusca)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtbusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(85, 85, 85)
                .addComponent(jButton2)
                .addGap(84, 84, 84)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(92, 92, 92)
                .addComponent(jButton5)
                .addGap(23, 23, 23))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jcbtipodocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbtipodocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbtipodocActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtbuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscaActionPerformed

    private void jcbgenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbgenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbgenActionPerformed

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
            java.util.logging.Logger.getLogger(Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Empleados().setVisible(true);
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
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JComboBox<String> jcbgen;
    private javax.swing.JComboBox<String> jcbtipo;
    private javax.swing.JComboBox<String> jcbtipodoc;
    private javax.swing.JTable jtemple;
    private javax.swing.JTextField txtapell;
    private javax.swing.JTextField txtbusca;
    private javax.swing.JTextField txtdir;
    private javax.swing.JFormattedTextField txtfecha;
    private javax.swing.JTextField txtnombres;
    private javax.swing.JTextField txtnum;
    private javax.swing.JTextField txtpsw;
    private javax.swing.JTextField txtuser;
    // End of variables declaration//GEN-END:variables
}
