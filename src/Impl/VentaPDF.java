/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Impl;

import Conexion.CrearConexion;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import models.ConfigEmpresa;
import views.PanVentas;

/**
 *
 * @author User
 */
public class VentaPDF {

    private String nombreCliente;
    private String NIT;
    private String telefonoCliente;
    private String direccionCliente;

    private String fechaActual = "";
    private String nombrePDFVenta = "";

    Connection conn;
    Statement stmt = null;
    String qry = null;
    ResultSet rs;
    PreparedStatement ps;
    CrearConexion createConn = new CrearConexion();

    public void DatosCliente(int idCliente) throws Exception {
        try {
            conn = createConn.getConnection();
            qry = "SELECT * FROM cliente WHERE idCliente = ?";
            ps = conn.prepareStatement(qry);
            ps.setInt(1, idCliente);

            rs = ps.executeQuery();
            while (rs.next()) {
                nombreCliente = rs.getString("nombre") + " " + rs.getString("apellido");
                NIT = rs.getString("NIT");
                telefonoCliente = rs.getString("telefono");
                direccionCliente = rs.getString("direccion");

            }

        } catch (SQLException ex) {
            ex.printStackTrace(); // Manejo de excepciones
            throw new Exception("Error consultar cliente: " + ex.getMessage());
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

    public ConfigEmpresa obtenerConfigEmpresa() throws Exception {
        ConfigEmpresa config = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String qry = null;
        CrearConexion createConn = new CrearConexion();

        try {
            conn = createConn.getConnection();
            qry = "SELECT * FROM configEmpresa WHERE idConfig = 1"; // Suponiendo que el idConfig es 1
            ps = conn.prepareStatement(qry);
            rs = ps.executeQuery();

            if (rs.next()) {
                config = new ConfigEmpresa();
                config.setNombreEmpresa(rs.getString("nombreEmpresa"));
                config.setNIT(rs.getString("NIT"));
                config.setDireccion(rs.getString("direccion"));
                config.setRazon(rs.getString("razon"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Error al obtener configuración de empresa: " + ex.getMessage());
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
        return config;
    }

    public int obtenerUltimoIdFactura() throws Exception {
        int ultimoId = 0;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String qry = null;
        CrearConexion createConn = new CrearConexion();

        try {
            conn = createConn.getConnection();
            stmt = conn.createStatement();
            qry = "SELECT MAX(idcabeceraventa) AS ultimoId FROM cabeceraventa";
            rs = stmt.executeQuery(qry);

            if (rs.next()) {
                ultimoId = rs.getInt("ultimoId");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Error al obtener el último ID de factura: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return ultimoId;
    }

    public void GenerarFactura() throws Exception {
        try {
            Date date = new Date();
            fechaActual = new SimpleDateFormat("yyyy-MM-dd").format(date);

            String fechaNueva = "";
            for (int i = 0; i < fechaActual.length(); i++) {
                if (fechaActual.charAt(i) == '/') {
                    fechaNueva = fechaActual.replace("/", "_");
                }
            }

            nombrePDFVenta = "Venta_" + nombreCliente + "_" + fechaNueva + ".pdf";

            FileOutputStream archivo;
            File file = new File("src/pdf/" + nombrePDFVenta);
            archivo = new FileOutputStream(file);

            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();

            Image img = Image.getInstance("src/Imagenes/WhatsApp Image 2024-06-22 at 12.41.08 PM.jpeg");
            Paragraph fecha = new Paragraph();
            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLUE);
            fecha.add(Chunk.NEWLINE);

            // Obtener el ID de la última factura
            int idFactura = obtenerUltimoIdFactura();
            fecha.add("Factura: " + idFactura + "\nFecha: " + fechaActual + "\n\n");

            PdfPTable Encabezado = new PdfPTable(4);
            Encabezado.setWidthPercentage(100);
            Encabezado.getDefaultCell().setBorder(0);

            float[] ColumnaEncabezado = new float[]{20f, 30f, 70f, 40f};
            Encabezado.setWidths(ColumnaEncabezado);
            Encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);

            Encabezado.addCell(img);

            // Obtener los datos de la configuración de la empresa
            ConfigEmpresa config = obtenerConfigEmpresa();

            String nit = config != null ? config.getNIT() : "";
            String nombre = config != null ? config.getNombreEmpresa() : "";
            String direccion = config != null ? config.getDireccion() : "";
            String razon = config != null ? config.getRazon() : "";

            Encabezado.addCell("");
            Encabezado.addCell("NIT: " + nit + "\nNOMBRE: " + nombre + "\nDIRECCION: " + direccion + "\nRAZON SOCIAL: " + razon);

            Encabezado.addCell(fecha);
            doc.add(Encabezado);

            Paragraph cliente = new Paragraph();
            cliente.add(Chunk.NEWLINE);
            cliente.add("Datos del cliente: " + "\n\n");
            doc.add(cliente);

            PdfPTable tablaCliente = new PdfPTable(4);
            tablaCliente.setWidthPercentage(100);
            tablaCliente.getDefaultCell().setBorder(0);
            float[] ColumnaCliente = new float[]{25f, 45f, 30, 40f};
            tablaCliente.setWidths(ColumnaCliente);
            tablaCliente.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell cliente1 = new PdfPCell(new Phrase("NIT: ", negrita));
            PdfPCell cliente2 = new PdfPCell(new Phrase("Nombre: ", negrita));
            PdfPCell cliente3 = new PdfPCell(new Phrase("Telefono: ", negrita));
            PdfPCell cliente4 = new PdfPCell(new Phrase("Direccion: ", negrita));

            cliente1.setBorder(0);
            cliente2.setBorder(0);
            cliente3.setBorder(0);
            cliente4.setBorder(0);

            tablaCliente.addCell(cliente1);
            tablaCliente.addCell(cliente2);
            tablaCliente.addCell(cliente3);
            tablaCliente.addCell(cliente4);
            tablaCliente.addCell(NIT);
            tablaCliente.addCell(nombreCliente);
            tablaCliente.addCell(telefonoCliente);
            tablaCliente.addCell(direccionCliente);

            doc.add(tablaCliente);

            Paragraph espacio = new Paragraph();
            espacio.add(Chunk.NEWLINE);
            espacio.add("");
            espacio.setAlignment(Element.ALIGN_CENTER);
            doc.add(espacio);

            PdfPTable tablaProducto = new PdfPTable(4);
            tablaProducto.setWidthPercentage(100);
            tablaProducto.getDefaultCell().setBorder(0);
            float[] ColumnaProducto = new float[]{15f, 50f, 15f, 20f};
            tablaProducto.setWidths(ColumnaProducto);
            tablaProducto.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell producto1 = new PdfPCell(new Phrase("Cantidad: ", negrita));
            PdfPCell producto2 = new PdfPCell(new Phrase("Descripcion: ", negrita));
            PdfPCell producto3 = new PdfPCell(new Phrase("Precio Unitario: ", negrita));
            PdfPCell producto4 = new PdfPCell(new Phrase("Precio Total: ", negrita));

            producto1.setBorder(0);
            producto2.setBorder(0);
            producto3.setBorder(0);
            producto4.setBorder(0);

            producto1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto2.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto3.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto4.setBackgroundColor(BaseColor.LIGHT_GRAY);

            tablaProducto.addCell(producto1);
            tablaProducto.addCell(producto2);
            tablaProducto.addCell(producto3);
            tablaProducto.addCell(producto4);

            for (int i = 0; i < PanVentas.jTableProductos.getRowCount(); i++) {
                String producto = PanVentas.jTableProductos.getValueAt(i, 1).toString();
                String cantidad = PanVentas.jTableProductos.getValueAt(i, 2).toString();
                String precio = PanVentas.jTableProductos.getValueAt(i, 3).toString();
                String total = PanVentas.jTableProductos.getValueAt(i, 6).toString();

                tablaProducto.addCell(cantidad);
                tablaProducto.addCell(producto);
                tablaProducto.addCell(precio);
                tablaProducto.addCell(total);
            }

            doc.add(tablaProducto);

            Paragraph info = new Paragraph();
            info.add(Chunk.NEWLINE);
            info.add("Total a pagar: " + PanVentas.txtTotal.getText());
            info.setAlignment(Element.ALIGN_RIGHT);
            doc.add(info);

            Paragraph firma = new Paragraph();
            firma.add(Chunk.NEWLINE);
            firma.add("Cancelacion y firma\n\n\n\n");
            firma.add("_______________________");
            firma.setAlignment(Element.ALIGN_CENTER);
            doc.add(firma);

            Paragraph msg = new Paragraph();
            msg.add(Chunk.NEWLINE);
            msg.add("¡GRACIAS POR SU COMPRA!");

            msg.setAlignment(Element.ALIGN_CENTER);
            doc.add(msg);

            doc.close();
            archivo.close();

            Desktop.getDesktop().open(file);

        } catch (DocumentException | IOException e) {
            System.out.println("Error en: " + e);
        } catch (Exception e) {
            System.out.println("Error al obtener datos: " + e);
        }
    }
}
