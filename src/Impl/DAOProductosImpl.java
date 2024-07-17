/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Impl;

import Conexion.CrearConexion;
import interfaces.DAOProducto;
import models.Producto;
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
public class DAOProductosImpl extends CrearConexion implements DAOProducto{
    
    Connection conn;
    Statement stmt=null;
    String qry=null;
    ResultSet rs;
    PreparedStatement ps;
    CrearConexion createConn = new CrearConexion();

    @Override
    public void registrar(Producto productos) throws Exception {
    Connection conn = null;
    PreparedStatement ps = null;

    try {
        conn = createConn.getConnection();
        if (conn != null) {
            String qry = "INSERT INTO producto (Nombre, PrecioUnitario, CodigoProducto, IdProveedor) VALUES (?, ?, ?, ?)";
            ps = conn.prepareStatement(qry);
            ps.setString(1, productos.getNombre());
            ps.setDouble(2, productos.getPrecioUnitario());
            ps.setString(3, productos.getCodigoProducto());
            ps.setInt(4, productos.getIdProveedor());  

            ps.executeUpdate();  
        } else {
            throw new SQLException("Failed to establish connection.");
        }
    } catch (SQLException ex) {
        ex.printStackTrace(); 
        throw new Exception("Error inserting product: " + ex.getMessage());
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
    public void modificar(Producto productos) throws Exception {
    Connection conn = null;
    PreparedStatement ps = null;

    try {
        conn = createConn.getConnection();
        if (conn != null) {
            String qry = "UPDATE producto SET Nombre = ?, precioUnitario = ?, CodigoProducto = ?, idProveedor = ? WHERE idProducto = ?";
            ps = conn.prepareStatement(qry);
            if (ps != null) {
                ps.setString(1, productos.getNombre());
                ps.setDouble(2, productos.getPrecioUnitario());
                ps.setString(3, productos.getCodigoProducto());
                ps.setInt(4, productos.getIdProveedor());
                ps.setInt(5, productos.getIdProducto());
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
        throw new Exception("Error updating Producto: " + ex.getMessage());
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
    public void eliminar(int productosId) throws Exception {
        try {
        conn = createConn.getConnection();
        qry = "DELETE FROM producto WHERE idproducto = ?";
        ps = conn.prepareStatement(qry);
        ps.setInt(1, productosId);
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
    public List<Producto> listar(String name) throws Exception {
        List<Producto> lista = null;
        try {
        conn = createConn.getConnection();
        String Query = name.isEmpty() ? "SELECT * FROM producto ORDER BY idProducto ASC;" : "SELECT * FROM producto WHERE nombre LIKE '%"+name+"%' ORDER BY idProducto ASC";
        qry = Query;
        ps = conn.prepareStatement(qry);
        lista = new ArrayList();
        rs = ps.executeQuery();
        while(rs.next()){
            Producto productos= new Producto();
            productos.setIdProducto(rs.getInt("idProducto"));
            productos.setNombre(rs.getString("nombre"));
            productos.setPrecioUnitario(rs.getDouble("precioUnitario"));
            productos.setCodigoProducto(rs.getString("codigoProducto"));
            productos.setIdProveedor(rs.getInt("idProveedor"));
            
            lista.add(productos);
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
    
public Producto getUserById(int productosId) throws Exception {
    Producto productos = new Producto();
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        conn = createConn.getConnection();
        if (conn != null) {
            String qry = "SELECT * FROM producto WHERE idproducto = ? LIMIT 1;";
            ps = conn.prepareStatement(qry);
            if (ps != null) {
                ps.setInt(1, productosId);
                rs = ps.executeQuery();
                while (rs.next()) {
                    productos.setIdProducto(rs.getInt("idProducto"));
                    productos.setNombre(rs.getString("nombre"));
                    productos.setPrecioUnitario(rs.getDouble("precioUnitario"));
                    productos.setCodigoProducto(rs.getString("codigoProducto"));
                    productos.setIdProveedor(rs.getInt("idProveedor"));
                }
            } else {
                throw new SQLException("Failed to prepare statement.");
            }
        } else {
            throw new SQLException("Failed to establish connection.");
        }
    } catch (SQLException ex) {
        ex.printStackTrace(); // Manejo de excepciones
        throw new Exception("Error retrieving Producto by ID: " + ex.getMessage());
    } finally {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    return productos;
}


    
    
}
