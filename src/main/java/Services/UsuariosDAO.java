/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;
import Config.ConexionBD;
import Model.Usuario;
import Model.Rol;
import Repository.UsuariosRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author moral
 */
public class UsuariosDAO implements UsuariosRepository {
    public void InsertarUsuario(Usuario usuario) {
        String sql = "INSERT INTO AA_RES_USUARIOS (ID_USUARIO, NOMBRE_USUARIO, CONTRASEÑA_USUARIO, ID_ROL) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, usuario.getIdUsuario());
            ps.setString(2, usuario.getNombreUsuario());
            ps.setString(3, usuario.getContraseña());
            ps.setLong(4, usuario.getIDRolUsuario());

            ps.executeUpdate();
            System.out.println("Se insertó el registro del Usuario correctamente.");

        } catch (Exception e) {
            System.out.println("Error al registrar Usuario: " + e.getMessage());
        }
    }
    public boolean EditarUsuario(Usuario usuario) {
        String sql = "UPDATE AA_RES_USUARIOS SET NOMBRE_USUARIO = ?, CONTRASEÑA_USUARIO = ?, ID_ROL = ? WHERE ID_USUARIO = ?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, usuario.getNombreUsuario());
            ps.setString(2, usuario.getContraseña());
            ps.setLong(3, usuario.getIDRolUsuario());
            
            
            ps.setLong(4, usuario.getIdUsuario());

            int filasActualizadas = ps.executeUpdate();
            if (filasActualizadas > 0) {
                System.out.println("Usuario actualizado correctamente.");
                return true;
            } else {
                System.out.println("No se encontró el usuario para actualizar.");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error al editar Usuario: " + e.getMessage());
            return false;
        }
    }
    public boolean EliminarUsuario(Usuario usuario) {
        String sql = "DELETE FROM AA_RES_USUARIOS WHERE ID_USUARIO = ?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setLong(1, usuario.getIdUsuario());
            int filasAfectadas = ps.executeUpdate();
            
            if (filasAfectadas > 0) {
                System.out.println("Usuario con ID " + usuario.getIdUsuario() + " eliminado correctamente.");
                return true;
            } else {
                System.out.println("No se encontró ningún usuario con el ID: " + usuario.getIdUsuario());
                return false;
            }
        } catch (SQLException e) {
            System.err.println("Error de SQL al intentar eliminar usuario: " + e.getMessage());
            return false;
        }
    }
    public Usuario validarUsuario(String nombre, String password) {
        Usuario user = null;
        String sql = "SELECT ID_USUARIO, NOMBRE_USUARIO, CONTRASEÑA_USUARIO, ID_ROL FROM AA_RES_USUARIOS WHERE NOMBRE_USUARIO = ? AND CONTRASEÑA_USUARIO = ?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, nombre);
        ps.setString(2, password);
        
      try (ResultSet rs = ps.executeQuery()) {
        
         if (rs.next()) {
            user = new Usuario();
            user.setIdUsuario(rs.getLong("ID_USUARIO"));
            user.setNombreUsuario(rs.getString("NOMBRE_USUARIO"));
            user.setContraseña(rs.getString("CONTRASEÑA_USUARIO"));
            user.setIDRolUsuario(rs.getLong("ID_ROL"));
         }
         }
    } catch (SQLException e) {
        System.err.println("Error al validar: " + e.getMessage());
    }
    return user; 
}
    public void ListaUsuarios() {
        String sql = "SELECT ID_USUARIO, NOMBRE_USUARIO, ID_ROL FROM AA_RES_USUARIOS ORDER BY ID_USUARIO";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("--- LISTADO DE USUARIOS ---");
            while (rs.next()) {
                System.out.println(
                    rs.getLong("ID_USUARIO") + " | " +
                    rs.getString("NOMBRE_USUARIO") + " | Rol ID: " +
                    rs.getLong("ID_ROL")
                );
            }

        } catch (Exception e) {
            System.out.println("Error al listar los Usuarios: " + e.getMessage());
        }
    }
}
