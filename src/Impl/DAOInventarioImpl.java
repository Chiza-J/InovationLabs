/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Impl;

import Conexion.CrearConexion;
import interfaces.DAOInventario;
import models.Inventario;
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
public class DAOInventarioImpl extends CrearConexion implements DAOInventario{
    
    Connection conn;
    Statement stmt=null;
    String qry=null;
    ResultSet rs;
    PreparedStatement ps;
    CrearConexion createConn = new CrearConexion();

    @Override
    public void registrar(Inventario inventarios) throws Exception {
        try {
        conn = createConn.getConnection();
        qry = "INSERT INTO inventario ( IdProducto, CantidadDisponible, FechaCaducidad)" +
              "VALUES(?,?,?)";
        ps = conn.prepareStatement(qry);
        ps.setInt(1, inventarios.getIdProducto());
        ps.setInt(2, inventarios.getCantidadDisponible());
        ps.setDate(3, inventarios.getFechaCaducidad());
        
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
    public void modificar(Inventario inventarios) throws Exception {
    Connection conn = null;
    PreparedStatement ps = null;

    try {
        conn = createConn.getConnection();
        if (conn != null) {
            String qry = "UPDATE inventario SET IdProducto = ?, CantidadDisponible = ?, FechaCaducidad = ?"
                    + " WHERE idInventario = ?";
            ps = conn.prepareStatement(qry);
            if (ps != null) {
                ps.setInt(1, inventarios.getIdProducto());
                ps.setInt(2, inventarios.getCantidadDisponible());
                ps.setDate(3, inventarios.getFechaCaducidad());
                ps.setInt(4, inventarios.getIdInventario());
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
        throw new Exception("Error updating Inventario: " + ex.getMessage());
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
    public void eliminar(int inventariosId) throws Exception {
        try {
        conn = createConn.getConnection();
        qry = "DELETE FROM inventario WHERE idinventario = ?";
        ps = conn.prepareStatement(qry);
        ps.setInt(1, inventariosId);
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
    public List<Inventario> listar(String name) throws Exception {
        List<Inventario> lista = null;
        try {
        conn = createConn.getConnection();
        String Query = name.isEmpty() ? "SELECT * FROM inventario ORDER BY idInventario ASC;" : "SELECT * FROM inventario WHERE idproducto LIKE '%"+name+"%' ORDER BY idInventario ASC";
        qry = Query;
        ps = conn.prepareStatement(qry);
        lista = new ArrayList();
        rs = ps.executeQuery();
        while(rs.next()){
            Inventario inventarios= new Inventario();
            inventarios.setIdInventario(rs.getInt("idInventario"));
            inventarios.setIdProducto(rs.getInt("idProducto"));
            inventarios.setCantidadDisponible(rs.getInt("cantidadDisponible"));
            inventarios.setFechaCaducidad(rs.getDate("fechaCaducidad"));
            
            lista.add(inventarios);
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
    
public Inventario getUserById(int inventariosId) throws Exception {
    Inventario inventarios = new Inventario();
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        conn = createConn.getConnection();
        if (conn != null) {
            String qry = "SELECT * FROM inventario WHERE idinventario = ? LIMIT 1;";
            ps = conn.prepareStatement(qry);
            if (ps != null) {
                ps.setInt(1, inventariosId);
                rs = ps.executeQuery();
                while (rs.next()) {
                    inventarios.setIdInventario(rs.getInt("idInventario"));
                    inventarios.setIdProducto(rs.getInt("idProducto"));
                    inventarios.setCantidadDisponible(rs.getInt("cantidadDisponible"));
                    inventarios.setFechaCaducidad(rs.getDate("fechaCaducidad"));
                    
                }
            } else {
                throw new SQLException("Failed to prepare statement.");
            }
        } else {
            throw new SQLException("Failed to establish connection.");
        }
    } catch (SQLException ex) {
        ex.printStackTrace(); // Manejo de excepciones
        throw new Exception("Error retrieving Inventario by ID: " + ex.getMessage());
    } finally {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    return inventarios;
}


    
    
}
