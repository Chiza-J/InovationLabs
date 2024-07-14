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
    public void registrar(Proveedor proveedores) throws Exception;
    public void modificar(Proveedor proveedores) throws Exception;
    public void eliminar(int proveedorId) throws Exception;
    public List<Proveedor> listar(String name) throws Exception;
    public Proveedor getUserById(int proveedorId) throws Exception;
}
