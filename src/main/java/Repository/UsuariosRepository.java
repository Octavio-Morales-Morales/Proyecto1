/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import Model.Usuario;
import java.util.List;



/**
 *
 * @author moral
 */
public interface UsuariosRepository {
   void InsertarUsuario(Usuario usuario);
   boolean EditarUsuario(Usuario usuario);
   boolean EliminarUsuario(Usuario usuario);
  Usuario validarUsuario(long idUsuario, String password);
  List<Usuario> obtenerListaUsuarios();
 
}
