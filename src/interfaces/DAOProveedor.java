/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import models.Proveedor;
import java.util.List;

/**
 *
 * @author User
 */
public interface DAOProveedor {
    public void registrar(Proveedor usuario) throws Exception;
    public void modificar(Proveedor usuario) throws Exception;
    public void eliminar(Proveedor usuario) throws Exception;
    public List<Proveedor> listar() throws Exception;
}
