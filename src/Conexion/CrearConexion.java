/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
/**
 *
 * @author User
 */
public class CrearConexion {
    static Properties props = new Properties();
    String hostname= null;
    String port = null;
    String database  = null;
    String username = null;
    String password = null;
    
    
    public CrearConexion(){
        InputStream in = null;
        try{
          in = Files.newInputStream(FileSystems.getDefault().getPath("C:\\Users\\User\\OneDrive\\Documentos\\NetBeansProjects\\InovationLabs\\src\\Conexion\\Config.properties"));  
          props.load(in);
          in.close();
            
        }
                
        catch (IOException ex) {
                ex.printStackTrace();
        } finally{
            try{
                in.close();
            }catch(IOException ex){
                ex.printStackTrace();
            }
        }
           
        cargarPropiedades();
    }
      
    public void cargarPropiedades(){
        hostname = props.getProperty("hostname");
        port = props.getProperty("port");
        database = props.getProperty("database");
        username = props.getProperty("username");
        password = props.getProperty("password");
    }
    
    public Connection getConnection() throws SQLException{
        Connection conn = null;
        String jdbcUrl="jdbc:postgresql://"+this.hostname+":"+
                this.port+"/"+this.database;
        
        conn = DriverManager.getConnection(jdbcUrl,username,password);
        System.out.println("Conexion establecida");
        
        return conn;
    }
    
    
    }
    

