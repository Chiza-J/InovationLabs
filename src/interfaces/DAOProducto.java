/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import models.Producto;
import java.util.List;

/**
 *
 * @author User
 */
public interface DAOProducto {
    public void registrar(Producto usuario) throws Exception;
    public void modificar(Producto usuario) throws Exception;
    public void eliminar(Producto usuario) throws Exception;
    public List<Producto> listar() throws Exception;
}
