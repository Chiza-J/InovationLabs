/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Impl;

import Conexion.CrearConexion;
import interfaces.DAOUsuario;
import models.Usuarios;
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
public class DAOUsuariosImpl extends CrearConexion implements DAOUsuario{
    
    Connection conn;
    Statement stmt=null;
    String qry=null;
    ResultSet rs;
    PreparedStatement ps;
    CrearConexion createConn = new CrearConexion();

    @Override
    public void registrar(Usuarios usuario) throws Exception {
        try {
        conn = createConn.getConnection();
        qry = "INSERT INTO usuario (Usuario, Contraseña, CorreoElectronico, Nombre, Apellido, Telefono)" +
              "VALUES(?,?,?,?,?,?)";
        ps = conn.prepareStatement(qry);
        ps.setString(1, usuario.getUsuario());
        ps.setString(2, usuario.getContrasena());
        ps.setString(3, usuario.getCorreoElectronico());
        ps.setString(4, usuario.getNombre());
        ps.setString(5, usuario.getApellido());
        ps.setString(6, usuario.getTelefono());
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
    public void modificar(Usuarios usuario) throws Exception {
        try {
        conn = createConn.getConnection();
        qry = "UPDATE usuario SET Usuario= ?, Contraseña = ?, CorreoElectronico = ?, Nombre =?, Apellido =?, Telefono=? where idusuario = ?" ;
        ps = conn.prepareStatement(qry);
        ps.setString(1, usuario.getUsuario());
        ps.setString(2, usuario.getContrasena());
        ps.setString(3, usuario.getCorreoElectronico());
        ps.setString(4, usuario.getNombre());
        ps.setString(5, usuario.getApellido());
        ps.setString(6, usuario.getTelefono());
        ps.setInt(7, Usuarios.getUserByID);
        ps.executeUpdate();
        ps.close();
        
        } catch (SQLException ex) {
        ex.printStackTrace(); // Manejo de excepciones
        } finally{
            conn.close();
        }
    }

    @Override
    public void eliminar(int userId) throws Exception {
        try {
        conn = createConn.getConnection();
        qry = "DELETE FROM usuario WHERE idusuario = ?";
        ps = conn.prepareStatement(qry);
        ps.setInt(1, userId);
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
    public List<Usuarios> listar() throws Exception {
        List<Usuarios> lista = null;
        try {
        conn = createConn.getConnection();
        qry = "SELECT * FROM usuario;";
        ps = conn.prepareStatement(qry);
        lista = new ArrayList();
        rs = ps.executeQuery();
        while(rs.next()){
            Usuarios usuario= new Usuarios();
            usuario.setIdUsuario(rs.getInt("idusuario"));
            usuario.setUsuario(rs.getString("usuario"));
            usuario.setContrasena(rs.getString("contraseña"));
            usuario.setCorreoElectronico(rs.getString("correoelectronico"));
            usuario.setNombre(rs.getString("nombre"));
            usuario.setApellido(rs.getString("apellido"));
            usuario.setTelefono(rs.getString("telefono"));
            lista.add(usuario);
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
    public Usuarios getUserById(int userId) throws Exception {
        Usuarios usuario = new Usuarios();
        try {
        conn = createConn.getConnection();
        qry = "SELECT * FROM usuario WHERE idusuario = ? LIMIT 1;";
        ps = conn.prepareStatement(qry);
        ps.setInt(1, userId);
        
        rs = ps.executeQuery();
        while(rs.next()){
            usuario.setIdUsuario(rs.getInt("idusuario"));
            usuario.setUsuario(rs.getString("usuario"));
            usuario.setContrasena(rs.getString("contraseña"));
            usuario.setCorreoElectronico(rs.getString("correoelectronico"));
            usuario.setNombre(rs.getString("nombre"));
            usuario.setApellido(rs.getString("apellido"));
            usuario.setTelefono(rs.getString("telefono"));
        }
        ps.close();
        rs.close();
        
        } catch (SQLException ex) {
        ex.printStackTrace(); // Manejo de excepciones
        } finally{
            conn.close();
        }
        return usuario;
    }

    
    
}
