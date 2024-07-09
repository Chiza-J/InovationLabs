/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import models.Usuarios;
import java.util.List;

/**
 *
 * @author User
 */
public interface DAOUsuario {
    public void registrar(Usuarios usuario) throws Exception;
    public void modificar(Usuarios usuario) throws Exception;
    public void eliminar(int userId) throws Exception;
    public List<Usuarios> listar() throws Exception;
    public Usuarios getUserById(int userId) throws Exception;
}
