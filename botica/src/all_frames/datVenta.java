/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package all_frames;

import Clases.Controlador;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class datVenta extends javax.swing.JFrame {

    Controlador contr = new Controlador();
    DefaultTableModel mdl = new DefaultTableModel();
    String idVenta = "";

    public datVenta() {
        initComponents();
        mdl.setColumnIdentifiers(new String[]{"id", "Medicamento", "Cantidad", "Costo unitario", "Vendedor", "Cliente"});
        jtadetven.setModel(mdl);
        contr.LlenarJTabla(mdl, "select iddetallVenta, NOMBRE, cantVen, precioUm, nom_user,concat_ws(' ', nom, ape) Cliente\n"
                + "from detallventa dv inner join venta v on v.idventa=dv.idventa\n"
                + "inner join empleado e on e.idempleado=dv.idempleado inner join\n"
                + "cliente c on c.idcliente=dv.idcliente inner join identificaciong i on\n"
                + "i.identificacion=c.identificacion inner join medicamentoxventa mv on v.idventa=mv.idventa\n"
                + "inner join medicamento m on m.idmedicamento=mv.idmedicamento ", 6);
        contr.LlenarCombo(jcbmedi, "select  NOMBRE\n"
                + "from medicamento m ", 1);
        contr.LlenarCombo(jcbcliente, "select concat_ws(' ', nom, ape) Cliente\n"
                + "from cliente c inner join identificaciong i on i.identificacion=c.identificacion; ", 1);
        contr.LlenarCombo(jcbvendedor, "select  nom_user\n"
                + "from empleado e inner join tipempleado t on t.idtipEmpleado=e.idtipEmpleado\n"
                + "where e.idtipEmpleado='2'; ", 1);
    }

    public void crear() {
        if (jcbmedi.getSelectedIndex() < 0 || txtcantida.getText().trim().length() == 0 || txtcosto.getText().trim().length() == 0 || jcbvendedor.getSelectedIndex() < 0
                || jcbcliente.getSelectedIndex() < 0) {
            JOptionPane.showMessageDialog(null, "campos vacios , por favor complete todos los datos");
        } else {
            // como obtener el mensaje.
            JOptionPane.showMessageDialog(null, contr.DevolverRegistroDto("call crud_detventa(1, '" + jcbmedi.getSelectedItem().toString() + "', '"
                    + txtcantida.getText() + "', '" + jcbcliente.getSelectedItem().toString() + "', '" + txtcosto.getText() + "', '"
                    + "', '" + jcbvendedor.getSelectedItem().toString() + "', '" + "', 1);", 1));
        }
    }

    public void editar() {
        ///limpiar();
        if (jtadetven.getSelectedRow() >= 0) {
//             llenar();
            if (jcbmedi.getSelectedIndex() < 0 || txtcantida.getText().trim().length() == 0 || txtcosto.getText().trim().length() == 0 || jcbvendedor.getSelectedIndex() < 0
                    || jcbcliente.getSelectedIndex() < 0) {
                JOptionPane.showMessageDialog(null, "campos vacios , por favor complete todos los datos");
            } else {
                JOptionPane.showMessageDialog(null, contr.DevolverRegistroDto("call crud_detventa('" + idVenta + "', '" + jcbmedi.getSelectedItem().toString() + "', '"
                        + txtcantida.getText() + "', '" + jcbcliente.getSelectedItem().toString() + "', '" + txtcosto.getText() + "', '"
                        + "', '" + jcbvendedor.getSelectedItem().toString() + "', '" + "', 2);", 1));
//               Cancelar();
                txtcantida.grabFocus();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccionar primero el elemento");
            jtadetven.grabFocus();
        }
    }

    public void Cancelar() {
        txtcantida.setText(null);
        txtcantida.grabFocus();
        idVenta = "";
        txtcosto.setText(null);
        jcbmedi.setSelectedIndex(-1);
        jcbcliente.setSelectedIndex(-1);
        jcbvendedor.setSelectedIndex(-1);
    }
    public void eliminar(){
      if(jtadetven.getSelectedRow()>-1){
          if(JOptionPane.showConfirmDialog(null,"Esta seguro de Eliminar \n el registro del detalle venta: "
           +jtadetven.getValueAt(jtadetven.getSelectedRow(),2).toString(),"Confirmar",0)==0){
              
           if(contr.Verificarconsulta("SELECT * FROM detalleventa  "
                   + "where e.idempleado="+idVenta+";")){
               
            JOptionPane.showMessageDialog(null,"el detalle venta "+jtadetven.getValueAt(jtadetven.getSelectedRow(),2).toString()
            + " No se debe eliminar  ");
            jtadetven.clearSelection();
           }   
           else{
            JOptionPane.showMessageDialog(null,contr.DevolverRegistroDto("call crud_detventa('"+idVenta+"', '"+jcbmedi.getSelectedItem().toString() + "', '"
                        + txtcantida.getText() + "', '" + jcbcliente.getSelectedItem().toString() + "', '" + txtcosto.getText() + "', '"
                        + "', '" + jcbvendedor.getSelectedItem().toString() + "', '" + "', 3);",1));
            
            Cancelar();
            txtcantida.grabFocus();
           }
          }
          else{jtadetven.clearSelection();}
         }   
         else{
          JOptionPane.showMessageDialog(null,"Primero Selecciona el detalle venta");
          jtadetven.grabFocus();  
         }
     }
    public void llenar() {
        idVenta = jtadetven.getModel().getValueAt(jtadetven.getSelectedRow(), 0).toString();
        txtcantida.setText(jtadetven.getModel().getValueAt(jtadetven.getSelectedRow(), 2).toString());
        txtcosto.setText(jtadetven.getModel().getValueAt(jtadetven.getSelectedRow(), 3).toString());
        jcbmedi.setSelectedItem(jtadetven.getModel().getValueAt(jtadetven.getSelectedRow(), 1));
        jcbcliente.setSelectedItem(jtadetven.getModel().getValueAt(jtadetven.getSelectedRow(), 5));
        jcbvendedor.setSelectedItem(jtadetven.getModel().getValueAt(jtadetven.getSelectedRow(), 4));
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jtadetven = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jcbcliente = new javax.swing.JComboBox<>();
        jcbvendedor = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jcbmedi = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtcantida = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtcosto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));

        jtadetven.setModel(new javax.swing.table.DefaultTableModel(
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
        jtadetven.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtadetvenMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtadetven);

        jButton6.setText("ver comprobante de pago");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(280, 280, 280)
                .addComponent(jButton6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(153, 255, 255));

        jLabel1.setText("DETELLE DE VENTAS");

        jLabel2.setText("cliente:");

        jLabel3.setText("vendedor:");

        jcbcliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jcbvendedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(28, 28, 28)
                        .addComponent(jcbcliente, 0, 209, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbvendedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcbcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jcbvendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setText("medicamento:");

        jcbmedi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Cantidad:");

        jLabel6.setText("Costo unitario:");

        jLabel7.setText("FECHA DE VENTA:");

        jLabel8.setText("HORA DE VENTA:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcantida)
                            .addComponent(txtcosto)
                            .addComponent(jcbmedi, 0, 296, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(91, 91, 91)))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(288, 288, 288)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jcbmedi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtcantida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtcosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))))
                .addContainerGap())
        );

        jButton1.setText("crear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("editar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("cancelar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("salir");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addGap(59, 59, 59)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       crear();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       editar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        eliminar();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Cancelar();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jtadetvenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtadetvenMouseClicked
        llenar();
    }//GEN-LAST:event_jtadetvenMouseClicked

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
            java.util.logging.Logger.getLogger(datVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(datVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(datVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(datVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new datVenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbcliente;
    private javax.swing.JComboBox<String> jcbmedi;
    private javax.swing.JComboBox<String> jcbvendedor;
    private javax.swing.JTable jtadetven;
    private javax.swing.JTextField txtcantida;
    private javax.swing.JTextField txtcosto;
    // End of variables declaration//GEN-END:variables
}
