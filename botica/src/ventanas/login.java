/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import Panels_admin.p_home;
import Clases.Controlador;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;

/**
 *
 * @author oliver
 */
public class login extends javax.swing.JFrame {
    private p_home ph;
    Controlador cntrl= new Controlador();
   int x,y;   private ActionListener la;
   private Timer t;

    ResultSet rs;Statement  st;
    public login() {
        initComponents();inicio();icono();
        ajustarImagen("src/IMG/user.png", imgUser);
        ajustarImagen("src/IMG/close.png", lblClose);
    }

    public  void inicio(){
        this.setResizable(false);this.setLocationRelativeTo(null); 
      txtpas.setEchoChar('*');
//        holder=new PlaceHolder(txtusuario,"Ingrese su Usuario");txtusuario.setForeground(Color.white);
//        holder=new PlaceHolder(txtpas,"Ingrese su Contraseña"); 
    
    }
        public void ajustarImagen(String ruta, JLabel lbl){
        ImageIcon imagen = new ImageIcon(ruta);
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_DEFAULT));
        lbl.setIcon(icono);
        this.repaint();
    }
        public void iniciarSesion(){
             if(txtusuario.getText().trim().length()==0 ){
            JOptionPane.showMessageDialog(null,"Ingrese su Usuario ","Advertencia del sistema ",JOptionPane.WARNING_MESSAGE);
        }else{
            if(txtpas.getText().trim().length()==0){
                JOptionPane.showMessageDialog(null,"Ingrese su Contraseña ","Advertencia del sistema ",JOptionPane.WARNING_MESSAGE);
            }else{
                if(cntrl.Verificarconsulta("select *from empleado \n" +
                "where (nom_user='"+txtusuario.getText().trim()+"') and psw='"+txtpas.getText().trim()+"'")){
                    dispose();
                    main_admin main=new main_admin();
                    
                    main.jLabel1.setText(""+cntrl.DevolverRegistroDto("select * from empleado\n" +
"                   where (nom_user='"+txtusuario.getText().trim()+"')", 2));   
                    main.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Los datos Ingresados son incorrectos, por favor intente nuevamente", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
               
                
            }
        }
        }
     
    class FondoPanel extends JPanel{
    private Image imagen;
    @Override
    public void paint(Graphics g){
        imagen = new ImageIcon(getClass().getResource("/IMG/fondook.jpg")).getImage();
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        
        setOpaque(false);
        super.paint(g);
        }
    }
    class PanelOperando extends JPanel{
    private Image imagen;
    @Override
    public void paint(Graphics g){
        imagen = new ImageIcon(getClass().getResource("/IMG/vacunando.png")).getImage();
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        
        setOpaque(false);
        super.paint(g);
        }
    }
     public void icono(){
       setIconImage(new ImageIcon(getClass().getResource("/IMG/usuarioiniciarsecion.png")).getImage());
   }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        progreso = new javax.swing.JProgressBar();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtusuario = new javax.swing.JTextField();
        txtpas = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        lblClose = new javax.swing.JLabel();
        labelerror = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        mostrarcontraseña = new javax.swing.JCheckBox();
        btnEntrar = new java.awt.Label();
        imgUser = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel7 = new FondoPanel();
        labelhora = new javax.swing.JLabel();
        jPanel8 = new PanelOperando();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 505, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 507, Short.MAX_VALUE)
        );

        progreso.setForeground(new java.awt.Color(52, 8, 230));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel5MouseDragged(evt);
            }
        });
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel5MousePressed(evt);
            }
        });
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel6MouseDragged(evt);
            }
        });
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel6MousePressed(evt);
            }
        });
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(108, 141, 196));
        jLabel3.setText("USUARIO ");
        jPanel6.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 161, 53));

        jLabel2.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(108, 141, 196));
        jLabel2.setText("CONTRASEÑA ");
        jPanel6.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, -1, 52));

        txtusuario.setBackground(new java.awt.Color(255, 255, 255));
        txtusuario.setFont(new java.awt.Font("Geneva", 0, 16)); // NOI18N
        txtusuario.setForeground(new java.awt.Color(102, 102, 102));
        txtusuario.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtusuario.setBorder(null);
        txtusuario.setCaretColor(new java.awt.Color(0, 0, 0));
        txtusuario.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtusuario.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txtusuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtusuarioMouseClicked(evt);
            }
        });
        txtusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusuarioActionPerformed(evt);
            }
        });
        txtusuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtusuarioKeyPressed(evt);
            }
        });
        jPanel6.add(txtusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 190, 30));

        txtpas.setBackground(new java.awt.Color(255, 255, 255));
        txtpas.setFont(new java.awt.Font("Geneva", 0, 16)); // NOI18N
        txtpas.setForeground(new java.awt.Color(102, 102, 102));
        txtpas.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtpas.setBorder(null);
        txtpas.setCaretColor(new java.awt.Color(0, 0, 0));
        txtpas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtpasMouseClicked(evt);
            }
        });
        txtpas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpasKeyPressed(evt);
            }
        });
        jPanel6.add(txtpas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 200, 30));
        jPanel6.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 200, 10));
        jPanel6.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 210, -1));

        lblClose.setFont(new java.awt.Font("Engravers MT", 1, 16)); // NOI18N
        lblClose.setForeground(new java.awt.Color(255, 51, 51));
        lblClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/sañirsistema.png"))); // NOI18N
        lblClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCloseMouseClicked(evt);
            }
        });
        jPanel6.add(lblClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 20, 20));

        labelerror.setFont(new java.awt.Font("Calisto MT", 1, 12)); // NOI18N
        labelerror.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel6.add(labelerror, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 353, 612, 21));

        jLabel4.setFont(new java.awt.Font("Engravers MT", 1, 9)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes1/recordar pasword.png"))); // NOI18N
        jLabel4.setText("¿Olvidaste tu Contraseña ?");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
        });
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, 260, -1));

        mostrarcontraseña.setBackground(new java.awt.Color(204, 204, 255));
        mostrarcontraseña.setFont(new java.awt.Font("Engravers MT", 1, 10)); // NOI18N
        mostrarcontraseña.setForeground(new java.awt.Color(51, 51, 51));
        mostrarcontraseña.setText("Mostrar Contraseña");
        mostrarcontraseña.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mostrarcontraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarcontraseñaActionPerformed(evt);
            }
        });
        jPanel6.add(mostrarcontraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, -1, -1));

        btnEntrar.setAlignment(java.awt.Label.CENTER);
        btnEntrar.setBackground(new java.awt.Color(108, 141, 196));
        btnEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEntrar.setFont(new java.awt.Font("Geneva", 0, 16)); // NOI18N
        btnEntrar.setForeground(new java.awt.Color(255, 255, 255));
        btnEntrar.setText("Ingresar");
        btnEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEntrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEntrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEntrarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnEntrarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnEntrarMouseReleased(evt);
            }
        });
        btnEntrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnEntrarKeyPressed(evt);
            }
        });
        jPanel6.add(btnEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 150, 30));

        imgUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/user.png"))); // NOI18N
        jPanel6.add(imgUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 210, 180));

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 0, 330, 620));

        jLabel6.setFont(new java.awt.Font("Engravers MT", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 255, 102));
        jLabel6.setText("-");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 0));

        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelhora.setFont(new java.awt.Font("Engravers MT", 1, 21)); // NOI18N
        labelhora.setForeground(new java.awt.Color(204, 204, 204));
        labelhora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelhora.setText(" ");
        jPanel7.add(labelhora, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 580, 286, 35));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );

        jPanel7.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 640, 420));

        jLabel1.setFont(new java.awt.Font("Georgia", 3, 60)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText(" San Juan");
        jPanel7.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 330, 60));

        jLabel5.setFont(new java.awt.Font("Georgia", 3, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Botíca");
        jPanel7.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 250, 40));

        jPanel5.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 620));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
     
    }//GEN-LAST:event_jPanel5MouseClicked

    private void jPanel5MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseDragged
        Point p = MouseInfo.getPointerInfo().getLocation();
        this.setLocation(p.x - x, p.y - y);         
    }//GEN-LAST:event_jPanel5MouseDragged

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked

    }//GEN-LAST:event_jPanel6MouseClicked

    private void jPanel6MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseDragged
         
    }//GEN-LAST:event_jPanel6MouseDragged
//public void iniciarsec(){
//     la=new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//            
//                 if(progreso.getValue()<100){
//                    progreso.setValue(progreso.getValue()+22);
//                    
//                }else{
//            
//                    
//                 t.stop();
//                    
////                  IniciarSecion(txtusuario.getText(),txtpas.getText());
//                }
//            }
//           
//        };
//        t=new Timer(200, la);
//        t.start();
//}
 
    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
      this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
    
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jPanel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jPanel5MousePressed

    private void jPanel6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MousePressed
        
    }//GEN-LAST:event_jPanel6MousePressed

    private void txtusuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtusuarioKeyPressed
   if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_ENTER){
       if(txtusuario.getText().trim().length()==0){
           txtusuario.grabFocus();
       }else{
           txtpas.grabFocus();
       }
   }        
    }//GEN-LAST:event_txtusuarioKeyPressed

    private void lblCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseClicked
  
    }//GEN-LAST:event_lblCloseMouseClicked

    private void mostrarcontraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarcontraseñaActionPerformed
       if(mostrarcontraseña.getText().equals("Mostrar Contraseña")){
          
        if(txtpas.getText().trim().length()>0){
            txtpas.setFont(new Font("Geneva",Font.PLAIN,16));
           txtpas.setEchoChar( (char)0 );
           mostrarcontraseña.setText("Ocultar Contraseña");
           mostrarcontraseña.setSelected(false);
            txtpas.grabFocus();
       }else{
            txtpas.grabFocus();
           JOptionPane.showMessageDialog(null,"Ingrese su Password","Mensage del sistema",JOptionPane.WARNING_MESSAGE);
             
          mostrarcontraseña.setSelected(false);
       }
       }else{
           if(mostrarcontraseña.getText().equals("Ocultar Contraseña")){
               txtpas.grabFocus();
              txtpas.setEchoChar(('*'));txtpas.setFont(new Font("Geneva",Font.PLAIN,16));
              
              mostrarcontraseña.setText("Mostrar Contraseña");
              mostrarcontraseña.setSelected(false);
                 txtpas.grabFocus();
           }
       }
    }//GEN-LAST:event_mostrarcontraseñaActionPerformed

    private void txtusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusuarioActionPerformed
      
    }//GEN-LAST:event_txtusuarioActionPerformed

    private void txtusuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtusuarioMouseClicked
 
    }//GEN-LAST:event_txtusuarioMouseClicked

    private void txtpasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtpasMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpasMouseClicked

    private void btnEntrarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntrarMouseReleased
        // TODO add your handling code here:
        btnEntrar.setSize(150, 30);
        btnEntrar.setFont(new Font("Geneva",Font.PLAIN,16));
        iniciarSesion();
       
       
    }//GEN-LAST:event_btnEntrarMouseReleased

    private void btnEntrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntrarMouseEntered
        // TODO add your handling code here:
        btnEntrar.setBackground(new Color(103,117,177));
        
    }//GEN-LAST:event_btnEntrarMouseEntered

    private void btnEntrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntrarMouseExited
        // TODO add your handling code here:
        btnEntrar.setBackground(new Color(108,141,196));
    }//GEN-LAST:event_btnEntrarMouseExited

    private void btnEntrarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntrarMousePressed
        // TODO add your handling code here:
        btnEntrar.setFont(new Font("Geneva",Font.BOLD,18));
        btnEntrar.setSize(153, 32);
    }//GEN-LAST:event_btnEntrarMousePressed

    private void btnEntrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntrarMouseClicked
         
        
    }//GEN-LAST:event_btnEntrarMouseClicked

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        //recuperarcontraseña cp=new recuperarcontraseña(this, rootPaneCheckingEnabled);cp.setVisible(true);
    }//GEN-LAST:event_jLabel4MouseEntered

    private void txtpasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpasKeyPressed
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_ENTER){
            iniciarSesion();
       }
    }//GEN-LAST:event_txtpasKeyPressed

    private void btnEntrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEntrarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEntrarKeyPressed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
             UIManager.setLookAndFeel("com.jgoodies.looks.plastic.PlasticLookAndFeel");
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Label btnEntrar;
    private javax.swing.JLabel imgUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelerror;
    private javax.swing.JLabel labelhora;
    private javax.swing.JLabel lblClose;
    private javax.swing.JCheckBox mostrarcontraseña;
    private javax.swing.JProgressBar progreso;
    public static javax.swing.JPasswordField txtpas;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}
