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
    public void registrar(Producto productos) throws Exception;
    public void modificar(Producto productos) throws Exception;
    public void eliminar(int productosId) throws Exception;
    public List<Producto> listar(String name) throws Exception;
    public Producto getUserById(int productosId) throws Exception;
}
