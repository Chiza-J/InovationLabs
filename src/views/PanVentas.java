/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import Conexion.CrearConexion;
import Impl.DAOCabeceraVentaImpl;
import Impl.VentaPDF;
import interfaces.DAOCabeceraVenta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.DetalleVenta;
import models.cabeceraVenta;

/**
 *
 * @author User
 */
public class PanVentas extends javax.swing.JPanel {

    Connection conn;
    Statement stmt = null;
    String qry = null;
    ResultSet rs;
    PreparedStatement ps;
    CrearConexion createConn = new CrearConexion();

    private DefaultTableModel modeloDatosProductos;

    //Lista detalle de venta
    ArrayList<DetalleVenta> listaProductos = new ArrayList<>();
    private DetalleVenta producto;

    private int idCliente = 0;

    private int idProducto = 0;
    private String nombre = "";
    private int cantidadProductoStock = 0;
    private double precioUnitario = 0.0;
    private int procentajeIva = 0;
    private int cantidad = 0;
    private double subtotal = 0.0;
    private double descuento = 0.0;
    private double iva = 0.0;
    private double totalPagar = 0.0;

    //Variables calculos
    private double subtotalGeneral = 0.0;
    private double descuentoGeneral = 0.0;
    private double totalPagarGeneral = 0.0;

    private int auxIdDetalle = 1;
    int idArrayList = 0;

    /**
     * Creates new form PanVentas
     */
    public PanVentas() {
        initComponents();
        cargarClientesCombo();
        cargarProductosCombo();
        iniTabProd();

        txtEfectivo.setEnabled(false);
        btnCalcular.setEnabled(false);

        txtSubtotal.setText("0.0");
        txtDescuento.setText("0.0");
        txtTotal.setText("0.0");
    }

    private void iniTabProd() {
        modeloDatosProductos = new DefaultTableModel();
        modeloDatosProductos.addColumn("N");
        modeloDatosProductos.addColumn("Nombre");
        modeloDatosProductos.addColumn("Cantidad");
        modeloDatosProductos.addColumn("P. Unitario");
        modeloDatosProductos.addColumn("Subtotal");
        modeloDatosProductos.addColumn("Descuento");
        modeloDatosProductos.addColumn("Total Pagar");
        modeloDatosProductos.addColumn("Accion");

        this.jTableProductos.setModel(modeloDatosProductos);

    }

    private void cargarClientesCombo() {
        try {
            conn = createConn.getConnection();
            qry = "SELECT * FROM cliente";

            ps = conn.prepareStatement(qry);
            rs = ps.executeQuery();
            CombCliente1.removeAllItems();
            CombCliente1.addItem("Seleccione cliente");
            while (rs.next()) {
                CombCliente1.addItem(rs.getString("nombre") + " " + rs.getString("apellido"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void cargarProductosCombo() {
        try {
            conn = createConn.getConnection();
            qry = "SELECT * FROM producto";

            ps = conn.prepareStatement(qry);
            rs = ps.executeQuery();
            CombProducto.removeAllItems();
            CombProducto.addItem("Seleccione Producto");
            while (rs.next()) {
                CombProducto.addItem(rs.getString("nombre") + "  id:" + rs.getString("idProducto"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void listaTablaProductos() {
        this.modeloDatosProductos.setRowCount(0); // Limpiar la tabla antes de llenarla
        for (int i = 0; i < listaProductos.size(); i++) {
            Object[] fila = new Object[8];
            fila[0] = i + 1; // Número de fila
            fila[1] = listaProductos.get(i).getNombre();
            fila[2] = listaProductos.get(i).getCantidad();
            fila[3] = listaProductos.get(i).getPrecioUnitario();
            fila[4] = listaProductos.get(i).getSubTotal();
            fila[5] = listaProductos.get(i).getDescuento();
            fila[6] = listaProductos.get(i).getTotalPagar();
            fila[7] = "ELIMINAR";
            this.modeloDatosProductos.addRow(fila);
        }

        jTableProductos.setModel(modeloDatosProductos);
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
        CombProducto = new javax.swing.JComboBox<>();
        CombCliente1 = new javax.swing.JComboBox<>();
        txtCantidad = new javax.swing.JTextField();
        txtBuscarCliente1 = new javax.swing.JTextField();
        txtBuscarProducto1 = new javax.swing.JTextField();
        btnAñadir = new javax.swing.JButton();
        btnBuscarCliente1 = new javax.swing.JButton();
        btnBuscarProducto1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProductos = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtSubtotal = new javax.swing.JTextField();
        txtDescuento = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        txtEfectivo = new javax.swing.JTextField();
        txtCambio = new javax.swing.JTextField();
        btnCalcular = new javax.swing.JButton();
        btnRegistrarVenta = new javax.swing.JButton();

        jPanel1.setMinimumSize(new java.awt.Dimension(1020, 598));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel1.setText("Realizar Venta");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        jLabel2.setText("Cantidad:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 90, 70, -1));

        jLabel3.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        jLabel3.setText("Cliente:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 70, -1));

        jLabel4.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        jLabel4.setText("Producto:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 70, -1));

        CombProducto.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        CombProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione producto", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(CombProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 160, -1));

        CombCliente1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        CombCliente1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione cliente", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(CombCliente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 160, -1));

        txtCantidad.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jPanel1.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 90, 90, -1));

        txtBuscarCliente1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jPanel1.add(txtBuscarCliente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 180, -1));

        txtBuscarProducto1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jPanel1.add(txtBuscarProducto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 180, -1));

        btnAñadir.setText("Añadir Producto");
        btnAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirActionPerformed(evt);
            }
        });
        jPanel1.add(btnAñadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 90, -1, -1));

        btnBuscarCliente1.setText("Buscar");
        btnBuscarCliente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCliente1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscarCliente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, -1, -1));

        btnBuscarProducto1.setText("Buscar");
        btnBuscarProducto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProducto1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscarProducto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableProductos);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 980, 190));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 1000, 210));

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        jLabel5.setText("Subtotal: ");

        jLabel6.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        jLabel6.setText("Descuento:");

        jLabel8.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        jLabel8.setText("Total a pagar:");

        jLabel9.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        jLabel9.setText("Efectivo");

        jLabel10.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        jLabel10.setText("Cambio");

        txtSubtotal.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtSubtotal.setEnabled(false);

        txtDescuento.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtDescuento.setEnabled(false);

        txtTotal.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtTotal.setEnabled(false);

        txtEfectivo.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        txtCambio.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtCambio.setEnabled(false);

        btnCalcular.setBackground(new java.awt.Color(153, 153, 153));
        btnCalcular.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        btnCalcular.setForeground(new java.awt.Color(255, 255, 255));
        btnCalcular.setText("Calcular Cambio");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(27, 27, 27))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtEfectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCalcular)))))
                .addContainerGap(158, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtEfectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCalcular))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtCambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 350, 510, 200));

        btnRegistrarVenta.setBackground(new java.awt.Color(153, 153, 153));
        btnRegistrarVenta.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        btnRegistrarVenta.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarVenta.setText("Registrar venta");
        btnRegistrarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarVentaActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(309, 420, 140, 80));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarVentaActionPerformed
        cabeceraVenta cabeceraVenta = new cabeceraVenta();
        DAOCabeceraVenta dao = new DAOCabeceraVentaImpl();

        // Obtención de la fecha actual
        Date fechaActual = new Date();

        if (!CombCliente1.getSelectedItem().equals("Seleccione cliente")) {
            if (listaProductos.size() > 0) {
                this.ObtenerIdCliente();

                if (idCliente == 0) {
                    JOptionPane.showMessageDialog(null, "Cliente no válido");
                    return;
                }

                cabeceraVenta.setIdCliente(idCliente);
                cabeceraVenta.setValorPagar(Double.parseDouble(txtTotal.getText()));
                cabeceraVenta.setFechaVenta(fechaActual);
                cabeceraVenta.setEstado(1);

                try {
                    // Llamada al método registrar para guardar la cabecera en la base de datos
                    int idCabeceraVenta = dao.registrar(cabeceraVenta);

                    if (idCabeceraVenta > 0) {
                        JOptionPane.showMessageDialog(null, "Venta registrada con éxito");
                        //Generar factura pdf
                        VentaPDF pdf = new VentaPDF();
                        pdf.DatosCliente(idCliente);
                        pdf.GenerarFactura();

                        for (DetalleVenta elemento : listaProductos) {
                            elemento.setIdCabeceraVenta(idCabeceraVenta);
                            elemento.setEstado(1);

                            if (dao.guardarDetalle(elemento)) {
                                System.out.println("Detalle de venta registrado");
                                // Restar el stock del producto
                                this.RestarStockProductos(elemento.getIdProducto(), elemento.getCantidad());
                            } else {
                                JOptionPane.showMessageDialog(null, "Error al guardar detalle de venta");
                            }
                        }

                        // Limpiar campos y actualizar UI
                        txtSubtotal.setText("0.0");
                        txtDescuento.setText("0.0");
                        txtTotal.setText("0.0");
                        txtEfectivo.setText("0.0");
                        txtCambio.setText("0.0");

                        this.cargarClientesCombo();
                        listaProductos.clear();
                        listaTablaProductos();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al registrar la venta");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al registrar la venta");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione al menos 1 producto");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un cliente");
        }
    }//GEN-LAST:event_btnRegistrarVentaActionPerformed

    private void btnBuscarCliente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCliente1ActionPerformed
        try {
            String clienteBuscar = txtBuscarCliente1.getText().trim();
            conn = createConn.getConnection();
            qry = "SELECT nombre, apellido FROM cliente WHERE nit = ?";
            ps = conn.prepareStatement(qry);
            ps.setString(1, (clienteBuscar));

            rs = ps.executeQuery();

            if (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String nombreCompleto = nombre + " " + apellido;
                CombCliente1.setSelectedItem(nombreCompleto);
                CombCliente1.repaint();

            } else {
                CombCliente1.setSelectedItem("Seleccione cliente");
                JOptionPane.showMessageDialog(null, "NIT no encontrado");

            }
            txtBuscarCliente1.setText("");

        } catch (SQLException ex) {
            ex.printStackTrace();
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
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnBuscarCliente1ActionPerformed

    private void btnBuscarProducto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProducto1ActionPerformed
        try {
            String productoBuscar = txtBuscarProducto1.getText().trim();
            conn = createConn.getConnection();
            String qry = "SELECT * FROM producto WHERE idProducto = ?";
            ps = conn.prepareStatement(qry);

            // Si el idProducto es un número en la base de datos, usa setInt en lugar de setString
            ps.setInt(1, Integer.parseInt(productoBuscar));

            rs = ps.executeQuery();

            if (rs.next()) {
                String nombre = rs.getString("nombre");
                int id = rs.getInt("idProducto");
                String nombreCompleto = nombre + " " + id;

                // Agregar el ítem si no existe en el ComboBox
                if (((DefaultComboBoxModel<String>) CombProducto.getModel()).getIndexOf(nombreCompleto) == -1) {
                    CombProducto.addItem(nombreCompleto);
                }

                CombProducto.setSelectedItem(nombreCompleto);
                CombProducto.repaint();
            } else {
                CombProducto.setSelectedItem("Seleccione Producto");
                JOptionPane.showMessageDialog(null, "ID no encontrado");
            }
            txtBuscarProducto1.setText("");

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "El ID debe ser un número");
        } finally {
            try {
                if (rs != null) {
                    rs.close(); // Cerrar ResultSet
                }
                if (ps != null) {
                    ps.close(); // Cerrar PreparedStatement
                }
                if (conn != null) {
                    conn.close(); // Cerrar Connection
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }


    }//GEN-LAST:event_btnBuscarProducto1ActionPerformed

    private void btnAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirActionPerformed
        String combo = this.CombProducto.getSelectedItem().toString();

        if (combo.equalsIgnoreCase("Seleccione Producto")) {
            JOptionPane.showMessageDialog(null, "Seleccione un producto");
        } else {
            if (!txtCantidad.getText().isEmpty()) {
                boolean validacion = validar(txtCantidad.getText());
                if (validacion) {
                    if (Integer.parseInt(txtCantidad.getText()) > 0) {
                        cantidad = Integer.parseInt(txtCantidad.getText());
                        this.datosDelProducto(); // Asegúrate de que este método actualiza cantidadProductoStock correctamente

                        if (cantidad <= cantidadProductoStock) {
                            subtotal = cantidad * precioUnitario;
                            totalPagar = subtotal + descuento;

                            subtotal = (double) Math.round(subtotal * 100) / 100;
                            descuento = (double) Math.round(descuento * 100) / 100;
                            totalPagar = (double) Math.round(totalPagar * 100) / 100;

                            producto = new DetalleVenta(auxIdDetalle,
                                    1,
                                    idProducto,
                                    nombre,
                                    Integer.parseInt(txtCantidad.getText()),
                                    precioUnitario,
                                    subtotal,
                                    descuento,
                                    totalPagar,
                                    1
                            );

                            listaProductos.add(producto);
                            JOptionPane.showMessageDialog(null, "Producto Agregado");
                            auxIdDetalle++;
                            txtCantidad.setText("");
                            this.cargarProductosCombo();

                            this.CalcularTotalPagar();
                            txtEfectivo.setEnabled(true);
                            btnCalcular.setEnabled(true);

                        } else {
                            JOptionPane.showMessageDialog(null, "La cantidad excede al stock disponible");
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "La cantidad no puede ser negativa o cero");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "En la cantidad no se admiten caracteres no numericos");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese la cantidad de productos");
            }
        }
        listaTablaProductos();

    }//GEN-LAST:event_btnAñadirActionPerformed

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        if (!txtEfectivo.getText().isEmpty()) {
            boolean validacion = validarDouble(txtEfectivo.getText());
            if (validacion == true) {
                double efe = Double.parseDouble(txtEfectivo.getText().trim());
                double top = Double.parseDouble(txtTotal.getText().trim());

                if (efe < top) {
                    JOptionPane.showMessageDialog(null, "El efectivo no es suficiente");
                    txtCambio.setText("");
                } else {
                    double cambio = efe - top;
                    double cam = (double) Math.round(cambio * 100) / 100;
                    String camb = String.valueOf(cam);
                    txtCambio.setText(camb);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se admiten caracteres no numericos en el campo Efectivo");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese el dinero en Efectivo");
        }
    }//GEN-LAST:event_btnCalcularActionPerformed

    private void jTableProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProductosMouseClicked
        int puntoFila = jTableProductos.rowAtPoint(evt.getPoint());
        int puntoColumna = 0;
        if (puntoFila > -1) {
            idArrayList = (int) modeloDatosProductos.getValueAt(puntoFila, puntoColumna);
        }

        int opcion = JOptionPane.showConfirmDialog(null, "ELIMINAR PRODUCTO");

        switch (opcion) {
            case 0:
                listaProductos.remove(idArrayList - 1);
                this.CalcularTotalPagar();
                this.listaTablaProductos();
                break;

            case 1:
                break;
            default:
                break;
        }
    }//GEN-LAST:event_jTableProductosMouseClicked

    private boolean validar(String valor) {
        try {
            int num = Integer.parseInt(valor);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean validarDouble(String valor) {
        try {
            double num = Double.parseDouble(valor);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private void datosDelProducto() {
        try {
            conn = createConn.getConnection();

            // Obtener el nombre del producto seleccionado
            String seleccionado = (String) this.CombProducto.getSelectedItem();
            System.out.println("Producto seleccionado: " + seleccionado);

            // Extraer el nombre del producto del valor seleccionado en el ComboBox
            String productoSeleccionado = seleccionado.split("  id:")[0].trim();
            System.out.println("Nombre del producto extraído: " + productoSeleccionado);

            // Consulta para obtener el idProducto usando el nombre del producto
            String qryProducto = "SELECT IdProducto, Nombre, PrecioUnitario FROM Producto WHERE Nombre = ?";
            ps = conn.prepareStatement(qryProducto);
            ps.setString(1, productoSeleccionado);

            rs = ps.executeQuery();

            if (rs.next()) {
                idProducto = rs.getInt("IdProducto");
                nombre = rs.getString("Nombre");
                precioUnitario = rs.getDouble("PrecioUnitario");
                System.out.println("Producto encontrado: " + nombre + ", IdProducto: " + idProducto + ", PrecioUnitario: " + precioUnitario);
            } else {
                System.out.println("Producto no encontrado en la tabla Producto.");
            }

            rs.close();
            ps.close();

            if (idProducto != -1) {
                // Consulta para obtener la cantidad disponible en el inventario usando el idProducto
                String qryInventario = "SELECT CantidadDisponible FROM Inventario WHERE IdProducto = ?";
                ps = conn.prepareStatement(qryInventario);
                ps.setInt(1, idProducto);

                rs = ps.executeQuery();

                if (rs.next()) {
                    cantidadProductoStock = rs.getInt("CantidadDisponible"); // Obtener cantidad disponible del inventario
                    System.out.println("Cantidad disponible en inventario: " + cantidadProductoStock);
                } else {
                    System.out.println("Producto no encontrado en el inventario.");
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
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
                ex.printStackTrace();
            }
        }
    }

    private void CalcularTotalPagar() {
        subtotalGeneral = 0;
        descuentoGeneral = 0;
        totalPagarGeneral = 0;

        for (DetalleVenta elemento : listaProductos) {
            subtotalGeneral += elemento.getSubTotal();
            descuentoGeneral += elemento.getDescuento();
            totalPagarGeneral += elemento.getTotalPagar();
        }
        subtotalGeneral = (double) Math.round(subtotalGeneral * 100) / 100;
        descuentoGeneral = (double) Math.round(descuentoGeneral * 100) / 100;
        totalPagarGeneral = (double) Math.round(totalPagarGeneral * 100) / 100;

        txtSubtotal.setText(String.valueOf(subtotalGeneral));
        txtDescuento.setText(String.valueOf(descuentoGeneral));
        txtTotal.setText(String.valueOf(totalPagarGeneral));
    }

    private void ObtenerIdCliente() {
        try {
            conn = createConn.getConnection();
            String qry = "SELECT idCliente FROM cliente WHERE concat(nombre, ' ', apellido) = ?";
            ps = conn.prepareStatement(qry);
            ps.setString(1, (String) this.CombCliente1.getSelectedItem());
            rs = ps.executeQuery();

            if (rs.next()) {
                idCliente = rs.getInt("idCliente");
            } else {
                JOptionPane.showMessageDialog(null, "Cliente no encontrado");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
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
                ex.printStackTrace();
            }
        }

    }

    private void RestarStockProductos(int IdProducto, int cantidad) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String qry = null;
        CrearConexion createConn = new CrearConexion();
        int cantidadRestante = cantidad;

        try {
            conn = createConn.getConnection();

            while (cantidadRestante > 0) {
                // Obtener el primer registro de inventario con cantidad disponible para el producto dado
                qry = "SELECT idInventario, cantidadDisponible FROM inventario WHERE idProducto = ? AND cantidadDisponible > 0 ORDER BY idInventario ASC LIMIT 1";
                ps = conn.prepareStatement(qry);
                ps.setInt(1, IdProducto);
                rs = ps.executeQuery();

                if (rs.next()) {
                    int idInventario = rs.getInt("idInventario");
                    int cantidadDisponible = rs.getInt("cantidadDisponible");

                    // Calcular la nueva cantidad disponible y la cantidad restante a restar
                    int cantidadNueva = cantidadDisponible - cantidadRestante;
                    if (cantidadNueva < 0) {
                        cantidadRestante = -cantidadNueva;
                        cantidadNueva = 0;
                    } else {
                        cantidadRestante = 0;
                    }

                    // Actualizar la cantidad disponible en la base de datos
                    qry = "UPDATE inventario SET cantidadDisponible = ? WHERE idInventario = ?";
                    ps = conn.prepareStatement(qry);
                    ps.setInt(1, cantidadNueva);
                    ps.setInt(2, idInventario);
                    ps.executeUpdate();
                } else {
                    System.out.println("No hay suficiente stock disponible para el producto.");
                    break;
                }
            }

            if (cantidadRestante > 0) {
                System.out.println("No se pudo restar toda la cantidad solicitada, falta: " + cantidadRestante);
            } else {
                System.out.println("Stock actualizado correctamente");
            }

        } catch (SQLException e) {
            System.out.println("Error al restar stock: " + e);
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
                ex.printStackTrace();
            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CombCliente1;
    private javax.swing.JComboBox<String> CombProducto;
    private javax.swing.JButton btnAñadir;
    private javax.swing.JButton btnBuscarCliente1;
    private javax.swing.JButton btnBuscarProducto1;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnRegistrarVenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTableProductos;
    private javax.swing.JTextField txtBuscarCliente1;
    private javax.swing.JTextField txtBuscarProducto1;
    private javax.swing.JTextField txtCambio;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtDescuento;
    private javax.swing.JTextField txtEfectivo;
    private javax.swing.JTextField txtSubtotal;
    public static javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
