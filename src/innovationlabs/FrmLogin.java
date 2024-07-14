/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package innovationlabs;

import Conexion.CrearConexion;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author User
 */
public class FrmLogin extends javax.swing.JFrame {

    int xMouse, yMouse;
    Connection conn;
    Statement stmt=null;
    String qry=null;
    ResultSet rs;
    PreparedStatement ps;
    CrearConexion createConn = new CrearConexion();
    
    public FrmLogin() {
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

        BG = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        logo = new javax.swing.JLabel();
        LabelTtulo = new javax.swing.JLabel();
        InicioLabel = new javax.swing.JLabel();
        usuarioLabel = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        contrasenaLabel = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JPanel();
        txtloginbtn = new javax.swing.JLabel();
        header = new javax.swing.JPanel();
        btnClose = new javax.swing.JPanel();
        labelX = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        BG.setBackground(new java.awt.Color(225, 225, 225));
        BG.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        BG.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 360, 10));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        BG.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 360, 20));

        logo.setBackground(new java.awt.Color(255, 255, 255));
        logo.setForeground(new java.awt.Color(255, 255, 255));
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/WhatsApp Image 2024-06-22 at 12.41.08 PM.jpeg"))); // NOI18N
        BG.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 430, 320));

        LabelTtulo.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        LabelTtulo.setText("INOVATION LABS");
        BG.add(LabelTtulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        InicioLabel.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        InicioLabel.setText("INICIAR SESION");
        BG.add(InicioLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        usuarioLabel.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        usuarioLabel.setText("USUARIO");
        BG.add(usuarioLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        txtUsuario.setBackground(new java.awt.Color(225, 225, 225));
        txtUsuario.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(153, 153, 153));
        txtUsuario.setText("Ingrese su nombre de usuario");
        txtUsuario.setBorder(null);
        txtUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtUsuarioMousePressed(evt);
            }
        });
        BG.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 360, 40));

        contrasenaLabel.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        contrasenaLabel.setText("CONTRASEÑA");
        BG.add(contrasenaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

        txtPassword.setBackground(new java.awt.Color(225, 225, 225));
        txtPassword.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(153, 153, 153));
        txtPassword.setText("********");
        txtPassword.setBorder(null);
        txtPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtPasswordMousePressed(evt);
            }
        });
        BG.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 292, 360, 30));

        btnLogin.setBackground(new java.awt.Color(102, 102, 102));

        txtloginbtn.setBackground(new java.awt.Color(102, 102, 102));
        txtloginbtn.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        txtloginbtn.setForeground(new java.awt.Color(255, 255, 255));
        txtloginbtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtloginbtn.setText("ENTRAR");
        txtloginbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtloginbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtloginbtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtloginbtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtloginbtnMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnLoginLayout = new javax.swing.GroupLayout(btnLogin);
        btnLogin.setLayout(btnLoginLayout);
        btnLoginLayout.setHorizontalGroup(
            btnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtloginbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );
        btnLoginLayout.setVerticalGroup(
            btnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtloginbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        BG.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 170, 50));

        header.setBackground(new java.awt.Color(225, 225, 225));
        header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerMouseDragged(evt);
            }
        });
        header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerMousePressed(evt);
            }
        });

        btnClose.setBackground(new java.awt.Color(225, 225, 225));
        btnClose.setPreferredSize(new java.awt.Dimension(50, 50));

        labelX.setBackground(new java.awt.Color(102, 102, 102));
        labelX.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        labelX.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelX.setText("X");
        labelX.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelX.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        labelX.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelXMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelXMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelXMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnCloseLayout = new javax.swing.GroupLayout(btnClose);
        btnClose.setLayout(btnCloseLayout);
        btnCloseLayout.setHorizontalGroup(
            btnCloseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnCloseLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelX, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btnCloseLayout.setVerticalGroup(
            btnCloseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelX, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 750, Short.MAX_VALUE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        BG.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BG, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_headerMouseDragged

    private void labelXMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelXMouseClicked
        System.exit(0);
    }//GEN-LAST:event_labelXMouseClicked

    private void labelXMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelXMouseEntered
        btnClose.setBackground(Color.red);
        labelX.setForeground(Color.white);
    }//GEN-LAST:event_labelXMouseEntered

    private void labelXMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelXMouseExited
        btnClose.setBackground(new Color(225,225,225));
        labelX.setForeground(Color.BLACK);
    }//GEN-LAST:event_labelXMouseExited

    private void txtloginbtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtloginbtnMouseEntered
        btnLogin.setBackground(Color.BLACK);
    }//GEN-LAST:event_txtloginbtnMouseEntered

    private void txtloginbtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtloginbtnMouseExited
        btnLogin.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_txtloginbtnMouseExited

    private void txtUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUsuarioMousePressed
        if (txtUsuario.getText().equals("Ingrese su nombre de usuario")){
        txtUsuario.setText("");
        txtUsuario.setForeground(Color.BLACK);
        }
        if (String.valueOf(txtPassword.getPassword()).isEmpty())
        txtPassword.setText("********");
        txtPassword.setForeground(Color.GRAY);
    }//GEN-LAST:event_txtUsuarioMousePressed

    private void txtPasswordMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPasswordMousePressed
        if(String.valueOf(txtPassword.getPassword()).equals("********")){
        txtPassword.setText("");
        txtPassword.setForeground(Color.black);
        }
        if(txtUsuario.getText().isEmpty()){
        txtUsuario.setText("Ingrese su nombre de usuario");
        txtUsuario.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txtPasswordMousePressed

    private void txtloginbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtloginbtnMouseClicked
        try {
    conn = createConn.getConnection();
    qry = "SELECT * FROM usuario WHERE usuario = ? AND contraseña = ?";
    ps = conn.prepareStatement(qry);
    ps.setString(1, txtUsuario.getText());
    ps.setString(2, String.valueOf(txtPassword.getPassword()));
    rs = ps.executeQuery();
    int contador = 0;
    while (rs.next()) {
        contador++;
    }
    if (contador > 0) {
        FrmDashboard frmDashboard = new FrmDashboard();
        frmDashboard.setVisible(true);
        this.dispose();
    }
} catch (SQLException ex) {
    ex.printStackTrace(); // Manejo de excepciones
} finally {
    try {
        if (rs != null) {
            rs.close();
        }
        if (ps != null) {
            ps.close();
        }
        if (conn != null) {
            conn.close();
        }
    } catch (SQLException ex) {
        ex.printStackTrace(); // Manejo de excepciones de cierre
    }
}
    }//GEN-LAST:event_txtloginbtnMouseClicked

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
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BG;
    private javax.swing.JLabel InicioLabel;
    private javax.swing.JLabel LabelTtulo;
    private javax.swing.JPanel btnClose;
    private javax.swing.JPanel btnLogin;
    private javax.swing.JLabel contrasenaLabel;
    private javax.swing.JPanel header;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelX;
    private javax.swing.JLabel logo;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JLabel txtloginbtn;
    private javax.swing.JLabel usuarioLabel;
    // End of variables declaration//GEN-END:variables
}
