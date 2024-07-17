/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.sql.SQLException;
import models.cabeceraVenta;
import java.util.List;
import models.DetalleVenta;

/**
 *
 * @author User
 */
public interface DAOCabeceraVenta {
    public int registrar(cabeceraVenta cabecera) throws Exception;
    public boolean guardarDetalle(DetalleVenta venta) throws Exception;
    public int guardarCabeceraVenta(cabeceraVenta venta) throws SQLException;
    //public void eliminar(int clientesId) throws Exception;
    //public List<Cliente> listar(String name) throws Exception;
  //public Cliente getUserById(int clientesId) throws Exception;
}
