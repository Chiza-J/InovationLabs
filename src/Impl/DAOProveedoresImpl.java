/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Impl;

import Conexion.CrearConexion;
import interfaces.DAOProveedor;
import models.Proveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class DAOProveedoresImpl extends CrearConexion implements DAOProveedor{
    
    Connection conn;
    Statement stmt=null;
    String qry=null;
    ResultSet rs;
    PreparedStatement ps;
    CrearConexion createConn = new CrearConexion();

    @Override
    public void registrar(Proveedor proveedores) throws Exception {
        try {
        conn = createConn.getConnection();
        qry = "INSERT INTO proveedor (nombreEmpresa, Telefono, catalogoproductos)" +
              "VALUES(?,?,?)";
        ps = conn.prepareStatement(qry);
        ps.setString(1, proveedores.getNombreEmpresa());
        ps.setString(2, proveedores.getTelefono());
        ps.setString(3, proveedores.getCatalogoProductos());
        
        rs = ps.executeQuery();
        ps.close();
        rs.close();
        } catch (SQLException ex) {
        ex.printStackTrace(); // Manejo de excepciones
        } finally{
            conn.close();
        }
    }

    @Override
    public void modificar(Proveedor proveedores) throws Exception {
    Connection conn = null;
    PreparedStatement ps = null;

    try {
        conn = createConn.getConnection();
        if (conn != null) {
            String qry = "UPDATE proveedor SET nombreempresa = ?, telefono = ?, catalogoproductos = ? WHERE idProveedor = ?";
            ps = conn.prepareStatement(qry);
            if (ps != null) {
                ps.setString(1, proveedores.getNombreEmpresa());
                ps.setString(2, proveedores.getTelefono());
                ps.setString(3, proveedores.getCatalogoProductos());
                ps.setInt(4, proveedores.getIdProveedor());
                ps.executeUpdate();
                ps.close();
            } else {
                throw new SQLException("Failed to prepare statement.");
            }
        } else {
            throw new SQLException("Failed to establish connection.");
        }
    } catch (SQLException ex) {
        ex.printStackTrace(); // Manejo de excepciones
        throw new Exception("Error updating proveedor: " + ex.getMessage());
    } finally {
        try {
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}


    @Override
    public void eliminar(int proveedorId) throws Exception {
        try {
        conn = createConn.getConnection();
        qry = "DELETE FROM proveedor WHERE idproveedor = ?";
        ps = conn.prepareStatement(qry);
        ps.setInt(1, proveedorId);
        rs = ps.executeQuery();
        ps.close();
        rs.close();
        } catch (SQLException ex) {
        ex.printStackTrace(); // Manejo de excepciones
        } finally{
            conn.close();
        }
    }

    @Override
    public List<Proveedor> listar(String name) throws Exception {
        List<Proveedor> lista = null;
        try {
        conn = createConn.getConnection();
        String Query = name.isEmpty() ? "SELECT * FROM proveedor;" : "SELECT * FROM proveedor WHERE nombreempresa LIKE '%"+name+"%'";
        qry = Query;
        ps = conn.prepareStatement(qry);
        lista = new ArrayList();
        rs = ps.executeQuery();
        while(rs.next()){
            Proveedor proveedores= new Proveedor();
            proveedores.setIdProveedor(rs.getInt("idProveedor"));
            proveedores.setNombreEmpresa(rs.getString("nombreEmpresa"));
            proveedores.setTelefono(rs.getString("telefono"));
            proveedores.setCatalogoProductos(rs.getString("catalogoproductos"));
            
            lista.add(proveedores);
        }
        ps.close();
        rs.close();
        
        } catch (SQLException ex) {
        ex.printStackTrace(); // Manejo de excepciones
        } finally{
            conn.close();
        }
        return lista;
    }

    @Override
    
public Proveedor getUserById(int proveedorId) throws Exception {
    Proveedor proveedores = new Proveedor();
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        conn = createConn.getConnection();
        if (conn != null) {
            String qry = "SELECT * FROM proveedor WHERE idproveedor = ? LIMIT 1;";
            ps = conn.prepareStatement(qry);
            if (ps != null) {
                ps.setInt(1, proveedorId);
                rs = ps.executeQuery();
                while (rs.next()) {
                    proveedores.setIdProveedor(rs.getInt("idProveedor"));
                    proveedores.setNombreEmpresa(rs.getString("nombreEmpresa"));
                    proveedores.setTelefono(rs.getString("telefono"));
                    proveedores.setCatalogoProductos(rs.getString("catalogoProductos"));
                    
                }
            } else {
                throw new SQLException("Failed to prepare statement.");
            }
        } else {
            throw new SQLException("Failed to establish connection.");
        }
    } catch (SQLException ex) {
        ex.printStackTrace(); // Manejo de excepciones
        throw new Exception("Error retrieving proveedor by ID: " + ex.getMessage());
    } finally {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    return proveedores;
}


    
    
}
