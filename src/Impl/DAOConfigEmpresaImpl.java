/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Impl;

import Conexion.CrearConexion;
import interfaces.DAOConfigEmpresa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import models.ConfigEmpresa;
import java.sql.ResultSet;

/**
 *
 * @author User
 */
public class DAOConfigEmpresaImpl extends Conexion.CrearConexion implements DAOConfigEmpresa {

    @Override
    public boolean actualizarConfigEmpresa(ConfigEmpresa config) throws Exception {
        boolean respuesta = false;
        Connection conn = null;
        PreparedStatement ps = null;
        String qry = null;
        CrearConexion createConn = new CrearConexion();

        try {
            conn = createConn.getConnection();
            qry = "UPDATE configEmpresa SET nombreEmpresa = ?, NIT = ?, direccion = ?, razon = ? WHERE idConfig = ?";
            ps = conn.prepareStatement(qry);
            ps.setString(1, config.getNombreEmpresa());
            ps.setString(2, config.getNIT());
            ps.setString(3, config.getDireccion());
            ps.setString(4, config.getRazon());
            ps.setInt(5, config.getIdConfig());

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
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return respuesta;
    }

    @Override
    public ConfigEmpresa obtenerConfigEmpresa(int idConfig) throws Exception {
        ConfigEmpresa config = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String qry = null;
        CrearConexion createConn = new CrearConexion();

        try {
            conn = createConn.getConnection();
            qry = "SELECT nombreEmpresa, NIT, direccion, razon FROM configEmpresa WHERE idConfig = ?";
            ps = conn.prepareStatement(qry);
            ps.setInt(1, idConfig);
            rs = ps.executeQuery();

            if (rs.next()) {
                config = new ConfigEmpresa();
                config.setIdConfig(idConfig);
                config.setNombreEmpresa(rs.getString("nombreEmpresa"));
                config.setNIT(rs.getString("NIT"));
                config.setDireccion(rs.getString("direccion"));
                config.setRazon(rs.getString("razon"));
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
        return config;
    }
}
