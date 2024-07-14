/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;


import Impl.DAOProveedoresImpl;
import interfaces.DAOProveedor;
import java.awt.Color;
import models.Proveedor;

/**
 *
 * @author User
 */
public class PanUPProveedores extends javax.swing.JPanel {

    
    boolean isEdition = false;
    models.Proveedor proveedorEdition;
    /**
     * Creates new form PanUPUsers
     */
    public PanUPProveedores() {
        initComponents();
        
        InitStyles();
    }
    
    public PanUPProveedores(models.Proveedor proveedores){
        initComponents();
        isEdition= true;
        proveedorEdition = proveedores;
        InitStyles();
    }
    
    private void InitStyles(){
        if(isEdition){
            introduccion.setText("Editar Proveedor");
            btnCrear.setText("GUARDAR");
            if(proveedorEdition != null){
                txtNombreEmpresa.setText(proveedorEdition.getNombreEmpresa());
                txtTelefono.setText(proveedorEdition.getTelefono());
                txtCatalogo.setText(proveedorEdition.getCatalogoProductos());
                
            }
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

        bg = new javax.swing.JPanel();
        txtCatalogo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNombreEmpresa = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        introduccion = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnCrear = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1020, 598));

        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCatalogo.setBackground(new java.awt.Color(153, 153, 153));
        txtCatalogo.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        txtCatalogo.setForeground(new java.awt.Color(255, 255, 255));
        txtCatalogo.setBorder(new javax.swing.border.MatteBorder(null));
        txtCatalogo.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        bg.add(txtCatalogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 500, 40));

        jLabel4.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel4.setText("Catalogo de Productos");
        bg.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 380, -1));

        txtTelefono.setBackground(new java.awt.Color(153, 153, 153));
        txtTelefono.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(255, 255, 255));
        txtTelefono.setBorder(new javax.swing.border.MatteBorder(null));
        txtTelefono.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        bg.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 500, 40));

        jLabel2.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel2.setText("Telefono");
        bg.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 340, -1));

        txtNombreEmpresa.setBackground(new java.awt.Color(153, 153, 153));
        txtNombreEmpresa.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        txtNombreEmpresa.setForeground(new java.awt.Color(255, 255, 255));
        txtNombreEmpresa.setBorder(new javax.swing.border.MatteBorder(null));
        txtNombreEmpresa.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        bg.add(txtNombreEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 500, 40));

        jLabel1.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel1.setText(" Nombre de la Empresa");
        bg.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 310, -1));

        introduccion.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        introduccion.setText("Registrar un nuevo Proveedor");
        bg.add(introduccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, 240, 30));
        bg.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, 670, 10));

        btnCrear.setBackground(new java.awt.Color(153, 153, 153));
        btnCrear.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnCrear.setForeground(new java.awt.Color(255, 255, 255));
        btnCrear.setText("CREAR PROVEEDOR");
        btnCrear.setBorderPainted(false);
        btnCrear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCrearMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCrearMouseExited(evt);
            }
        });
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });
        bg.add(btnCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 390, 370, 70));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearMouseEntered
        btnCrear.setBackground(new Color(53,53,53));
        btnCrear.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnCrearMouseEntered

    private void btnCrearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearMouseExited
        btnCrear.setBackground(new Color(153,153,153));
        btnCrear.setForeground(Color.black);
    }//GEN-LAST:event_btnCrearMouseExited

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        //Se convierten en variables los txt
        String nombreEm = txtNombreEmpresa.getText();
        String telefono = txtTelefono.getText();
        String catalogo = txtCatalogo.getText();
        
        
        //Futuras validaciones?
        
        models.Proveedor proveedores = isEdition ? proveedorEdition : new models.Proveedor();
        proveedores.setNombreEmpresa(nombreEm);
        proveedores.setTelefono(telefono);
        proveedores.setCatalogoProductos(catalogo);
        
        
        
        
        try {
            DAOProveedor dao = new DAOProveedoresImpl();
            if(!isEdition){
                dao.registrar(proveedores);
            }
            else{
                dao.modificar(proveedores);
            }
            
            if(!isEdition){
            txtNombreEmpresa.setText("");
            txtTelefono.setText("");
            txtCatalogo.setText("");
            
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnCrearActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnCrear;
    private javax.swing.JLabel introduccion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtCatalogo;
    private javax.swing.JTextField txtNombreEmpresa;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
