/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Impl;

import Conexion.CrearConexion;
import interfaces.DAOCliente;
import models.Cliente;
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
public class DAOClientessImpl extends CrearConexion implements DAOCliente{
    
    Connection conn;
    Statement stmt=null;
    String qry=null;
    ResultSet rs;
    PreparedStatement ps;
    CrearConexion createConn = new CrearConexion();

    @Override
    public void registrar(Cliente clientes) throws Exception {
        try {
        conn = createConn.getConnection();
        qry = "INSERT INTO cliente (Nombre, Apellido, Telefono, Direccion, CorreoElectronico, NIT)" +
              "VALUES(?,?,?,?,?,?)";
        ps = conn.prepareStatement(qry);
        ps.setString(1, clientes.getNombre());
        ps.setString(2, clientes.getApellido());
        ps.setString(3, clientes.getTelefono());
        ps.setString(4, clientes.getDireccion());
        ps.setString(5, clientes.getCorreloElectronico());
        ps.setString(6, clientes.getNit());
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
    public void modificar(Cliente clientes) throws Exception {
    Connection conn = null;
    PreparedStatement ps = null;

    try {
        conn = createConn.getConnection();
        if (conn != null) {
            String qry = "UPDATE cliente SET Nombre = ?, Apellido = ?, Telefono = ?, Direccion = ?, CorreoElectronico = ?, Nit = ? WHERE idCliente = ?";
            ps = conn.prepareStatement(qry);
            if (ps != null) {
                ps.setString(1, clientes.getNombre());
                ps.setString(2, clientes.getApellido());
                ps.setString(3, clientes.getTelefono());
                ps.setString(4, clientes.getDireccion());
                ps.setString(5, clientes.getCorreloElectronico());
                ps.setString(6, clientes.getNit());
                ps.setInt(7, clientes.getIdCliente());
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
        throw new Exception("Error updating client: " + ex.getMessage());
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
    public void eliminar(int clientesId) throws Exception {
        try {
        conn = createConn.getConnection();
        qry = "DELETE FROM cliente WHERE idcliente = ?";
        ps = conn.prepareStatement(qry);
        ps.setInt(1, clientesId);
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
    public List<Cliente> listar(String name) throws Exception {
        List<Cliente> lista = null;
        try {
        conn = createConn.getConnection();
        String Query = name.isEmpty() ? "SELECT * FROM cliente;" : "SELECT * FROM cliente WHERE nombre LIKE '%"+name+"%'";
        qry = Query;
        ps = conn.prepareStatement(qry);
        lista = new ArrayList();
        rs = ps.executeQuery();
        while(rs.next()){
            Cliente clientes= new Cliente();
            clientes.setIdCliente(rs.getInt("idCliente"));
            clientes.setNombre(rs.getString("nombre"));
            clientes.setApellido(rs.getString("apellido"));
            clientes.setTelefono(rs.getString("telefono"));
            clientes.setDireccion(rs.getString("direccion"));
            clientes.setCorreloElectronico(rs.getString("CorreoElectronico"));
            clientes.setNit(rs.getString("nit"));
            lista.add(clientes);
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
    
public Cliente getUserById(int clientesId) throws Exception {
    Cliente clientes = new Cliente();
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        conn = createConn.getConnection();
        if (conn != null) {
            String qry = "SELECT * FROM cliente WHERE idcliente = ? LIMIT 1;";
            ps = conn.prepareStatement(qry);
            if (ps != null) {
                ps.setInt(1, clientesId);
                rs = ps.executeQuery();
                while (rs.next()) {
                    clientes.setIdCliente(rs.getInt("idCliente"));
                    clientes.setNombre(rs.getString("nombre"));
                    clientes.setApellido(rs.getString("apellido"));
                    clientes.setTelefono(rs.getString("telefono"));
                    clientes.setDireccion(rs.getString("direccion"));
                    clientes.setCorreloElectronico(rs.getString("CorreoElectronico"));
                    clientes.setNit(rs.getString("nit"));
                }
            } else {
                throw new SQLException("Failed to prepare statement.");
            }
        } else {
            throw new SQLException("Failed to establish connection.");
        }
    } catch (SQLException ex) {
        ex.printStackTrace(); // Manejo de excepciones
        throw new Exception("Error retrieving user by ID: " + ex.getMessage());
    } finally {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    return clientes;
}


    
    
}
