/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import Panels_admin.*;
import Clases.Controlador;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

/**
 *
 * @author oli
 */
public class main_admin extends javax.swing.JFrame {
    Controlador cntrl=new Controlador();
        p_home home = new p_home();
        p_Usuario usuario = new p_Usuario();
        p_Proveedores proveedor = new p_Proveedores();
        p_Medicamentos medicamento = new p_Medicamentos();
        p_Compra compra = new p_Compra();
        p_Reportes reporte = new p_Reportes();
        //p_Compras compras=new p_Compras();
    /**
     * Creates new form main_admin
     */
    public main_admin() {
        this.setTitle("Menú de Administrador");
        this.setExtendedState(Frame.MAXIMIZED_BOTH);
        initComponents();
        settingsPanels();
        //home.jLabel3.setText(jLabel1.getText());
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
        header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        p_principal = new javax.swing.JPanel();
        footer = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        menu = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnHome = new java.awt.Label();
        btnUser = new java.awt.Label();
        jPanel6 = new javax.swing.JPanel();
        btnProovedores = new java.awt.Label();
        btnMedicamentis = new java.awt.Label();
        jPanel7 = new javax.swing.JPanel();
        btnVentas = new java.awt.Label();
        btnCompras = new java.awt.Label();
        jPanel8 = new javax.swing.JPanel();
        btnReportes = new java.awt.Label();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        header.setBackground(new java.awt.Color(0, 109, 179));

        jLabel1.setText("jLabel1");
        header.add(jLabel1);

        jPanel1.add(header, java.awt.BorderLayout.PAGE_START);

        p_principal.setLayout(new java.awt.BorderLayout());
        jPanel1.add(p_principal, java.awt.BorderLayout.CENTER);

        footer.setBackground(new java.awt.Color(0, 109, 179));
        footer.setForeground(new java.awt.Color(0, 153, 255));

        jLabel3.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel3.setText("Sistema Botica V 1.0");
        footer.add(jLabel3);

        jPanel1.add(footer, java.awt.BorderLayout.PAGE_END);

        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(153, 153, 153)));
        jPanel2.setLayout(new java.awt.BorderLayout());

        menu.setBackground(new java.awt.Color(245, 245, 245));
        menu.setForeground(new java.awt.Color(0, 153, 204));
        menu.setLayout(new java.awt.GridLayout(6, 0));

        jLabel2.setText("                                                    ");
        menu.add(jLabel2);

        jPanel5.setBackground(new java.awt.Color(0, 153, 204));
        jPanel5.setLayout(new java.awt.GridLayout(2, 0));

        btnHome.setBackground(new java.awt.Color(245, 245, 245));
        btnHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHome.setFont(new java.awt.Font("Geneva", 1, 16)); // NOI18N
        btnHome.setForeground(new java.awt.Color(102, 102, 102));
        btnHome.setText("Home");
        btnHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHomeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHomeMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnHomeMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnHomeMouseReleased(evt);
            }
        });
        jPanel5.add(btnHome);

        btnUser.setBackground(new java.awt.Color(245, 245, 245));
        btnUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUser.setFont(new java.awt.Font("Geneva", 1, 16)); // NOI18N
        btnUser.setForeground(new java.awt.Color(102, 102, 102));
        btnUser.setText("Usuarios");
        btnUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUserMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUserMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUserMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnUserMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnUserMouseReleased(evt);
            }
        });
        jPanel5.add(btnUser);

        menu.add(jPanel5);

        jPanel6.setLayout(new java.awt.GridLayout(2, 0));

        btnProovedores.setBackground(new java.awt.Color(245, 245, 245));
        btnProovedores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProovedores.setFont(new java.awt.Font("Geneva", 1, 16)); // NOI18N
        btnProovedores.setForeground(new java.awt.Color(102, 102, 102));
        btnProovedores.setText("Proovedores");
        btnProovedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProovedoresMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnProovedoresMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnProovedoresMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnProovedoresMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnProovedoresMouseReleased(evt);
            }
        });
        jPanel6.add(btnProovedores);

        btnMedicamentis.setBackground(new java.awt.Color(245, 245, 245));
        btnMedicamentis.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMedicamentis.setFont(new java.awt.Font("Geneva", 1, 16)); // NOI18N
        btnMedicamentis.setForeground(new java.awt.Color(102, 102, 102));
        btnMedicamentis.setText("Medicamentos");
        btnMedicamentis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMedicamentisMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMedicamentisMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMedicamentisMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnMedicamentisMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnMedicamentisMouseReleased(evt);
            }
        });
        jPanel6.add(btnMedicamentis);

        menu.add(jPanel6);

        jPanel7.setLayout(new java.awt.GridLayout(2, 0));

        btnVentas.setBackground(new java.awt.Color(245, 245, 245));
        btnVentas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVentas.setFont(new java.awt.Font("Geneva", 1, 16)); // NOI18N
        btnVentas.setForeground(new java.awt.Color(102, 102, 102));
        btnVentas.setText("Ventas");
        btnVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVentasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnVentasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnVentasMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnVentasMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnVentasMouseReleased(evt);
            }
        });
        jPanel7.add(btnVentas);

        btnCompras.setBackground(new java.awt.Color(245, 245, 245));
        btnCompras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCompras.setFont(new java.awt.Font("Geneva", 1, 16)); // NOI18N
        btnCompras.setForeground(new java.awt.Color(102, 102, 102));
        btnCompras.setText("Compras");
        btnCompras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnComprasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnComprasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnComprasMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnComprasMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnComprasMouseReleased(evt);
            }
        });
        jPanel7.add(btnCompras);

        menu.add(jPanel7);

        jPanel8.setBackground(new java.awt.Color(245, 245, 245));
        jPanel8.setLayout(new java.awt.GridLayout(2, 0));

        btnReportes.setBackground(new java.awt.Color(245, 245, 245));
        btnReportes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReportes.setFont(new java.awt.Font("Geneva", 1, 16)); // NOI18N
        btnReportes.setForeground(new java.awt.Color(102, 102, 102));
        btnReportes.setText("Reportes");
        btnReportes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReportesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnReportesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnReportesMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnReportesMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnReportesMouseReleased(evt);
            }
        });
        jPanel8.add(btnReportes);

        menu.add(jPanel8);

        jLabel4.setText(" ");
        menu.add(jLabel4);

        jPanel2.add(menu, java.awt.BorderLayout.CENTER);

        jPanel3.setBackground(new java.awt.Color(245, 245, 245));
        jPanel3.setLayout(new java.awt.GridLayout(6, 0));

        jLabel5.setText(" ");
        jPanel3.add(jLabel5);

        jPanel4.setBackground(new java.awt.Color(245, 245, 245));
        jPanel4.setLayout(new java.awt.GridLayout(2, 0));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/home-regular-24.png"))); // NOI18N
        jLabel7.setText(" ");
        jPanel4.add(jLabel7);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/user-regular-24.png"))); // NOI18N
        jLabel8.setText(" ");
        jPanel4.add(jLabel8);

        jPanel3.add(jPanel4);

        jPanel9.setBackground(new java.awt.Color(245, 245, 245));
        jPanel9.setLayout(new java.awt.GridLayout(2, 0));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/id-card-regular-24.png"))); // NOI18N
        jLabel9.setText(" ");
        jPanel9.add(jLabel9);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/plus-medical-regular-24.png"))); // NOI18N
        jLabel10.setText(" ");
        jPanel9.add(jLabel10);

        jPanel3.add(jPanel9);

        jPanel10.setBackground(new java.awt.Color(245, 245, 245));
        jPanel10.setLayout(new java.awt.GridLayout(2, 0));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/cart-regular-24.png"))); // NOI18N
        jLabel11.setText(" ");
        jPanel10.add(jLabel11);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/cart-add-solid-24.png"))); // NOI18N
        jLabel12.setText(" ");
        jPanel10.add(jLabel12);

        jPanel3.add(jPanel10);

        jPanel11.setBackground(new java.awt.Color(245, 245, 245));
        jPanel11.setLayout(new java.awt.GridLayout(2, 0));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/notepad-regular-24.png"))); // NOI18N
        jLabel13.setText(" ");
        jPanel11.add(jLabel13);

        jPanel3.add(jPanel11);

        jLabel6.setText("jLabel6");
        jPanel3.add(jLabel6);

        jPanel2.add(jPanel3, java.awt.BorderLayout.LINE_START);

        jScrollPane1.setViewportView(jPanel2);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.LINE_START);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseEntered
        btnHome.setBackground(new Color(200,200,200));
    }//GEN-LAST:event_btnHomeMouseEntered

    private void btnHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseExited
        btnHome.setBackground(new Color(245,245,245));
    }//GEN-LAST:event_btnHomeMouseExited

    private void btnUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUserMouseEntered
        btnUser.setBackground(new Color(200,200,200));
    }//GEN-LAST:event_btnUserMouseEntered

    private void btnProovedoresMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProovedoresMouseEntered
        btnProovedores.setBackground(new Color(200,200,200));
    }//GEN-LAST:event_btnProovedoresMouseEntered

    private void btnMedicamentisMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMedicamentisMouseEntered
        btnMedicamentis.setBackground(new Color(200,200,200));
    }//GEN-LAST:event_btnMedicamentisMouseEntered

    private void btnVentasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVentasMouseEntered
       btnVentas.setBackground(new Color(175,175,175));
    }//GEN-LAST:event_btnVentasMouseEntered

    private void btnComprasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnComprasMouseEntered
        btnCompras.setBackground(new Color(200,200,200));
    }//GEN-LAST:event_btnComprasMouseEntered

    private void btnReportesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportesMouseEntered
        btnReportes.setBackground(new Color(200,200,200));
    }//GEN-LAST:event_btnReportesMouseEntered

    private void btnUserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUserMouseExited
        btnUser.setBackground(new Color(245,245,245));
    }//GEN-LAST:event_btnUserMouseExited

    private void btnProovedoresMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProovedoresMouseExited
        btnProovedores.setBackground(new Color(245,245,245));
    }//GEN-LAST:event_btnProovedoresMouseExited

    private void btnMedicamentisMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMedicamentisMouseExited
        btnMedicamentis.setBackground(new Color(245,245,245));
    }//GEN-LAST:event_btnMedicamentisMouseExited

    private void btnVentasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVentasMouseExited
        btnVentas.setBackground(new Color(245,245,245));
    }//GEN-LAST:event_btnVentasMouseExited

    private void btnComprasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnComprasMouseExited
        btnCompras.setBackground(new Color(245,245,245));
    }//GEN-LAST:event_btnComprasMouseExited

    private void btnReportesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportesMouseExited
        btnReportes.setBackground(new Color(245,245,245));
    }//GEN-LAST:event_btnReportesMouseExited

    private void btnHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseClicked
       
        
    }//GEN-LAST:event_btnHomeMouseClicked

    private void btnComprasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnComprasMouseClicked
        //home.setVisible(false);
        //compras.setVisible(true);
        //p_principal.add(compras);
       // p_principal.validate();
    }//GEN-LAST:event_btnComprasMouseClicked

    private void btnHomeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHomeMousePressed

    private void btnUserMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUserMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUserMousePressed

    private void btnProovedoresMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProovedoresMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProovedoresMousePressed

    private void btnMedicamentisMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMedicamentisMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMedicamentisMousePressed

    private void btnVentasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVentasMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVentasMousePressed

    private void btnComprasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnComprasMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnComprasMousePressed

    private void btnReportesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportesMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReportesMousePressed

    private void btnHomeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseReleased
        
        proveedor.setVisible(false);
        medicamento.setVisible(false);
        compra.setVisible(false);
        reporte.setVisible(false);
        usuario.setVisible(false);
        home.setVisible(true);
        home.jPanel2.setVisible(true);
        p_principal.add(home);
        p_principal.validate();
    }//GEN-LAST:event_btnHomeMouseReleased

    private void btnUserMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUserMouseReleased
        home.setVisible(false);
        proveedor.setVisible(false);
        medicamento.setVisible(false);
        compra.setVisible(false);
        reporte.setVisible(false);
        usuario.setVisible(true);
        p_principal.add(usuario);
        p_principal.validate();
    }//GEN-LAST:event_btnUserMouseReleased

    private void btnProovedoresMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProovedoresMouseReleased
          
        home.setVisible(false);
        medicamento.setVisible(false);
        compra.setVisible(false);
        reporte.setVisible(false);
        usuario.setVisible(false);
         proveedor.setVisible(true);
     
        p_principal.add(proveedor);
        p_principal.validate();
    }//GEN-LAST:event_btnProovedoresMouseReleased

    private void btnMedicamentisMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMedicamentisMouseReleased
        home.setVisible(false);
        compra.setVisible(false);
        reporte.setVisible(false);
        usuario.setVisible(false);
        proveedor.setVisible(false);
        medicamento.setVisible(true);
     
        p_principal.add(medicamento);
        p_principal.validate();
    }//GEN-LAST:event_btnMedicamentisMouseReleased

    private void btnVentasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVentasMouseReleased
        compra.setVisible(false);
        reporte.setVisible(false);
        usuario.setVisible(false);
        proveedor.setVisible(false);
        medicamento.setVisible(false);
        home.setVisible(true);
        home.jPanel2.setVisible(false);
        p_principal.add(home);
        p_principal.validate();
    }//GEN-LAST:event_btnVentasMouseReleased

    private void btnComprasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnComprasMouseReleased
        reporte.setVisible(false);
        usuario.setVisible(false);
        proveedor.setVisible(false);
        medicamento.setVisible(false);
        home.setVisible(false);
        compra.setVisible(true);
       
        p_principal.add(compra);
        p_principal.validate();
    }//GEN-LAST:event_btnComprasMouseReleased

    private void btnReportesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportesMouseReleased
        usuario.setVisible(false);
        proveedor.setVisible(false);
        medicamento.setVisible(false);
        home.setVisible(false);
        compra.setVisible(false);
       reporte.setVisible(true);
        p_principal.add(reporte);
        p_principal.validate();
    }//GEN-LAST:event_btnReportesMouseReleased

    private void btnUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUserMouseClicked
        
    }//GEN-LAST:event_btnUserMouseClicked

    private void btnProovedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProovedoresMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProovedoresMouseClicked

    private void btnMedicamentisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMedicamentisMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMedicamentisMouseClicked

    private void btnVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVentasMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVentasMouseClicked

    private void btnReportesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReportesMouseClicked

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
            java.util.logging.Logger.getLogger(main_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main_admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Label btnCompras;
    private java.awt.Label btnHome;
    private java.awt.Label btnMedicamentis;
    private java.awt.Label btnProovedores;
    private java.awt.Label btnReportes;
    private java.awt.Label btnUser;
    private java.awt.Label btnVentas;
    private javax.swing.JPanel footer;
    private javax.swing.JPanel header;
    public javax.swing.JLabel jLabel1;
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
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel menu;
    private javax.swing.JPanel p_principal;
    // End of variables declaration//GEN-END:variables

    private void settingsPanels() {
        p_principal.add(home);
        jLabel3.setForeground(new Color(220,220,220));
      
    }
   
}
