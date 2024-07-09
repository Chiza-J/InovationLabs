/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import models.Inventario;
import java.util.List;

/**
 *
 * @author User
 */
public interface DAOInventario {
    public void registrar(Inventario usuario) throws Exception;
    public void modificar(Inventario usuario) throws Exception;
    public void eliminar(Inventario usuario) throws Exception;
    public List<Inventario> listar() throws Exception;
}
