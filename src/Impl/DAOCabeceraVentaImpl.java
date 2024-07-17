/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Impl;

import Conexion.CrearConexion;
import interfaces.DAOCabeceraVenta;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import models.DetalleVenta;
import models.cabeceraVenta;

/**
 *
 * @author User
 */
public class DAOCabeceraVentaImpl extends Conexion.CrearConexion implements DAOCabeceraVenta {

    Connection conn;
    Statement stmt = null;
    String qry = null;
    ResultSet rs;
    PreparedStatement ps;
    CrearConexion createConn = new CrearConexion();

    public static int idCabeceraRegistrada;
    java.math.BigDecimal idColVar;

    @Override
    public int registrar(cabeceraVenta cabecera) throws Exception {
        int idCabeceraVenta = -1;
        try {
            conn = createConn.getConnection();
            qry = "INSERT INTO cabeceraVenta (idCliente, valorpagar, fechaventa, estado)"
                    + "VALUES(?,?,?,?)";
            ps = conn.prepareStatement(qry, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, cabecera.getIdCliente());
            ps.setDouble(2, cabecera.getValorPagar());
            ps.setDate(3, new java.sql.Date(cabecera.getFechaVenta().getTime()));
            ps.setInt(4, cabecera.getEstado());

            int affectedRows = ps.executeUpdate();

            if (affectedRows > 0) {
                rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    idCabeceraVenta = rs.getInt(1);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); // Manejo de excepciones
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return idCabeceraVenta;
    }

    @Override
    public boolean guardarDetalle(DetalleVenta venta) throws Exception {
        boolean respuesta = false;
        try {
            conn = createConn.getConnection();
            String qry = "INSERT INTO detalleVenta (idCabeceraVenta, idProducto, cantidad, PrecioUnitario, subtotal, Descuento, TotalPagar, estado)"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            ps = conn.prepareStatement(qry);
            ps.setInt(1, venta.getIdCabeceraVenta());
            ps.setInt(2, venta.getIdProducto());
            ps.setInt(3, venta.getCantidad());
            ps.setDouble(4, venta.getPrecioUnitario());
            ps.setDouble(5, venta.getSubTotal());
            ps.setDouble(6, venta.getDescuento());
            ps.setDouble(7, venta.getTotalPagar());
            ps.setInt(8, venta.getEstado());

            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                respuesta = true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            respuesta = false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return respuesta;
    }

    public int guardarCabeceraVenta(cabeceraVenta venta) throws SQLException {
        int idCabeceraVenta = -1;
        try {
            conn = createConn.getConnection();
            String qry = "INSERT INTO cabeceraVenta (IdCliente, valorPagar, fechaVenta, estado) VALUES (?, ?, ?, ?) RETURNING idCabeceraVenta";
            ps = conn.prepareStatement(qry);
            ps.setInt(1, venta.getIdCliente());
            ps.setDouble(2, venta.getValorPagar());
            ps.setDate(3, new java.sql.Date(venta.getFechaVenta().getTime()));
            ps.setInt(4, venta.getEstado());

            rs = ps.executeQuery();
            if (rs.next()) {
                idCabeceraVenta = rs.getInt(1);
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
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return idCabeceraVenta;
    }

    public int insertarCabeceraVenta(cabeceraVenta venta) {
        int idCabeceraVenta = -1;
        try {
            conn = createConn.getConnection();
            String qry = "INSERT INTO cabeceraVenta (IdCliente, valorPagar, fechaVenta, estado) VALUES (?, ?, ?, ?) RETURNING idCabeceraVenta";
            ps = conn.prepareStatement(qry);
            ps.setInt(1, venta.getIdCliente());
            ps.setDouble(2, venta.getValorPagar());
            ps.setDate(3, new java.sql.Date(venta.getFechaVenta().getTime()));
            ps.setInt(4, venta.getEstado());

            rs = ps.executeQuery();
            if (rs.next()) {
                idCabeceraVenta = rs.getInt(1);
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
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return idCabeceraVenta;
    }

}
