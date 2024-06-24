package Conexion;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConexion1 {
    public static void main(String[] args) {
        CrearConexion conexion = new CrearConexion();
        try {
            Connection conn = conexion.getConnection();
            if (conn != null) {
                System.out.println("¡Conexión a la base de datos exitosa!");
                conn.close();
            }//Hueco
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
