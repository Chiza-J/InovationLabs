/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import models.ConfigEmpresa;

/**
 *
 * @author User
 */
public interface DAOConfigEmpresa {
    boolean actualizarConfigEmpresa(ConfigEmpresa config) throws Exception;
    ConfigEmpresa obtenerConfigEmpresa(int idConfig) throws Exception;
}
