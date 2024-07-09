/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import models.DetalleFactura;
import java.util.List;

/**
 *
 * @author User
 */
public interface DAODetalleFactura {
    public void registrar(DetalleFactura usuario) throws Exception;
    public void modificar(DetalleFactura usuario) throws Exception;
    //public void eliminar(DetalleFactura usuario) throws Exception;
    public List<DetalleFactura> listar() throws Exception;
}
