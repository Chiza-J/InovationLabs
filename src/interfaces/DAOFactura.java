/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import models.Factura;
import java.util.List;

/**
 *
 * @author User
 */
public interface DAOFactura {
    public void registrar(Factura usuario) throws Exception;
    public void modificar(Factura usuario) throws Exception;
    //public void eliminar(Factura usuario) throws Exception;
    public List<Factura> listar() throws Exception;
}
