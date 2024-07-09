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
    public void registrar(Cliente usuario) throws Exception;
    public void modificar(Cliente usuario) throws Exception;
    public void eliminar(Cliente usuario) throws Exception;
    public List<Cliente> listar() throws Exception;
}
