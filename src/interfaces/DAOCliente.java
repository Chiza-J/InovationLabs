/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import models.Cliente;
import java.util.List;

/**
 *
 * @author User
 */
public interface DAOCliente {
    public void registrar(Cliente clientes) throws Exception;
    public void modificar(Cliente clientes) throws Exception;
    public void eliminar(int clientesId) throws Exception;
    public List<Cliente> listar(String name) throws Exception;
    public Cliente getUserById(int clientesId) throws Exception;
}
