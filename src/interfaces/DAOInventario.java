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
    public void registrar(Inventario inventarios) throws Exception;
    public void modificar(Inventario inventario) throws Exception;
    public void eliminar(int inventariosId) throws Exception;
    public List<Inventario> listar(String name) throws Exception;
    public Inventario getUserById(int inventariosId) throws Exception;
}
